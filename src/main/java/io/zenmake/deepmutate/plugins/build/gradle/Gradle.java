package io.zenmake.deepmutate.plugins.build.gradle;

import io.zenmake.deepmutate.plugins.common.interfaces.BuildSystem;
import io.zenmake.deepmutate.plugins.common.interfaces.ResultListener;
import io.zenmake.deepmutate.plugins.common.model.TestResult;
import org.gradle.tooling.Failure;
import org.gradle.tooling.GradleConnectionException;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ResultHandler;
import org.gradle.tooling.events.OperationType;
import org.gradle.tooling.events.test.internal.DefaultTestFailureResult;
import org.gradle.tooling.events.test.internal.DefaultTestFinishEvent;
import org.gradle.tooling.events.test.internal.DefaultTestSkippedResult;
import org.gradle.tooling.events.test.internal.DefaultTestSuccessResult;

import java.io.File;
import java.util.stream.Collectors;

/**
 * Created by Talal Ahmed on 23/02/2023
 */
public final class Gradle implements BuildSystem {

    private static String TASK_BUILD = "build";
    private static String TASK_TEST = "test";

    private Gradle() {
    }

    public static Gradle create() {
        return new Gradle();
    }

    public void run(String projectDir, ResultListener<? super TestResult> listener) {
        var connector = GradleConnector.newConnector();
        connector.forProjectDirectory(new File(projectDir));
        var connection = connector.connect();

        var build = connection.newBuild()
                .forTasks(TASK_BUILD)
                .addProgressListener(event -> {
                    if (event instanceof DefaultTestFinishEvent x) {
                        var descriptor = x.getDescriptor().getDisplayName();

                        if (x.getResult() instanceof DefaultTestFailureResult t) {
                            if (!t.getFailures().isEmpty()) {
                                var result = TestResult.createFailed(t.getStartTime(), t.getEndTime(), descriptor);
                                var traces = t.getFailures()
                                        .stream()
                                        .map(Failure::getDescription)
                                        .collect(Collectors.joining());
                                result.setStacktrace(traces);
                                listener.onResult(result);
                            }

                        } else if (x.getResult() instanceof DefaultTestSkippedResult t) {
                            var result = TestResult.createSkipped(t.getStartTime(), t.getEndTime(), descriptor);
                            listener.onResult(result);

                        } else if (x.getResult() instanceof DefaultTestSuccessResult t) {
                            var result = TestResult.createPassed(t.getStartTime(), t.getEndTime(), descriptor);
                            listener.onResult(result);
                        }
                    }
                }, OperationType.TEST);

        build.run(new ResultHandler<>() {
            @Override
            public void onComplete(Void result) {
                listener.onComplete(TestResult.STATUS_COMPLETE);
            }

            @Override
            public void onFailure(GradleConnectionException failure) {
                listener.onFailure(failure);
            }
        });

        connection.close();
    }

}
