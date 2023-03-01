package io.zenmake.deepmutate.plugins.io.db.inmemory;

import io.zenmake.deepmutate.cache.Cache;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationIO;
import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.common.model.Report;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Iterator;

/**
 * Created by Talal Ahmed on 29/01/2023
 */
public class SimpleCache implements MutationIO {

    private final Cache<Mutation> cache;

    private SimpleCache(Cache<Mutation> cache) {
        this.cache = cache;
    }

    public static SimpleCache create(Cache<Mutation> cache) {
        return new SimpleCache(cache);
    }

    @Override
    public void insert(Mutation mutation) {
        this.cache.add(mutation.getId(), mutation);
    }

    @Override
    public void replace(Mutation mutation) {
        throw new NotImplementedException("SimpleCache operations not implemented yet.");
    }

    @Override
    public Iterator<Report.Mutant> findMutants(String codebaseId) {
        throw new NotImplementedException("SimpleCache operations not implemented yet.");
    }

    @Override
    public Iterator<Mutation> findByCodebaseId(String id) {
        throw new NotImplementedException("SimpleCache operations not implemented yet.");
    }

    @Override
    public Iterator<Mutation> iterator() {
        return this.cache
                .items()
                .values()
                .iterator();
    }

    @Override
    public void close() {
        this.cache.clear();
    }
}
