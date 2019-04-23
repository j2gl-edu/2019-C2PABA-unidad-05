package edu.advanced.unit5.tree;

public class NodeTree {

    private Integer value;
    private NodeTree left;
    private NodeTree right;

    public NodeTree(Integer value) {
        this.value = value;
    }

    public void add(Integer value) {
        if (value < this.value) {
            if (left != null) {
                left.add(value);
            } else {
                left = new NodeTree(value);
            }
        } else {
            if (right != null) {
                right.add(value);
            } else {
                right = new NodeTree(value);
            }
        }
    }

    public NodeTree find(Integer value) {
        if (value.equals(this.value)) {
            return this;
        } else if (value < this.value) {
            if (this.left != null) {
                return this.left.find(value);
            } else {
                return null;
            }
        } else {
            if (this.right != null) {
                return this.right.find(value);
            } else {
                return null;
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(value);
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.println(value);
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printPosOrder() {
        if (left != null) {
            left.printPosOrder();
        }
        if (right != null) {
            right.printPosOrder();
        }
        System.out.println(value);
    }

    // Getters y setters
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }

}
