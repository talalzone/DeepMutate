package io.zenmake.deepmutate.plugins.common.factories.report;

import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.plugins.common.factories.io.MutationIOFactory;
import io.zenmake.deepmutate.plugins.common.interfaces.ReportGenerator;
import io.zenmake.deepmutate.plugins.report.ConsoleReportGenerator;
import io.zenmake.deepmutate.plugins.report.CsvReportGenerator;
import io.zenmake.deepmutate.plugins.report.HtmlReportGenerator;

import static io.zenmake.deepmutate.lang.types.conf.OutputConf.*;

/**
 * Created by Talal Ahmed on 26/02/2023
 */
public class ReportGeneratorFactory {

    public static ReportGenerator getGenerator(OutputConf outputConf) {
        var reader = MutationIOFactory.getReader(outputConf);

        return switch (outputConf.getReportType()) {
            case REPORT_TYPE_HTML, REPORT_TYPE_TRUE -> HtmlReportGenerator.create(reader, DEFAULT_REPORT_OUTPUT_DIR);
            case REPORT_TYPE_CSV -> CsvReportGenerator.create(reader, DEFAULT_REPORT_OUTPUT_DIR);
            case REPORT_TYPE_CONSOLE -> ConsoleReportGenerator.create(reader);
            default -> {
                throw new UnsupportedOperationException("No ReportGenerator found for type: " + outputConf.getReportType());
            }
        };
    }
}
