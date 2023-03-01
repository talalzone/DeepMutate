package io.zenmake.deepmutate.plugins.build.maven;

import io.zenmake.deepmutate.plugins.build.report.SurefireReport;
import io.zenmake.deepmutate.plugins.common.interfaces.BuildSystem;
import io.zenmake.deepmutate.plugins.common.interfaces.ResultListener;
import io.zenmake.deepmutate.plugins.common.model.TestResult;
import org.apache.commons.io.FilenameUtils;
import org.apache.maven.shared.invoker.*;
import org.apache.maven.shared.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Talal Ahmed on 23/02/2023
 */
public final class Maven implements BuildSystem {

    private static final Logger log = LoggerFactory.getLogger(BuildSystem.class);

    public static final String MAVEN_POM_FILE = "pom.xml";

    public static final String TASK_CLEAN = "clean";
    public static final String TASK_INSTALL = "install";
    public static final String TASK_TEST = "test";

    public static final String REPORT_DIR_PATH = "target/surefire-reports";
    public static final String REPORT_FILE_FORMAT = "xml";

    private Maven() {
    }

    public static Maven create() {
        return new Maven();
    }

    @Override
    public void run(String projectDir, ResultListener<? super TestResult> listener) {

        File basedir = new File(projectDir);
        File pom = new File(projectDir, MAVEN_POM_FILE);

        var request = new DefaultInvocationRequest();
        request.setBaseDirectory(basedir);
        request.setPomFile(pom);
        request.setShowErrors(true);
        request.setGoals(List.of(TASK_CLEAN, TASK_INSTALL));

        try {
            var invoker = newInvoker();
            invoker.execute(request);

            var reportDir = new File(projectDir, REPORT_DIR_PATH);
            var reportFiles = reportDir.listFiles(pathname -> FilenameUtils.getExtension(pathname.getName()).equals(REPORT_FILE_FORMAT));

            for (File file : reportFiles) {
                var report = SurefireReport.get(file);
                for (var test : report.testcase) {
                    if (test.failure != null) {
                        var result = TestResult.createFailed(0, 0, test.name);
                        result.setStacktrace(test.failure.content);
                        listener.onResult(result);
                    } else {
                        listener.onResult(TestResult.createPassed(0, 0, test.name));
                    }
                }
            }

            listener.onComplete(TestResult.STATUS_COMPLETE);

        } catch (MavenInvocationException | IOException e) {
            listener.onFailure(e);
            throw new RuntimeException(e);
        }
    }

    private Invoker newInvoker() {
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(findMavenHome());

        var logger = new SystemOutLogger();
        logger.setThreshold(InvokerLogger.ERROR);

        invoker.setLogger(logger);
        invoker.setLocalRepositoryDirectory(findLocalRepo());

        return invoker;
    }

    private File findMavenHome() {
        var mavenHome = System.getProperty("MAVEN_HOME", "/usr/local/bin/mvn");

        if (mavenHome == null) {
            throw new IllegalStateException(
                    "Cannot find Maven application " + "directory. Specify 'maven.home' system property");
        }

        return new File(mavenHome);
    }

    private File findLocalRepo() {
        var basedir = System.getProperty("maven.repo.local", "");

        if (StringUtils.isNotEmpty(basedir)) {
            return new File(basedir);
        }

        return null;
    }
}
