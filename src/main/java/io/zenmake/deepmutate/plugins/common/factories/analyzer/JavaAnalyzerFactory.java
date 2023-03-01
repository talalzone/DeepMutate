package io.zenmake.deepmutate.plugins.common.factories.analyzer;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;
import io.zenmake.deepmutate.plugins.common.factories.build.BuildSystemFactory;
import io.zenmake.deepmutate.plugins.common.factories.io.MutationIOFactory;
import io.zenmake.deepmutate.plugins.common.interfaces.Analyzer;
import io.zenmake.deepmutate.plugins.lang.java.analyze.runtime.RuntimeAnalyzer;

/**
 * Created by Talal Ahmed on 17/02/2023
 */
public class JavaAnalyzerFactory extends AbstractAnalyzerFactory {

    public JavaAnalyzerFactory(ProjectConf projectConf, InputConf inputConf, OutputConf outputConf) {
        super(projectConf, inputConf, outputConf);
    }

    public Analyzer getAnalyzer(String type) {
        var reader = MutationIOFactory.getReader(outputConf);
        var writer = MutationIOFactory.getWriter(outputConf);
        var buildSystem = BuildSystemFactory.getBuildSystem(inputConf.getBuildSystem());

        return switch (type) {
            case ProjectConf.MUTATION_TYPE_SEMANTIC -> RuntimeAnalyzer.create(reader, writer, buildSystem);
            default -> {
                throw new UnsupportedOperationException("No analyzer found for type: " + type);
            }
        };
    }

}
