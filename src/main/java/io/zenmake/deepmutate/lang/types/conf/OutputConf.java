package io.zenmake.deepmutate.lang.types.conf;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Talal Ahmed on 14/02/2023
 */
public class OutputConf extends BaseConf<String, Object> {

    public static final String KEY_STORE_TYPE = "store";
    public static final String KEY_DATASTORE_TYPE = "datastore";

    public static final String KEY_DB = "db";
    public static final String KEY_DATABASE = "database";

    public static final String KEY_COLLECTION = "collection";

    public static final String KEY_URI = "uri";

    public static final String KEY_USER = "user";
    public static final String KEY_USER_NAME = "username";

    public static final String KEY_PASS = "pass";
    public static final String KEY_PASSWORD = "password";

    public static final String KEY_PATH = "path";
    public static final String KEY_PATHS = "paths";

    public static final String KEY_REPORT = "report";

    public static final String REPORT_TYPE_HTML = "html";
    public static final String REPORT_TYPE_CSV = "csv";
    public static final String REPORT_TYPE_CONSOLE = "console";

    // True | False can be used as report types - true will take default value of html
    public static final String REPORT_TYPE_TRUE = "true";
    public static final String REPORT_TYPE_FALSE = "false";

    public static final String DATASTORE_TYPE_FILE = "file";
    public static final String DATASTORE_TYPE_CSV = "csv";
    public static final String DATASTORE_TYPE_CACHE = "cache";
    public static final String DATASTORE_TYPE_ARANGO_DB = "arangodb";
    public static final String DATASTORE_TYPE_NEO4J_DB = "neo4j";
    public static final String DATASTORE_TYPE_MONGO_DB = "mongodb";
    public static final String DATASTORE_TYPE_H2_DB = "h2";
    public static final String DATASTORE_TYPE_POSTGRESQL_DB = "postgres";

    public static final List<String> FILE_DATA_STORES = Arrays.asList(DATASTORE_TYPE_FILE, DATASTORE_TYPE_CSV);
    public static final List<String> GRAPH_DATA_STORES = Arrays.asList(DATASTORE_TYPE_ARANGO_DB, DATASTORE_TYPE_NEO4J_DB);
    public static final List<String> DOCUMENT_DATA_STORES = Arrays.asList(DATASTORE_TYPE_MONGO_DB, DATASTORE_TYPE_ARANGO_DB);
    public static final List<String> RELATIONAL_DATA_STORES = Arrays.asList(DATASTORE_TYPE_H2_DB, DATASTORE_TYPE_POSTGRESQL_DB);

    public static final String DEFAULT_DEEP_MUTATE_DB_NAME = "deepmutate";
    public static final String DEFAULT_MUTATIONS_COLLECTION_NAME = "mutations";
    public static final String DEFAULT_MUTATIONS_CSV_FILE = "mutations.csv";
    public static final String DEFAULT_REPORT_OUTPUT_DIR = "deep-mutate-report";
    public static final String DEFAULT_REPORT_TYPE = "html";
    public static final String DEFAULT_MONGO_DB_URI_VALUE = "localhost:27017";
    public static final String DEFAULT_ARANGO_DB_URI_VALUE = "http://127.0.0.1:8529/";


    public OutputConf() {
    }

    public String getDatastoreType() {
        return getWithKeys(null, KEY_DATASTORE_TYPE, KEY_STORE_TYPE);
    }

    public String getDatabase() {
        return getWithKeys(DEFAULT_DEEP_MUTATE_DB_NAME, KEY_DB, KEY_DATABASE);
    }

    public String getCollection() {
        return getWithKeys(DEFAULT_MUTATIONS_COLLECTION_NAME, KEY_COLLECTION);
    }

    public String getURI() {
        return getWithKeys(null, KEY_URI);
    }

    public String getUsername() {
        return getWithKeys(null, KEY_USER, KEY_USER_NAME);
    }

    public String getPassword() {
        return getWithKeys(null, KEY_PASS, KEY_PASSWORD);
    }

    public List<String> getPaths() {
        return getWithKeys(null, KEY_PATH, KEY_PATHS);
    }

    public String getReportType() {
        return getWithKeys(DEFAULT_REPORT_TYPE, KEY_COLLECTION);
    }

    public boolean generateReport() {
        if (containsKey(KEY_REPORT)) {
            return switch (String.valueOf(get(KEY_REPORT))) {
                case REPORT_TYPE_TRUE, REPORT_TYPE_HTML, REPORT_TYPE_CSV -> true;
                default -> false; // in-case of 'false' or other erroneous input
            };
        } else {
            return false;
        }
    }
}
