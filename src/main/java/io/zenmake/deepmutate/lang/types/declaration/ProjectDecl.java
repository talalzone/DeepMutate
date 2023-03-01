package io.zenmake.deepmutate.lang.types.declaration;

import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;

import java.util.List;

/**
 * Created by Talal Ahmed on 02/02/2023
 */
public class ProjectDecl {

    private InputConf inputConf;

    private ProjectConf projectConf;

    private OutputConf outputConf;

    private List<FunctionDecl> functionDeclList;

    public ProjectDecl() {
    }

    public InputConf getInputConf() {
        return inputConf;
    }

    public void setInputConf(InputConf conf) {
        this.inputConf = conf;
    }

    public ProjectConf getProjectConf() {
        return projectConf;
    }

    public void setProjectConf(ProjectConf conf) {
        this.projectConf = conf;
    }

    public OutputConf getOutputConf() {
        return outputConf;
    }

    public void setOutputConf(OutputConf outputConf) {
        this.outputConf = outputConf;
    }

    public List<FunctionDecl> getFunctionDeclList() {
        return functionDeclList;
    }

    public void setFunctionDeclList(List<FunctionDecl> functionDeclList) {
        this.functionDeclList = functionDeclList;
    }

}
