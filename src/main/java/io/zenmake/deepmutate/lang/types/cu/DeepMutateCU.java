package io.zenmake.deepmutate.lang.types.cu;

import io.zenmake.deepmutate.lang.types.declaration.ProjectDecl;

import java.util.ArrayList;
import java.util.List;

/**
 * DeepMutate Compilation Unit (CU)
 * <p></p>
 * Created by Talal Ahmed on 02/02/2023
 */
public class DeepMutateCU {

    private List<ProjectDecl> projectDeclList;

    public DeepMutateCU() {
        this.projectDeclList = new ArrayList<>();
    }

    public void add(ProjectDecl projectDecl) {
        this.projectDeclList.add(projectDecl);
    }

    public List<ProjectDecl> getProjectDeclList() {
        return projectDeclList;
    }

    public void setProjectDeclList(List<ProjectDecl> projectDeclList) {
        this.projectDeclList = projectDeclList;
    }

}
