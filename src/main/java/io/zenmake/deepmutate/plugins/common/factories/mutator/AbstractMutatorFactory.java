package io.zenmake.deepmutate.plugins.common.factories.mutator;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;
import io.zenmake.deepmutate.plugins.common.interfaces.Mutator;

/**
 * Created by Talal Ahmed on 12/02/2023
 */
public abstract class AbstractMutatorFactory {

    protected final ProjectConf projectConf;

    protected final InputConf inputConf;

    protected final OutputConf outputConf;

    public AbstractMutatorFactory(ProjectConf projectConf, InputConf inputConf, OutputConf outputConf) {
        this.projectConf = projectConf;
        this.inputConf = inputConf;
        this.outputConf = outputConf;
    }

    public abstract Mutator getMutator(String type);

}
