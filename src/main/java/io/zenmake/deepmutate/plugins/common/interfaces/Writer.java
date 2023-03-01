package io.zenmake.deepmutate.plugins.common.interfaces;

import org.apache.commons.lang3.NotImplementedException;

/**
 * Created by Talal Ahmed on 14/02/2023
 */
public interface Writer<T> {

    default void insert(T t) {
        throw new NotImplementedException("insert not implemented");
    }

    default void update(T t) {
        throw new NotImplementedException("update not implemented");
    }

    default void upsert(T t) {
        throw new NotImplementedException("upsert not implemented");
    }

    /*
     * Method write is synonymous to insert
     */
    default void write(T t) {
        insert(t);
    }

    default void close() {
        throw new NotImplementedException("close not implemented");
    }
}
