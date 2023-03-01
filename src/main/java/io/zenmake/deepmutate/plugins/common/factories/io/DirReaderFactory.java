package io.zenmake.deepmutate.plugins.common.factories.io;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;
import io.zenmake.deepmutate.plugins.common.interfaces.InputReader;
import io.zenmake.deepmutate.plugins.io.input.JavaDirReader;

/**
 * Created by Talal Ahmed on 23/02/2023
 */
public class DirReaderFactory {

    public static InputReader getReader(InputConf conf, String lang) {
        return switch (lang) {
            case ProjectConf.LANG_JAVA -> JavaDirReader.create(conf.getContent());
            default -> {
                throw new UnsupportedOperationException("No directory reader found for lang: " + lang);
            }
        };
    }
}
