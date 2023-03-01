package io.zenmake.deepmutate.plugins.common.factories.analyzer;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;
import io.zenmake.deepmutate.plugins.common.interfaces.Analyzer;

/**
 * Created by Talal Ahmed on 17/02/2023
 */
public abstract class AbstractAnalyzerFactory {

    protected final ProjectConf projectConf;

    protected final InputConf inputConf;

    protected final OutputConf outputConf;

    public AbstractAnalyzerFactory(ProjectConf projectConf, InputConf inputConf, OutputConf outputConf) {
        this.projectConf = projectConf;
        this.inputConf = inputConf;
        this.outputConf = outputConf;
    }

    public abstract Analyzer getAnalyzer(String type);

}
