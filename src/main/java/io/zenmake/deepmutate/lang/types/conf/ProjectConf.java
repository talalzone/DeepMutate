package io.zenmake.deepmutate.lang.types.conf;

/**
 * Created by Talal Ahmed on 05/02/2023
 */
public class ProjectConf extends BaseConf<String, Object> {

    public static final String KEY_LANG = "lang";
    public static final String KEY_LANGUAGE = "lang";

    public static final String KEY_TYPE = "type";

    public static final String KEY_ANALYZE = "analyze";
    public static final String DEFAULT_ANALYZE_VALUE = "true";

    public static final String LANG_JAVA = "java";
    public static final String LANG_PYTHON = "python";
    public static final String LANG_GO = "go";
    public static final String LANG_CSHARP = "c#";
    public static final String LANG_JAVASCRIPT = "javascript";

    public static final String MUTATION_TYPE_SEMANTIC = "semantic";
    public static final String MUTATION_TYPE_SYNTACTIC = "syntactic";


    public ProjectConf() {
    }

    public String getLanguage() {
        return getWithKeys(null, KEY_LANG, KEY_LANGUAGE);
    }

    public String getMutationType() {
        return getWithKeys(null, KEY_TYPE);
    }

    public boolean performAnalysis() {
        return Boolean.parseBoolean(getWithKeys(DEFAULT_ANALYZE_VALUE, KEY_ANALYZE));
    }

}
