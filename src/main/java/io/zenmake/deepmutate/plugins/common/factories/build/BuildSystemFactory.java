package io.zenmake.deepmutate.plugins.common.factories.build;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.plugins.build.gradle.Gradle;
import io.zenmake.deepmutate.plugins.build.maven.Maven;
import io.zenmake.deepmutate.plugins.common.interfaces.BuildSystem;

/**
 * Created by Talal Ahmed on 23/02/2023
 */
public class BuildSystemFactory {

    public static BuildSystem getBuildSystem(String buildSystem) {
        return switch (buildSystem) {
            case InputConf.BUILD_GRADLE -> Gradle.create();
            case InputConf.BUILD_MAVEN -> Maven.create();
            default -> {
                throw new UnsupportedOperationException("No build system found for: " + buildSystem);
            }
        };
    }
}
