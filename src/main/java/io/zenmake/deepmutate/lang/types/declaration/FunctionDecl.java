package io.zenmake.deepmutate.lang.types.declaration;

import java.util.List;

/**
 * Created by Talal Ahmed on 04/02/2023
 */
public class FunctionDecl {

    private String funcId;

    private List<MutationDecl> mutationDeclList;

    public FunctionDecl() {
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public List<MutationDecl> getMutationDeclList() {
        return mutationDeclList;
    }

    public void setMutationDeclList(List<MutationDecl> decls) {
        this.mutationDeclList = decls;
    }
}
