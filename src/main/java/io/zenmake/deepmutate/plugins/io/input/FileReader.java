package io.zenmake.deepmutate.plugins.io.input;

import io.zenmake.deepmutate.plugins.common.interfaces.InputReader;
import io.zenmake.deepmutate.plugins.common.model.Codebase;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Talal Ahmed on 14/02/2023
 */
public class FileReader implements InputReader {

    private final Map<String, String> paths;

    public FileReader(Map<String, String> paths) {
        this.paths = paths;
    }

    public static FileReader create(Map<String, String> paths) {
        return new FileReader(paths);
    }

    @Override
    public Iterator<Codebase> iterator() {
        throw new NotImplementedException("FileReader operations not implemented yet.");
    }

}
