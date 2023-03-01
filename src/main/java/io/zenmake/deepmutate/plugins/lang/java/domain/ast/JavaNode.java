package io.zenmake.deepmutate.plugins.lang.java.domain.ast;

import com.github.javaparser.ast.Node;

import java.util.Objects;

/**
 * Wrapper on top of com.github.javaparser.ast.Node
 * <p>
 * Created by Talal Ahmed on 30/01/2023
 */
public final class JavaNode {


    private Node node;

    private Class clazz;

    private String type;

    public JavaNode(Node node) {
        this.node = node;
    }

    public static JavaNode from(Node node) {
        var n = new JavaNode(node);
        n.clazz = n.node.getClass();
        n.type = n.clazz.getSimpleName(); // type corresponds to classname
        return n;
    }

    public Node getNode() {
        return node;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaNode jNode = (JavaNode) o;
        return Objects.equals(clazz, jNode.clazz) && Objects.equals(type, jNode.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, clazz, type);
    }

    @Override
    public String toString() {
        return node + ", " + type;
    }

}
