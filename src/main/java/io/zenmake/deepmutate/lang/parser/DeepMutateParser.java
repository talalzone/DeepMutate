package io.zenmake.deepmutate.lang.parser;

import io.zenmake.deepmutate.lang.listener.DeepMutateListener;
import io.zenmake.deepmutate.lang.types.cu.DeepMutateCU;
import io.zenmake.deepmutate.lang.visitor.DeepMutateVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Talal Ahmed on 26/02/2023
 */
public class DeepMutateParser {

    private DeepMutateParser() {
    }

    public static DeepMutateCU parse(String dslPath) throws IOException {
        var dsl = Path.of(dslPath);
        return parse(dsl);
    }

    public static DeepMutateCU parse(Path dslPath) throws IOException {
        var lexer = new io.zenmake.deepmutate.gen.DeepMutateLexer(CharStreams.fromPath(dslPath));
        var parser = new io.zenmake.deepmutate.gen.DeepMutateParser(new CommonTokenStream(lexer));

        var parserListener = new DeepMutateListener();
        parser.addParseListener(parserListener);

        var visitor = new DeepMutateVisitor();
        var output = visitor.visit(parser.parse());

        return (DeepMutateCU) output;
    }
}
