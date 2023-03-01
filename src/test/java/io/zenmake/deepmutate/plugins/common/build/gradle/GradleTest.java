package io.zenmake.deepmutate.plugins.common.build.gradle;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Created by Talal Ahmed on 23/02/2023
 */
public class GradleTest {

    @Test
    public void testGradle() {
        throw new NotImplementedException();
    }

    @Disabled("Only for experimental purposes")
    @Test
    public void testCommandLine() {
        String command = ""; //PATH_TO_GRADLE_PROJECT + GRADLEW_EXECUTABLE + BLANK + GRADLE_TASK;
        try {
            // var p = Runtime.getRuntime().exec(command);
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.inheritIO();
            Process p = builder.start();
            // System.out.println(IOUtils.toString(p.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
