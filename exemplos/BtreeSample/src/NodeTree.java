/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amaffeis
 */
public class NodeTree<T> {
    private NodeTree<T> left;
    private NodeTree<T> right;
    private T info;

    public NodeTree(T info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public void setLeft(NodeTree<T> left) {
        this.left = left;
    }

    public void setRight(NodeTree<T> right) {
        this.right = right;
    }

    public T getInfo() {
        return info;
    }

    public NodeTree<T> getLeft() {
        return left;
    }

    public NodeTree<T> getRight() {
        return right;
    }
}
