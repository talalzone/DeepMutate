package io.zenmake.deepmutate.plugins.common.interfaces;

import io.zenmake.deepmutate.plugins.common.model.TestResult;

/**
 * Created by Talal Ahmed on 23/02/2023
 */
public interface BuildSystem {

    void run(String projectDir, ResultListener<? super TestResult> listener);

}
