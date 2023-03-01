package io.zenmake.deepmutate.plugins.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Talal Ahmed on 22/02/2023
 */
public class Analysis {

    private int passed;

    private int failed;

    private int skipped;

    private List<TestResult> results;


    public Analysis() {
        this.results = new ArrayList<>();
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public int getSkipped() {
        return skipped;
    }

    public void setSkipped(int skipped) {
        this.skipped = skipped;
    }

    public List<TestResult> getResults() {
        return results;
    }

    public void setResults(List<TestResult> results) {
        this.results = results;
    }

    public void incPassed() {
        this.passed++;
    }

    public void incFailed() {
        this.failed++;
    }

    public void incSkipped() {
        this.skipped++;
    }

    public void addResult(TestResult result) {
        this.results.add(result);
    }

    public void addFailed(TestResult testResult) {
        incFailed();
        addResult(testResult);
    }

    public void addPassed(TestResult testResult) {
        incPassed();
        addResult(testResult);
    }

    public void addSkipped(TestResult testResult) {
        incSkipped();
        addResult(testResult);
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "passed=" + passed +
                ", failed=" + failed +
                ", skipped=" + skipped +
                ", results=" + results +
                '}';
    }
}
