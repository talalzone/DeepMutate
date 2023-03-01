package io.zenmake.deepmutate.plugins.report;

import io.zenmake.deepmutate.plugins.common.interfaces.MutationReader;
import io.zenmake.deepmutate.plugins.common.interfaces.ReportGenerator;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Created by Talal Ahmed on 27/02/2023
 */
public class ConsoleReportGenerator implements ReportGenerator {

    private final MutationReader reader;

    private ConsoleReportGenerator(MutationReader reader) {
        this.reader = reader;
    }

    public static ConsoleReportGenerator create(MutationReader reader) {
        return new ConsoleReportGenerator(reader);
    }

    @Override
    public void generate(String codebaseId) {
        throw new NotImplementedException("ConsoleReportGenerator not implemented yet.");
    }

}
