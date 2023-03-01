package io.zenmake.deepmutate.plugins.common.interfaces;

/**
 * Created by Talal Ahmed on 27/02/2023
 */
public interface MutationIO extends MutationWriter, MutationReader {

    void close();

}
