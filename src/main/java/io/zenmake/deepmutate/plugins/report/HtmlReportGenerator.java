package io.zenmake.deepmutate.plugins.report;

import io.zenmake.deepmutate.plugins.common.interfaces.MutationReader;
import io.zenmake.deepmutate.plugins.common.interfaces.ReportGenerator;
import io.zenmake.deepmutate.plugins.common.model.Report;
import j2html.rendering.IndentedHtml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static j2html.TagCreator.*;

/**
 * Created by Talal Ahmed on 26/02/2023
 */
public class  HtmlReportGenerator implements ReportGenerator {

    public static final String DEFAULT_REPORT_FILE_FORMAT = "%s-report.html";

    private final MutationReader reader;

    private final File outputDir;

    private HtmlReportGenerator(MutationReader reader, String outputDir) {
        this.reader = reader;
        this.outputDir = new File(outputDir);
    }

    public static HtmlReportGenerator create(MutationReader reader, String outputDir) {
        var generator = new HtmlReportGenerator(reader, outputDir);
        generator.init();
        return generator;
    }

    private void init() {
        this.outputDir.mkdirs();
    }

    @Override
    public void generate(String codebaseId) {
        var iterator = reader.findMutants(codebaseId);
        var mutants = StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false)
                .collect(Collectors.toList());

    }

    private void render(String codebaseId, List<Report.Mutant> mutants) {

        try (var writer = new FileWriter(new File(outputDir, String.format(DEFAULT_REPORT_FILE_FORMAT, codebaseId)))) {
            html(
                    head(
                            title("Mutation Analysis"),
                            link().withRel("stylesheet").withHref("/css/main.css")
                    ),
                    body(
                            main(attrs("#main.content"),
                                    h1("Mutation Analysis"),
                                    table(attrs("#mutants-table"),
                                            tbody(each(mutants, i -> tr(
                                                            td(i.getId()),
                                                            td(i.getDescriptors().toString()),
                                                            td(String.valueOf(i.getFailed())),
                                                            td(String.valueOf(i.getPassed())),
                                                            td(String.valueOf(i.getSkipped()))
                                                    ))
                                            )
                                    )
                            )
                    )
            ).render(IndentedHtml.into(writer));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
