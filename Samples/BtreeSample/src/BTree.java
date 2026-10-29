/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amaffeis
 */
public class BTree<T> {

    private NodeTree<T> root;

    public BTree() {
        this.root = null;
    }

    public boolean empty() {
        return this.root == null;
    }

    public void add(NodeTree<T> node) {
        this.root = this.addNode(this.root, node);
    }

    private NodeTree<T> addNode(NodeTree<T> root, NodeTree<T> newNode) {
        if (root == null) {
            return newNode;
        }
        Integer nodeValue = ((Integer) newNode.getInfo());
        Integer rootValue = ((Integer) root.getInfo());
        
        if (nodeValue <= rootValue) {
            root.setLeft(this.addNode(root.getLeft(), newNode));
        } else {
            root.setRight(this.addNode(root.getRight(), newNode));
        }
        return root;
    }
    
    public void show() {
        showTree(this.root, 0);
    }
    
    public void showTree(NodeTree<T> root, int times) {
        if (root == null) {
            return;
        }

        showTree(root.getLeft(), times + 1);
        System.out.println("\t".repeat(times) + ((Integer)root.getInfo()).intValue() + ".");   
        showTree(root.getRight(), times + 1);
    }
}
