package io.zenmake.deepmutate.plugins.common.factories.io;

import io.zenmake.deepmutate.cache.Cache;
import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationIO;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationReader;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationWriter;
import io.zenmake.deepmutate.plugins.io.db.arangodb.ArangoDB;
import io.zenmake.deepmutate.plugins.io.db.csv.CommonsCsv;
import io.zenmake.deepmutate.plugins.io.db.inmemory.SimpleCache;
import io.zenmake.deepmutate.plugins.io.db.mongodb.MongoDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.zenmake.deepmutate.lang.types.conf.OutputConf.*;


/**
 * Created by Talal Ahmed on 14/02/2023
 */
public class MutationIOFactory {

    private static final Logger log = LoggerFactory.getLogger(MutationIOFactory.class);

    public static MutationReader getReader(OutputConf conf) {
        return get(conf);
    }

    public static MutationWriter getWriter(OutputConf conf) {
        return get(conf);
    }

    public static MutationIO getIO(OutputConf conf) {
        return get(conf);
    }

    private static MutationIO get(OutputConf conf) {
        return switch (conf.getDatastoreType()) {
            case DATASTORE_TYPE_CACHE -> SimpleCache.create(Cache.getInstance());
            case DATASTORE_TYPE_MONGO_DB -> MongoDB.create(conf.getDatabase(), conf.getCollection());
            case DATASTORE_TYPE_ARANGO_DB -> ArangoDB.create(conf.getDatabase(), conf.getCollection());
            case DATASTORE_TYPE_CSV -> CommonsCsv.create(DEFAULT_MUTATIONS_CSV_FILE);
            default -> {
                throw new UnsupportedOperationException("No mutation reader found for type: " + conf.getDatastoreType());
            }
        };
    }
}
