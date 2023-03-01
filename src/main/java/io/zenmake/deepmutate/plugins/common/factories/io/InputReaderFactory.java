package io.zenmake.deepmutate.plugins.common.factories.io;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;
import io.zenmake.deepmutate.plugins.common.interfaces.InputReader;
import io.zenmake.deepmutate.plugins.io.input.CodeReader;
import io.zenmake.deepmutate.plugins.io.input.ConsoleReader;
import io.zenmake.deepmutate.plugins.io.input.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.zenmake.deepmutate.lang.types.conf.InputConf.*;


/**
 * Created by Talal Ahmed on 14/02/2023
 */
public class InputReaderFactory {

    private static final Logger log = LoggerFactory.getLogger(InputReaderFactory.class);

    public static InputReader getReader(InputConf inputConf, ProjectConf projectConf) {
        return switch (inputConf.getType()) {
            case TYPE_CONSOLE -> ConsoleReader.create();
            case TYPE_CODE -> CodeReader.create(inputConf.getContent());
            case TYPE_FILE -> FileReader.create(inputConf.getContent());
            case TYPE_DIR -> DirReaderFactory.getReader(inputConf, projectConf.getLanguage());
            default -> {
                throw new UnsupportedOperationException("No reader found for type: " + inputConf.getType());
            }
        };
    }

}
