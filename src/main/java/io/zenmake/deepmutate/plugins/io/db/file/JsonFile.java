package io.zenmake.deepmutate.plugins.io.db.file;

import io.zenmake.deepmutate.plugins.common.interfaces.MutationIO;
import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.common.model.Report;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Iterator;

/**
 * Created by Talal Ahmed on 28/02/2023
 */
public class JsonFile implements MutationIO {

    private JsonFile() {
    }

    public static JsonFile create() {
        return new JsonFile();
    }

    @Override
    public void insert(Mutation mutation) {
        throw new NotImplementedException("JsonFile operations not implemented yet.");
    }

    @Override
    public void replace(Mutation mutation) {
        throw new NotImplementedException("JsonFile operations not implemented yet.");
    }

    @Override
    public Iterator<Report.Mutant> findMutants(String codebaseId) {
        throw new NotImplementedException("JsonFile operations not implemented yet.");
    }

    @Override
    public Iterator<Mutation> findByCodebaseId(String id) {
        throw new NotImplementedException("JsonFile operations not implemented yet.");
    }

    @Override
    public Iterator<Mutation> iterator() {
        throw new NotImplementedException("JsonFile operations not implemented yet.");
    }


    @Override
    public void close() {
        throw new NotImplementedException("JsonFile operations not implemented yet.");
    }
}
