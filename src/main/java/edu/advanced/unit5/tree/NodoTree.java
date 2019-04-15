package edu.advanced.unit5.tree;

public class NodoTree {
    private Integer value;
    private NodoTree left;
    private NodoTree right;

    public NodoTree(Integer value) {
        this.value = value;
    }
    // ... Getters y setters

    public void add(Integer value) {
        if (value < this.value) {
            if (left != null) {
                left.add(value);
            } else {
                left = new NodoTree(value);
            }
        } else {
            if (right != null) {
                right.add(value);
            } else {
                right = new NodoTree(value);
            }
        }
    }

    public NodoTree find(Integer value) {
        if (value == this.value) {
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
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
        System.out.println(value);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public NodoTree getLeft() {
        return left;
    }

    public void setLeft(NodoTree left) {
        this.left = left;
    }

    public NodoTree getRight() {
        return right;
    }

    public void setRight(NodoTree right) {
        this.right = right;
    }

}
