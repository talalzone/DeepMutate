package io.zenmake.deepmutate.plugins.common.interfaces;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Iterator;

/**
 * Created by Talal Ahmed on 14/02/2023
 */
public interface Reader<T> extends Iterable<T> {

    default Iterator<T> find(String q) {
        throw new NotImplementedException("find not implemented.");
    }

    default Iterator<T> iterator() {
        throw new NotImplementedException("iterator not implemented.");
    }

    default void close() {
        throw new NotImplementedException("close not implemented.");
    }

}
