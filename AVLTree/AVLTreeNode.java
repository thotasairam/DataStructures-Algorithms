/**
 * Sai Ram Thota
 * CWID 11573236
 * Data Structures Project
 *
 */

public class AVLTreeNode<T1 extends Comparable<T1>, T2 extends AVLTreeNodeData> {

    T1 key;
    T2 data;
    AVLTreeNode<T1, T2> leftRoot;
    AVLTreeNode<T1, T2> rightRoot;
    int height;


    public AVLTreeNode(T1 key, T2 data) {
        this(key, data, null, null);
    }


    public AVLTreeNode(T1 key, T2 data, AVLTreeNode<T1, T2> leftRoot, AVLTreeNode<T1, T2> rightRoot) {
        this.key = key;
        this.data = data;
        this.leftRoot = leftRoot;
        this.rightRoot = rightRoot;
        this.height = 0;
    }


    public T1 getKey() {
        return key;
    }


    public AVLTreeNode setKey(T1 key) {
        this.key = key;
        return this;
    }


    public T2 getValue() {
        return data;
    }


    public AVLTreeNode setValue(T2 data) {
        this.data = data;
        return this;
    }


    public AVLTreeNode<T1, T2> getLeft() {
        return leftRoot;
    }


    public AVLTreeNode setLeft(AVLTreeNode<T1, T2> leftRoot) {
        this.leftRoot = leftRoot;
        return this;
    }


    public AVLTreeNode<T1, T2> getRight() {
        return rightRoot;
    }


    public AVLTreeNode setRight(AVLTreeNode<T1, T2> rightRoot) {
        this.rightRoot = rightRoot;
        return this;
    }


    public int getHeight() {
        return height;
    }


    public AVLTreeNode setHeight(int height) {
        this.height = height;
        return this;
    }
}
