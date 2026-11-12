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
    private int size;
    private T[] array;

    public BTree() {
        this.root = null;
        this.size = 0;
    }

    public boolean empty() {
        return this.root == null;
    }

    public void add(NodeTree<T> node) {
        this.root = this.addNode(this.root, node);
        size++;
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

    private int height(NodeTree<T> root)
    {
        if (root == null)
        {
            return 0;
        }
        int left = height(root.getLeft());
        int right = height(root.getRight());

        return Math.max(left, right) + 1;
    }

    public int height()
    {
        return height(root);
    }

    @SuppressWarnings("unchecked")
    public T[] toArray()
    {
        this.array = (T[])new Object[size];
        
        toArray(this.root, 0);

        return (T[])this.array;
    }

    private int toArray(NodeTree<T> root, int index)
    {
        if (root == null)
        {
            return index;
        }
        index = toArray(root.getLeft(), index);
        this.array[index] = root.getInfo();
        return toArray(root.getRight(), index + 1);
    }

}
