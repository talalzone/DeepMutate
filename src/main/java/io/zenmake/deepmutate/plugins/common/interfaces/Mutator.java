package io.zenmake.deepmutate.plugins.common.interfaces;

import io.zenmake.deepmutate.lang.types.declaration.ProjectDecl;

/**
 * Created by Talal Ahmed on 12/02/2023
 */
public interface Mutator {

    void mutate(ProjectDecl project);

}
