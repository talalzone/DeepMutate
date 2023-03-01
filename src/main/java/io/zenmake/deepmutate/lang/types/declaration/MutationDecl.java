package io.zenmake.deepmutate.lang.types.declaration;

import io.zenmake.deepmutate.lang.types.conf.MutationConf;
import io.zenmake.deepmutate.lang.types.statement.InsertStmt;
import io.zenmake.deepmutate.lang.types.statement.MatchStmt;
import io.zenmake.deepmutate.lang.types.statement.UpdateStmt;
import io.zenmake.deepmutate.lang.types.statement.WhereStmt;

import java.util.List;

/**
 * Created by Talal Ahmed on 04/02/2023
 */
// TODO: change name to MutantDecl -- Mutant causes mutations ???
public class MutationDecl {

    private String id;

    private MutationConf conf;

    private MatchStmt matchStmt;

    private WhereStmt whereStmt;

    private List<UpdateStmt> updateStmtList;

    private List<InsertStmt> insertStmtList;


    public MutationDecl() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MutationConf getConf() {
        return conf;
    }

    public void setConf(MutationConf conf) {
        this.conf = conf;
    }

    public void setMatchStmt(MatchStmt matchStmt) {
        this.matchStmt = matchStmt;
    }

    public MatchStmt getMatchStmt() {
        return matchStmt;
    }

    public WhereStmt getWhereStmt() {
        return whereStmt;
    }

    public void setWhereStmt(WhereStmt whereStmt) {
        this.whereStmt = whereStmt;
    }

    public List<UpdateStmt> getUpdateStmtList() {
        return updateStmtList;
    }

    public void setUpdateStmtList(List<UpdateStmt> updateStmtList) {
        this.updateStmtList = updateStmtList;
    }

    public List<InsertStmt> getInsertStmtList() {
        return insertStmtList;
    }

    public void setInsertStatementList(List<InsertStmt> insertStmtList) {
        this.insertStmtList = insertStmtList;
    }

}
