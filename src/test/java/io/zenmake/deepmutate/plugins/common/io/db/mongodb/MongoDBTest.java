package io.zenmake.deepmutate.plugins.common.io.db.mongodb;

import io.zenmake.deepmutate.plugins.common.model.Analysis;
import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.io.db.mongodb.MongoDB;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Talal Ahmed on 19/02/2023
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MongoDBTest {

    private static final Logger log = LoggerFactory.getLogger(MongoDBTest.class);

    public static final String DEEP_MUTATE_TEST_DB_NAME = "deepmutate_test";
    public static final String DEEP_MUTATE_TEST_COLLECTION_NAME = "mutations_test";

    private MongoDB client;

    @BeforeAll
    public void setup() {
        this.client = MongoDB.create(DEEP_MUTATE_TEST_DB_NAME, DEEP_MUTATE_TEST_COLLECTION_NAME);
    }

    @Test
    public void testOperations() {
        var mutation = new Mutation();
        mutation.setCodebaseId("test-dir-01");
        mutation.setPattern(new Mutation.Pattern("int i = someNonVoidMethod();", List.of("int i = 0;")));
        mutation.setStatus(Mutation.STATUS_MUTATION_COMPLETE);

        client.insert(mutation);

        var analysis = new Analysis();
        analysis.setPassed(0);
        analysis.setFailed(0);
        analysis.setSkipped(1);
        analysis.setResults(new ArrayList<>());

        mutation.setAnalysis(analysis);

        client.replace(mutation);

        var itr = client.findByCodebaseId(mutation.getCodebaseId());
        while (itr.hasNext()) {
            assertEquals(itr.next().getCodebaseId(), mutation.getCodebaseId());
        }
    }

}
