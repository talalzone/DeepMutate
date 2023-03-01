package io.zenmake.deepmutate.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Talal Ahmed on 27/02/2023
 */
public class Cache<T> {

    private static final Cache instance = new Cache<>();

    private final Map<String, T> items;

    private Cache() {
        this.items = new LinkedHashMap<>();
    }

    public static <T> Cache<T> getInstance() {
        return instance;
    }

    public void add(String key, T value) {
        items.put(key, value);
    }

    public T get(String key) {
        return items.get(key);
    }

    public Map<String, T> items() {
        return items;
    }

    public void clear() {
        items.clear();
    }

}
