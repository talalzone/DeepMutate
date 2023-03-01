package io.zenmake.deepmutate.plugins.common.model;

/**
 * Created by Talal Ahmed on 19/02/2023
 */
public class Codebase {

    private String id;

    private String type;

    private String dirPath;

    private String filePath;

    private String content;

    public Codebase() {
    }

    public Codebase(String id, String type, String content) {
        this(id,type, null, null, content);
    }

    public Codebase(String id, String type, String dirPath, String filePath) {
        this(id, type, dirPath, filePath, null);
    }

    public Codebase(String id, String type, String dirPath, String filePath, String content) {
        this.id = id;
        this.type = type;
        this.dirPath = dirPath;
        this.filePath = filePath;
        this.content = content;
    }

    public static Codebase from(Codebase codebase, String content) {
        var cb = new Codebase();
        cb.id = codebase.getId();
        cb.type = codebase.getType();
        cb.dirPath = codebase.getDirPath();
        cb.filePath = codebase.getFilePath();
        cb.content = content;
        return cb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirPath() {
        return dirPath;
    }

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Codebase{" +
                "codebaseId='" + id + '\'' +
                ", type='" + type + '\'' +
                ", dirPath='" + dirPath + '\'' +
                ", filePath='" + filePath + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
