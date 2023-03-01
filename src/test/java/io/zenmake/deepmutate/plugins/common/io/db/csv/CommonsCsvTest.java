package io.zenmake.deepmutate.plugins.common.io.db.csv;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zenmake.deepmutate.plugins.common.model.Analysis;
import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.io.db.csv.CommonsCsv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Talal Ahmed on 28/02/2023
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommonsCsvTest {

    private static final Logger log = LoggerFactory.getLogger(CommonsCsvTest.class);


    private static final String DEEPMUTATE_TEST_OUTPUT_DIR = "deepmutate-test-output/mutations";
    private static final String MUTATIONS_CSV_OUTPUT_FILE = "mutations.csv";

    @BeforeAll
    public void setup() {
        var dir = new File(DEEPMUTATE_TEST_OUTPUT_DIR);
        dir.mkdirs();
    }

    @Test
    public void testOperations() throws IOException {
        // Read mutation sample jsons'
        List<Mutation> mutations = new ObjectMapper()
                .readerForListOf(Mutation.class)
                .readValue(new File("src/test/resources/test/mutations.json"));

        // Take first for testing
        var mutation = mutations.get(0);

        // Create csv reader/writer
        var csv = CommonsCsv.create(Path.of(DEEPMUTATE_TEST_OUTPUT_DIR, MUTATIONS_CSV_OUTPUT_FILE).toString());

        // Write
        mutations.forEach(csv::write);

        // Read
        var codebaseId = mutation.getCodebaseId();
        var itr = csv.findByCodebaseId(codebaseId);
        while (itr.hasNext()) {
            var foundMutation = itr.next();
            log.debug("Found: {} ", foundMutation);

            assertEquals(foundMutation.getCodebaseId(), codebaseId);
        }

        // Replace
        var analysis = new Analysis();
        analysis.setFailed(0);
        analysis.setPassed(0);
        analysis.setSkipped(1);
        analysis.setResults(new ArrayList<>());

        mutation.setAnalysis(analysis);

        csv.replace(mutation);
    }
}
