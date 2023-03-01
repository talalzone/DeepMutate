package io.zenmake.deepmutate.plugins.io.db.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationIO;
import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.common.model.Report;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.Iterator;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Created by Talal Ahmed on 15/02/2023
 */
public class MongoDB implements MutationIO {

    private final String dbName;
    private final String collectionName;

    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Mutation> col;

    private MongoDB(String database, String collection) {
        this.dbName = database;
        this.collectionName = collection;
    }

    public static MongoDB create(String database, String collection) {
        var mongodb = new MongoDB(database, collection);
        mongodb.init();
        return mongodb;
    }

    public void init() {
        this.client = MongoClients.create();

        var pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        var pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        this.db = this.client.getDatabase(dbName).withCodecRegistry(pojoCodecRegistry);
        this.col = this.db.getCollection(collectionName, Mutation.class);
    }

    @Override
    public void insert(Mutation mutation) {
        this.col.insertOne(mutation);
    }

    public void replace(Mutation mutation) {
        this.col.replaceOne(eq("_id", new ObjectId(mutation.getId())), mutation);
    }

    @Override
    public Iterator<Report.Mutant> findMutants(String codebaseId) {
        return this.col
                .find(and(eq("codebaseId", codebaseId), eq("status", Mutation.STATUS_ANALYSIS_COMPLETE)))
                .map(Report.Mutant::from)
                .iterator();
    }

    @Override
    public Iterator<Mutation> findByCodebaseId(String id) {
        return this.col
                .find(eq("codebaseId", id))
                .iterator();
    }

    @Override
    public Iterator<Mutation> iterator() {
        return this.col.find().iterator();
    }

    @Override
    public void close() {
        this.client.close();
    }

}
