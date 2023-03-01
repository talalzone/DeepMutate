package io.zenmake.deepmutate.plugins.lang.java.analyze.compiletime;

import io.zenmake.deepmutate.plugins.common.interfaces.Analyzer;
import io.zenmake.deepmutate.plugins.common.interfaces.BuildSystem;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationReader;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationWriter;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Talal Ahmed on 17/02/2023
 */
public class CompiletimeAnalyzer implements Analyzer {

    private static final Logger log = LoggerFactory.getLogger(CompiletimeAnalyzer.class);

    private final MutationReader reader;
    private final MutationWriter writer;
    private final BuildSystem build;


    private CompiletimeAnalyzer(MutationReader reader, MutationWriter writer, BuildSystem build) {
        this.reader = reader;
        this.writer = writer;
        this.build = build;
    }

    public static CompiletimeAnalyzer create(MutationReader reader, MutationWriter writer, BuildSystem build) {
        return new CompiletimeAnalyzer(reader, writer, build);
    }

    @Override
    public void analyze(String codebaseId) {
        throw new NotImplementedException("CompiletimeAnalyzer not implemented yet.");
    }
}
