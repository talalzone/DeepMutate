package io.zenmake.deepmutate.plugins.io.db.neo4j;

import io.zenmake.deepmutate.plugins.common.interfaces.MutationIO;
import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.common.model.Report;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Iterator;

/**
 * Created by Talal Ahmed on 18/02/2023
 */
public class Neo4j implements MutationIO {


    private Neo4j() {
    }

    public static Neo4j create() {
        return new Neo4j();
    }

    @Override
    public void insert(Mutation mutation) {
        throw new NotImplementedException("Neo4j operations not implemented yet.");
    }

    @Override
    public void replace(Mutation mutation) {
        throw new NotImplementedException("Neo4j operations not implemented yet.");
    }

    @Override
    public Iterator<Report.Mutant> findMutants(String codebaseId) {
        throw new NotImplementedException("Neo4j operations not implemented yet.");
    }

    @Override
    public Iterator<Mutation> findByCodebaseId(String id) {
        throw new NotImplementedException("Neo4j operations not implemented yet.");
    }

    @Override
    public Iterator<Mutation> iterator() {
        throw new NotImplementedException("Neo4j operations not implemented yet.");
    }

    @Override
    public void close() {
        throw new NotImplementedException("Neo4j operations not implemented yet.");
    }

}
