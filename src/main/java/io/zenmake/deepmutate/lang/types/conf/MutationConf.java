package io.zenmake.deepmutate.lang.types.conf;

/**
 * Created by Talal Ahmed on 05/02/2023
 */
public class MutationConf extends BaseConf<String, Object> {

    public static final String KEY_ACTIVE = "active";
    public static final String DEFAULT_ACTIVE_VALUE = "true";

    public MutationConf() {
    }

    public boolean isActive() {
        return Boolean.parseBoolean(getWithKeys(DEFAULT_ACTIVE_VALUE, KEY_ACTIVE));
    }
}
