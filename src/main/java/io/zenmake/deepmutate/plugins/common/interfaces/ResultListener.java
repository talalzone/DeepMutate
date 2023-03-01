package io.zenmake.deepmutate.plugins.common.interfaces;

/**
 * Created by Talal Ahmed on 24/02/2023
 */
public interface ResultListener<T> {

    void onResult(T t);

    void onComplete(String status);

    void onFailure(Exception e);

}
