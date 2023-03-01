package io.zenmake.deepmutate.plugins.io.input;

import io.zenmake.deepmutate.plugins.common.interfaces.InputReader;
import io.zenmake.deepmutate.plugins.common.model.Codebase;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Talal Ahmed on 14/02/2023
 */
public class CodeReader implements InputReader {

    private static final String TYPE_CODE = "code";
    private static final String FILE_PATH_NONE = "none";
    private static final String DIR_PATH_NONE = "none";

    private final Map<String, String> content;

    private CodeReader(Map<String, String> content) {
        this.content = content;
    }

    public static InputReader create(Map<String, String> content) {
        return new CodeReader(content);
    }

    @Override
    public Iterator<Codebase> iterator() {
        return content.entrySet()
                .stream()
                .map(x -> new Codebase(x.getKey(), TYPE_CODE, DIR_PATH_NONE, FILE_PATH_NONE, x.getValue()))
                .iterator();
    }

}
