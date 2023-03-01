package io.zenmake.deepmutate.plugins.lang.java.analyze.runtime;

import io.zenmake.deepmutate.plugins.common.interfaces.*;
import io.zenmake.deepmutate.plugins.common.model.Analysis;
import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.common.model.TestResult;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Talal Ahmed on 17/02/2023
 */
public final class RuntimeAnalyzer implements Analyzer {

    private static final Logger log = LoggerFactory.getLogger(RuntimeAnalyzer.class);

    private final MutationReader reader;
    private final MutationWriter writer;
    private final BuildSystem build;


    private RuntimeAnalyzer(MutationReader reader, MutationWriter writer, BuildSystem build) {
        this.reader = reader;
        this.writer = writer;
        this.build = build;
    }

    public static Analyzer create(MutationReader reader, MutationWriter writer, BuildSystem buildSystem) {
        var analyzer = new RuntimeAnalyzer(reader, writer, buildSystem);
        return analyzer;
    }

    @Override
    public void analyze(String codebaseId) {
        log.info("Runtime analyzer started for '{}'.", codebaseId);

        // Iterate over mutations
        for (var itr = reader.findByCodebaseId(codebaseId); itr.hasNext(); )  {
            var mutation = itr.next();

            if (mutation.isAnalysisComplete()) {
                log.debug("Skipping mutation: {}", mutation);
            } else {
                log.debug("Analyzing mutation: {}", mutation);

                var dir = mutation.getMutatedCode().getDirPath();
                var file = mutation.getSourceCode().getFilePath();
                var mutatedCode = mutation.getMutatedCode().getContent();

                // Perform changes in project source code
                update(file, mutatedCode);

                // Run build/tests
                build.run(dir, new ResultListener<>() {
                    private final Analysis analysis = new Analysis();

                    @Override
                    public void onResult(TestResult result) {
                        switch (result.getStatus()) {
                            case TestResult.STATUS_FAILED -> analysis.addFailed(result);
                            case TestResult.STATUS_PASSED -> analysis.addPassed(result);
                            case TestResult.STATUS_SKIPPED -> analysis.addSkipped(result);
                            default -> log.error("Unknown test result: {}", result);
                        }
                    }

                    @Override
                    public void onComplete(String status) {
                        update(mutation, analysis);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        update(mutation, analysis);
                    }
                });
            }
        }

        log.info("Runtime analyzer completed.");
    }

    private void update(Mutation mutation, Analysis analysis) {
        mutation.setAnalysis(analysis);
        log.debug("Analyzed mutation: {}", mutation);

        // Replace the original mutation with the one having Analysis results
        mutation.setStatus(Mutation.STATUS_ANALYSIS_COMPLETE);
        writer.replace(mutation);

        // Revert project source code to original form
        var file = mutation.getSourceCode().getFilePath();
        var sourceCode = mutation.getSourceCode().getContent();
        update(file, sourceCode);
    }

    private void update(String filePath, String content) {
        try {
            FileUtils.writeStringToFile(new File(filePath), content, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
