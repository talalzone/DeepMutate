package io.zenmake.deepmutate.plugins.io.db.arangodb;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDatabase;
import com.arangodb.mapping.ArangoJack;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationIO;
import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.common.model.Report;

import java.util.Iterator;

/**
 * Created by Talal Ahmed on 29/01/2023
 */
public class ArangoDB implements MutationIO {

    private final String dbName;
    private final String colName;

    private com.arangodb.ArangoDB client;
    private ArangoDatabase db;
    private ArangoCollection col;

    private ArangoDB(String database, String collection) {
        this.dbName = database;
        this.colName = collection;
    }

    public static ArangoDB create(String database, String collection) {
        var arangodb = new ArangoDB(database, collection);
        arangodb.init();
        return arangodb;
    }

    public void init() {
        this.client = new com.arangodb.ArangoDB
                .Builder()
                .serializer(new ArangoJack())
                .build();

        this.db = this.client.db(this.dbName);
        if (!this.db.exists()) {
            this.client.createDatabase(this.dbName);
        }

        this.col = this.db.collection(this.colName);
        if (!this.col.exists()) {
            this.col.create();
        }
    }

    @Override
    public void insert(Mutation mutation) {
        this.col.insertDocument(mutation);
    }

    @Override
    public void replace(Mutation mutation) {
        this.col.replaceDocument(mutation.getId(), mutation);
    }

    @Override
    public void update(Mutation mutation) {
        this.col.updateDocument(mutation.getId(), mutation);
    }

    @Override
    public Iterator<Report.Mutant> findMutants(String codebaseId) {
        var q = "FOR m IN " + this.colName + " " +
                "FILTER m.codebaseId == " + codebaseId + " AND m.status == " + Mutation.STATUS_ANALYSIS_COMPLETE + " " +
                "RETURN m";
        var r = this.db.query(q, Mutation.class);
        return r.stream()
                .map(Report.Mutant::from)
                .iterator();
    }

    @Override
    public Iterator<Mutation> findByCodebaseId(String id) {
        var q = "FOR m IN " + this.colName + " " +
                "FILTER m.codebaseId == " + id +  " " +
                "RETURN m";
        var r = this.db.query(q, Mutation.class);
        return r.stream().iterator();
    }

    @Override
    public Iterator<Mutation> iterator() {
        var q = "FOR m IN " + this.colName + " RETURN m";
        var itr = this.db.query(q, Mutation.class);
        return itr.iterator();
    }

    @Override
    public void close() {
        this.client.shutdown();
    }

}
