package io.zenmake.deepmutate.plugins.common.interfaces;

import io.zenmake.deepmutate.plugins.common.model.Codebase;

import java.util.Iterator;

/**
 * Created by Talal Ahmed on 18/02/2023
 */
public interface InputReader extends Reader<Codebase> {

    Iterator<Codebase> iterator();

}
