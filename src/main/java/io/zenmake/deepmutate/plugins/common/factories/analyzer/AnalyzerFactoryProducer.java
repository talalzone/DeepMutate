package io.zenmake.deepmutate.plugins.common.factories.analyzer;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;

import static io.zenmake.deepmutate.lang.types.conf.ProjectConf.LANG_JAVA;

/**
 * Created by Talal Ahmed on 17/02/2023
 */
public class AnalyzerFactoryProducer {

    public static AbstractAnalyzerFactory getFactory(ProjectConf projectConf, InputConf inputConf, OutputConf outputConf) {
        return switch (projectConf.getLanguage()) {
            case LANG_JAVA -> new JavaAnalyzerFactory(projectConf, inputConf, outputConf);
            default -> {
                throw new UnsupportedOperationException("No analyzer factory found for lang: " + projectConf.getLanguage());
            }
        };
    }

}
