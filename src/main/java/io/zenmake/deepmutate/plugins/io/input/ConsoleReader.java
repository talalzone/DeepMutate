package io.zenmake.deepmutate.plugins.io.input;

import io.zenmake.deepmutate.plugins.common.interfaces.InputReader;
import io.zenmake.deepmutate.plugins.common.model.Codebase;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Talal Ahmed on 14/02/2023
 */
public class ConsoleReader implements InputReader {

    public static final String TYPE_CONSOLE = "console";

    private ConsoleReader() {
    }

    public static InputReader create() {
        return new ConsoleReader();
    }

    @Override
    public Iterator<Codebase> iterator() {
        String code = System.console().readLine(); // TODO: read line by line and create content
        return List.of(new Codebase("code", TYPE_CONSOLE, code)).iterator();
    }

}
