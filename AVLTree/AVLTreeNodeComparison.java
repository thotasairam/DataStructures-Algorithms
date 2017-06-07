/**
 * Sai Ram Thota
 * CWID 11573236
 * Data Structures Project
 *
 */

public class AVLTreeNodeComparison <T1 extends Comparable<T1>, T2 extends AVLTreeNodeData> {
    AVLTreeNode<T1, T2> n;
    int comp;

    public AVLTreeNodeComparison(AVLTreeNode<T1, T2> n, int comp) {
        this.n = n;
        this.comp = comp;
    }

    public AVLTreeNode<T1, T2> getNode() {
        return n;
    }


    public AVLTreeNodeComparison setNode(AVLTreeNode<T1, T2> n) {
        this.n = n;
        return this;
    }


    public int getComparison() {
        return comp;
    }


    public AVLTreeNodeComparison setComparison(int comp) {
        this.comp = comp;
        return this;
    }
}