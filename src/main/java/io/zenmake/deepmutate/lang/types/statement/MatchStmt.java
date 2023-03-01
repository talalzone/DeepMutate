package io.zenmake.deepmutate.lang.types.statement;

/**
 * Created by Talal Ahmed on 04/02/2023
 */
public class MatchStmt {

    private String pattern;

    public MatchStmt() {
    }

    public MatchStmt(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
