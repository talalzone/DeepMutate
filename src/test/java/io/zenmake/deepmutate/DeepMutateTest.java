package io.zenmake.deepmutate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Talal Ahmed on 29/01/2023
 */
public class DeepMutateTest {

    private static final Logger log = LoggerFactory.getLogger(DeepMutateTest.class);

    @Test
    public void testDeepMutate() throws IOException {
        var filePath = "src/test/resources/mutate-java-project.dm";
        DeepMutate.run(filePath); // Fails fast in case of errors
    }

    @Disabled("Experimental tests")
    @Test
    public void testCodeDiff() {
        String c1 = "" + "class X {" + "int x = someNonVoidMethodCall();" + "}";
        String c2 = "" + "class X {" + " int x = 0;" + "}";

        /*
        AstComparator diff = new AstComparator(true);
        Diff editScript = diff.compare(c1, c2);

        for (var op : editScript.getRootOperations()) {
            var name = op.getAction().getName();
            var node = op.getAction().getNode();
        }
        log.debug(editScript);
        */
    }
}
