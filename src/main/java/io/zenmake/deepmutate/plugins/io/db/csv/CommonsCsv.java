package io.zenmake.deepmutate.plugins.io.db.csv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationIO;
import io.zenmake.deepmutate.plugins.common.model.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static io.zenmake.deepmutate.plugins.io.db.csv.CommonsCsv.MutationHeader.*;

/**
 * Created by Talal Ahmed on 19/02/2023
 */
public class CommonsCsv implements MutationIO {

    enum MutationHeader {
        id, codebaseId, mutationId, inputType, mutationType, language, status, pattern,
        sourceCode_type, sourceCode_dirPath, sourceCode_filePath, sourceCode_content, mutatedCode_content, line,
        analysis_failed, analysis_passed, analysis_skipped, analysis_results
    }

    private static final int BUFFER_SIZE = 10;

    private final String path;

    private final List<Mutation> buffer;

    private final ObjectMapper mapper;

    private FileWriter writer;
    private FileReader reader;

    private CSVFormat format;
    private CSVParser parser;
    private CSVPrinter printer;


    private CommonsCsv(String filePath) {
        this.path = filePath;
        this.buffer = new LinkedList<>();
        this.mapper = new ObjectMapper();
    }

    public static CommonsCsv create(String path) {
        var commonsCSV = new CommonsCsv(path);
        commonsCSV.init();
        return commonsCSV;
    }

    public void init() {
        try {
            format = CSVFormat.DEFAULT
                    .builder()
                    .setSkipHeaderRecord(false)
                    .setHeader(MutationHeader.class)
                    .build();

            writer = new FileWriter(path);
            reader = new FileReader(path);

            parser = format.parse(reader);
            printer = new CSVPrinter(writer, format);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Mutation m) {
        try {
            var pattern = mapper.writeValueAsString(m.getPattern());
            var testResults = mapper.writeValueAsString(m.getAnalysis().getResults());
            printer.printRecord(
                    m.getId(), m.getCodebaseId(), m.getMutationId(), m.getInputType(),
                    m.getMutationType(), m.getLanguage(), m.getStatus(), pattern,
                    m.getSourceCode().getType(), m.getSourceCode().getDirPath(), m.getSourceCode().getFilePath(),
                    m.getSourceCode().getContent(), m.getMutatedCode().getContent(), m.getLine(),
                    m.getAnalysis().getFailed(), m.getAnalysis().getSkipped(), m.getAnalysis().getSkipped(), testResults
            );
            printer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void replace(Mutation mutation) {
        buffer.add(mutation);
        if (buffer.size() > BUFFER_SIZE) {
            writeBuffer();
        }
    }

    @Override
    public Iterator<Report.Mutant> findMutants(String codebaseId) {
        return parser.stream()
                .map(x -> Report.Mutant.from(from(x)))
                .iterator();
    }

    @Override
    public Iterator<Mutation> findByCodebaseId(String id) {
        return parser.stream()
                .filter(x -> x.get(codebaseId).equals(id))
                .map(this::from)
                .iterator();
    }

    @Override
    public Iterator<Mutation> iterator() {
        return parser.stream()
                .map(this::from)
                .iterator();
    }

    @Override
    public void close() {
        try {
            writeBuffer();
            this.parser.close();
            this.printer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeBuffer() {
        try {
            // TODO: write to temp file and rename to original
            printer = new CSVPrinter(writer, format);
            buffer.forEach(this::insert);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Mutation from(CSVRecord record) {
        var m = new Mutation();

        try {
            m.setId(record.get(MutationHeader.id));
            m.setCodebaseId(record.get(codebaseId));
            m.setMutationId(record.get(mutationId));
            m.setMutationType(record.get(mutationType));
            m.setInputType(record.get(inputType));
            m.setLanguage(record.get(language));
            m.setStatus(record.get(status));

            var mutationPattern = mapper.readValue(record.get(pattern), Mutation.Pattern.class);
            m.setPattern(mutationPattern);

            m.setLine(Integer.parseInt(record.get(line)));

            var sourcecode = new Codebase();
            sourcecode.setType(record.get(sourceCode_type));
            sourcecode.setDirPath(record.get(sourceCode_dirPath));
            sourcecode.setFilePath(record.get(sourceCode_filePath));
            sourcecode.setContent(record.get(sourceCode_content));
            m.setSourceCode(sourcecode);

            var mutatedCode = new Codebase();
            mutatedCode.setType(record.get(sourceCode_type));
            mutatedCode.setDirPath(record.get(sourceCode_dirPath));
            mutatedCode.setFilePath(record.get(sourceCode_filePath));
            mutatedCode.setContent(record.get(mutatedCode_content));
            m.setMutatedCode(mutatedCode);

            var analysis = new Analysis();
            analysis.setPassed(Integer.parseInt(record.get(analysis_passed)));
            analysis.setFailed(Integer.parseInt(record.get(analysis_failed)));
            analysis.setSkipped(Integer.parseInt(record.get(analysis_skipped)));

            List<TestResult> results = mapper.readerForListOf(TestResult.class).readValue(record.get(analysis_results));
            analysis.setResults(results);

            m.setAnalysis(analysis);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return m;
    }
}
