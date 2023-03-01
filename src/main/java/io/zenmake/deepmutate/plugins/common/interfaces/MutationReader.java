package io.zenmake.deepmutate.plugins.common.interfaces;

import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.common.model.Report;

import java.util.Iterator;

/**
 * Created by Talal Ahmed on 18/02/2023
 */
public interface MutationReader extends Reader<Mutation> {

    Iterator<Report.Mutant> findMutants(String codebaseId);

    Iterator<Mutation> findByCodebaseId(String id);

    Iterator<Mutation> iterator();

}
