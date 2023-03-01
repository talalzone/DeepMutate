package io.zenmake.deepmutate.lang.types.conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Talal Ahmed on 14/02/2023
 */
public abstract class BaseConf<K, V> extends HashMap<K, V> {

    public void add(Map<K, V> conf) {
        putAll(conf);
    }

    public void add(List<Map<K, V>> confList) {
        confList.forEach(this::add);
    }

    protected <T> T getWithKeys(T defaultVal, String... keys) {
        for (var key : keys) {
            if (containsKey(key)) {
                return (T) get(key);
            }
        }
        return defaultVal;
    }

}
