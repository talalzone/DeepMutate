package io.zenmake.deepmutate.plugins.common.interfaces;

import io.zenmake.deepmutate.plugins.common.model.Mutation;

/**
 * Created by Talal Ahmed on 18/02/2023
 */
public interface MutationWriter extends Writer<Mutation> {

    void insert(Mutation mutation);

    void replace(Mutation mutation);

}
