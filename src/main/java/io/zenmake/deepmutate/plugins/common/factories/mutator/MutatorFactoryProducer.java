package io.zenmake.deepmutate.plugins.common.factories.mutator;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;

/**
 * Created by Talal Ahmed on 12/02/2023
 */
public class MutatorFactoryProducer {

    public static AbstractMutatorFactory getFactory(ProjectConf projectConf, InputConf inputConf, OutputConf outputConf) {
        return switch (projectConf.getLanguage()) {
            case ProjectConf.LANG_JAVA -> new JavaMutatorFactory(projectConf, inputConf, outputConf);
            case ProjectConf.LANG_PYTHON -> new PythonMutatorFactory(projectConf, inputConf, outputConf);
            default -> {
                throw new UnsupportedOperationException("No mutator factory found for lang: " + projectConf.getLanguage());
            }
        };
    }

}
