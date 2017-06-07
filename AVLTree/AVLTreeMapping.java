/**
 * Sai Ram Thota
 * CWID 11573236
 * Data Structures Project
 *
 */

import java.util.List;


public class AVLTreeMapping <T1 extends Comparable<T1>, T2 extends AVLTreeNodeData> {


    private static final int ALLOWED_IMBALANCE = 1;


    AVLTreeNode<T1, T2> root;

    String[][] q = new String[10][10];

    String b = q[q.length-1][0];

    double c = Math.abs(Double.parseDouble(b));

    public AVLTreeMapping() {
        this(null);
    }


    public AVLTreeMapping(AVLTreeNode<T1, T2> root) {
        this.root = root;
    }


    public void insert(T1 key, T2 data, int index) {
        root = insert(key, data, index, root);
    }


    public void insert(T1 key, T2 data) {
        root = insert(key, data, -1, root);
    }


    private AVLTreeNode<T1, T2> insert(T1 key, T2 data, int index, AVLTreeNode<T1, T2> rootNode) {
        if (rootNode == null) {
            AVLTreeNode<T1, T2> node = new AVLTreeNode<>(key, data);
            addOccurenceToNode(node, index);
            return node;
        }

        if (key.equals(rootNode.getKey())) {
            addOccurenceToNode(rootNode, index);
        }

        int compareResult = key.compareTo(rootNode.getKey());

        if (compareResult < 0) {
            rootNode.setLeft(insert(key, data, index, rootNode.getLeft()));
        } else if (compareResult > 0) {
            rootNode.setRight(insert(key, data, index, rootNode.getRight()));
        }

        return balance(rootNode);
    }


    public void addOccurenceToNode(AVLTreeNode<T1, T2> node, int index) {
        if (index != -1) {
            node.getValue().addOccurrence(index);
        }
    }


    private AVLTreeNode<T1, T2> balance(AVLTreeNode<T1, T2> node) {
        if (node == null) {
            return null;
        }

        if (height(node.getLeft()) - height(node.getRight()) > ALLOWED_IMBALANCE) {
            if (height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())) {
                node = rotateWithLeftChild(node);

                //print out the rrt or llr
            } else {
                node = doubleWithLeftChild(node);
            }
        } else if (height(node.getRight()) - height(node.getLeft()) > ALLOWED_IMBALANCE) {
            if (height(node.getRight().getRight()) >= height(node.getRight().getLeft())) {
                node = rotateWithRightChild(node);


            } else {
                node = doubleWithRightChild(node);
            }
        }

        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        return node;
    }


    private int height(AVLTreeNode<T1, T2> node) {
        return node == null ? -1 : node.getHeight();
    }


    private AVLTreeNode<T1, T2> rotateWithLeftChild(AVLTreeNode<T1, T2> node2) {
        AVLTreeNode<T1, T2> node1 = node2.getLeft();
        node2.setLeft(node1.getRight());
        node1.setRight(node2);
        node2.height = Math.max(height(node2.getLeft()), height(node2.getRight())) + 1;
        node1.height = Math.max(height(node1.getLeft()), node2.getHeight()) + 1;
        return node1;
    }


    private AVLTreeNode<T1, T2> rotateWithRightChild(AVLTreeNode<T1, T2> node1) {
        AVLTreeNode<T1, T2> node2 = node1.getRight();
        node1.setRight(node2.getLeft());
        node2.setLeft(node1);
        node1.height = Math.max(height(node1.getLeft()), height(node1.getRight())) + 1;
        node2.height = Math.max(height(node2.getRight()), node1.getHeight()) + 1;
        return node2;
    }


    private AVLTreeNode<T1, T2> doubleWithLeftChild(AVLTreeNode<T1, T2> node) {
        node.setLeft(rotateWithRightChild(node.getLeft()));
        return rotateWithLeftChild(node);
    }


    private AVLTreeNode<T1, T2> doubleWithRightChild(AVLTreeNode<T1, T2> node) {
        node.setRight(rotateWithLeftChild(node.getRight()));
        return rotateWithRightChild(node);
    }


    public boolean isEmpty() {
        return root == null;
    }


    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }


    public void printCount() {
        if (isEmpty()) {
            System.out.println("Empty Tree");
        } else {
            printCount(root);
        }
    }


    private void printTree(AVLTreeNode<T1, T2> node) {
        if (node != null) {
            printTree(node.getLeft());
            System.out.println(node.getKey() + ": " + occurs(node.getKey()));
            printTree(node.getRight());
        }
    }


    private void printCount(AVLTreeNode<T1, T2> node) {
        if (node != null) {
            printCount(node.getLeft());
            System.out.println(node.getKey() + ": " + count(node.getKey()));
            printCount(node.getRight());
        }
    }


    public void remove(T1 key) {
        root = remove(key, root);
    }


    private AVLTreeNode<T1, T2> remove(T1 key, AVLTreeNode<T1, T2> node) {
        if (node == null) {
            return null;
        }

        int compareResult = key.compareTo(node.key);

        if (compareResult < 0) {
            node.setLeft(remove(key, node.getLeft()));
        } else if (compareResult > 0) {
            node.setRight(remove(key, node.getRight()));
        } else if (node.getLeft() != null && node.getRight() != null) {
            node.setKey(findMin(node.getRight()).getKey());
            node.setRight(remove(node.getKey(), node.getRight()));
        } else {
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        }
        return balance(node);
    }


    public AVLTreeNodeComparison<T1, T2> find(T1 key) {
        return find(key, root);
    }


    public void makeEmpty() {
        root = null;
    }


    public int getHeight() {
        return height(root);
    }


    private AVLTreeNode<T1, T2> findMin(AVLTreeNode<T1, T2> node) {
        if (node == null) {
            return null;
        }

        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }


    private AVLTreeNode<T1, T2> findMax(AVLTreeNode<T1, T2> node) {
        if (node == null) {
            return null;
        }
        while (node.getRight() != null) {
            node = node.getRight();
        }

        return node;
    }


    private AVLTreeNodeComparison<T1, T2> find(T1 key, AVLTreeNode<T1, T2> node) {
        int count = 0;
        while (node != null) {
            int compareResult = key.compareTo(node.key);
            if (compareResult < 0) {
                count++;
                node = node.getLeft();
            } else if (compareResult > 0) {
                count++;
                node = node.getRight();
            } else {
                return new AVLTreeNodeComparison<>(node, count);
            }
        }
        return new AVLTreeNodeComparison<>(null, -1);
    }


    public List<Integer> occurs(T1 key) {
        AVLTreeNode<T1, T2> node = find(key).getNode();
        if (node == null) {
            return null;
        }
        return node.getValue().getOccurrences();
    }


    public int count(T1 key) {
        AVLTreeNode<T1, T2> node = find(key).getNode();
        if (node == null) {
            return -1;
        }
        return node.getValue().getCount();
    }


    public AVLTreeNode<T1, T2> replace(T1 key1, T1 key2) {
        AVLTreeNode<T1, T2> node = find(key1).getNode();

        if (node == null) {
            return null;
        }

        if (key2 == null) {
            remove(key1);
            return new AVLTreeNode<>(null, null, null, null);
        }

        remove(key1);
        remove(key2);
        node.getValue().setValue(key2);
        return insert(key2, node.getValue(), -1, root);
    }
}
