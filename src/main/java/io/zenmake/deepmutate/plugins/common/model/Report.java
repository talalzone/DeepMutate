package io.zenmake.deepmutate.plugins.common.model;

import java.util.List;

/**
 * Created by Talal Ahmed on 26/02/2023
 */
public class Report {

    private int totalMutations;

    private int totalFailedTests;

    private Mutant mutant;

    public int getTotalMutations() {
        return totalMutations;
    }

    public void setTotalMutations(int totalMutations) {
        this.totalMutations = totalMutations;
    }

    public int getTotalFailedTests() {
        return totalFailedTests;
    }

    public void setTotalFailedTests(int totalFailedTests) {
        this.totalFailedTests = totalFailedTests;
    }

    public void setMutant(Mutant mutant) {
        this.mutant = mutant;
    }

    public Mutant getMutant() {
        return mutant;
    }


    public static class Mutant {

        private String id;

        private String pattern;

        private int failed;

        private int passed;

        private int skipped;

        private List<String> descriptors;


        public Mutant() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public int getFailed() {
            return failed;
        }

        public void setFailed(int failed) {
            this.failed = failed;
        }

        public int getPassed() {
            return passed;
        }

        public void setPassed(int passed) {
            this.passed = passed;
        }

        public int getSkipped() {
            return skipped;
        }

        public void setSkipped(int skipped) {
            this.skipped = skipped;
        }

        public List<String> getDescriptors() {
            return descriptors;
        }

        public void setDescriptors(List<String> descriptors) {
            this.descriptors = descriptors;
        }

        public static Report.Mutant from(Mutation mutation) {
            var mutant = new Report.Mutant();
            mutant.setId(mutation.getMutationId());

            var analysis = mutation.getAnalysis();
            mutant.setFailed(analysis.getFailed());
            mutant.setPassed(analysis.getPassed());
            mutant.setSkipped(analysis.getSkipped());
            mutant.setDescriptors(analysis.getResults().stream().map(TestResult::getDescriptor).toList());

            return mutant;
        }
    }

}
