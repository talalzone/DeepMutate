package io.zenmake.deepmutate.plugins.common.factories.mutator;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;
import io.zenmake.deepmutate.plugins.common.interfaces.Mutator;

/**
 * Created by Talal Ahmed on 12/02/2023
 */
public class PythonMutatorFactory extends AbstractMutatorFactory {

    public PythonMutatorFactory(ProjectConf projectConf, InputConf inputConf, OutputConf outputConf) {
        super(projectConf, inputConf, outputConf);
    }

    @Override
    public Mutator getMutator(String type) {
        throw new UnsupportedOperationException("PythonMutatorFactory not implemented yet.");
    }

}
