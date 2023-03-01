package io.zenmake.deepmutate.plugins.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import java.util.List;

/**
 * Created by Talal Ahmed on 16/02/2023
 */
public class Mutation {

    public static final String STATUS_MUTATION_COMPLETE = "mutation_complete";
    public static final String STATUS_ANALYSIS_NOT_STARTED = "analysis_not_started";
    public static final String STATUS_ANALYSIS_IN_PROGRESS = "analysis_in_progress";
    public static final String STATUS_ANALYSIS_COMPLETE = "analysis_complete";

    @BsonId
    @BsonProperty("_id")
    @JsonProperty("_id")
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String id;

    private String codebaseId;

    private String mutationId;

    private String inputType;

    private String mutationType;

    private String language;

    private Codebase sourceCode;

    private Codebase mutatedCode;

    private int line;

    private Pattern pattern;

    private String status;

    private Analysis analysis;


    public Mutation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodebaseId() {
        return codebaseId;
    }

    public void setCodebaseId(String codebaseId) {
        this.codebaseId = codebaseId;
    }

    public String getMutationId() {
        return mutationId;
    }

    public void setMutationId(String mutationId) {
        this.mutationId = mutationId;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getMutationType() {
        return mutationType;
    }

    public void setMutationType(String mutationType) {
        this.mutationType = mutationType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Codebase getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(Codebase sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Codebase getMutatedCode() {
        return mutatedCode;
    }

    public void setMutatedCode(Codebase mutatedCode) {
        this.mutatedCode = mutatedCode;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    @BsonIgnore
    @JsonIgnore
    public boolean isAnalysisComplete() {
        return STATUS_ANALYSIS_COMPLETE.equals(this.status);
    }

    @BsonIgnore
    @JsonIgnore
    public boolean isMutationComplete() {
        return STATUS_MUTATION_COMPLETE.equals(this.status);
    }

    @Override
    public String toString() {
        return "Mutation{" +
                "id='" + id + '\'' +
                ", codebaseId='" + codebaseId + '\'' +
                ", mutationId='" + mutationId + '\'' +
                ", inputType='" + inputType + '\'' +
                ", mutationType='" + mutationType + '\'' +
                ", language='" + language + '\'' +
                ", sourceCode=" + sourceCode +
                ", mutatedCode=" + mutatedCode +
                ", line=" + line +
                ", pattern=" + pattern +
                ", status='" + status + '\'' +
                ", analysis=" + analysis +
                '}';
    }

    public static class Pattern {

        private String match;
        private String where;
        private List<String> updates;
        private List<String> inserts;

        public Pattern() {
        }

        public Pattern(String match, List<String> updates) {
            this(match, null, updates, null);
        }

        public Pattern(String match, String where, List<String> updates) {
            this(match, where, updates, null);
        }

        public Pattern(String match, String where, List<String> updates, List<String> inserts) {
            this.match = match;
            this.where = where;
            this.updates = updates;
            this.inserts = inserts;
        }

        public String getMatch() {
            return match;
        }

        public void setMatch(String match) {
            this.match = match;
        }

        public String getWhere() {
            return where;
        }

        public void setWhere(String where) {
            this.where = where;
        }

        public List<String> getUpdates() {
            return updates;
        }

        public void setUpdates(List<String> updates) {
            this.updates = updates;
        }

        public List<String> getInserts() {
            return inserts;
        }

        public void setInserts(List<String> inserts) {
            this.inserts = inserts;
        }

        @Override
        public String toString() {
            return "Pattern{" +
                    "match='" + match + '\'' +
                    ", where='" + where + '\'' +
                    ", updates=" + updates +
                    ", inserts=" + inserts +
                    '}';
        }
    }

}
