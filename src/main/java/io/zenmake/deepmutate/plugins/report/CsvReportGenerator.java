package io.zenmake.deepmutate.plugins.report;

import io.zenmake.deepmutate.plugins.common.interfaces.MutationReader;
import io.zenmake.deepmutate.plugins.common.interfaces.ReportGenerator;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Created by Talal Ahmed on 26/02/2023
 */
public final class CsvReportGenerator implements ReportGenerator {

    private final MutationReader reader;

    private final String outputDir;

    private CsvReportGenerator(MutationReader reader, String outputDir) {
        this.reader = reader;
        this.outputDir = outputDir;
    }

    public static CsvReportGenerator create(MutationReader reader, String outputDir) {
        return new CsvReportGenerator(reader, outputDir);
    }

    @Override
    public void generate(String codebaseId) {
        throw new NotImplementedException("CsvReportGenerator not implemented yet.");
    }

}
