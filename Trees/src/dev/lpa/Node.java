package dev.lpa;

public class Node {

    private Node left;
    private Node right;
    private final int value;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }
}
