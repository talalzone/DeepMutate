package io.zenmake.deepmutate.lang.visitor;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.zenmake.deepmutate.gen.DeepMutateLexer;
import io.zenmake.deepmutate.gen.DeepMutateParser;
import io.zenmake.deepmutate.lang.listener.DeepMutateListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Talal Ahmed on 02/02/2023
 */
public class DeepMutateVisitorTest {

    private static final Logger log = LoggerFactory.getLogger(DeepMutateVisitorTest.class);

    @Test
    public void testVisitor() throws IOException {
        var mutate = Paths.get("src/test/resources/mutate-java-project.dm");
        var str = Files.readString(mutate);

        var lexer = new DeepMutateLexer(new ANTLRInputStream(str));
        var parser = new DeepMutateParser(new CommonTokenStream(lexer));

        var parserListener = new DeepMutateListener();
        parser.addParseListener(parserListener);

        // ParseTreeWalker.DEFAULT.walk(parserListener, parser.parse());

        var visitor = new DeepMutateVisitor();
        var cu = visitor.visit(parser.parse());

        var cuJson = new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(cu);

        log.debug(cuJson);
    }
}
