package dev.lpa;

public class Node2 {
    private int value;
    private Node2 next;
    private Node2 previous;

    public Node2(int value, Node2 next, Node2 previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node2(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }

    public Node2 getPrevious() {
        return previous;
    }

    public void setPrevious(Node2 previous) {
        this.previous = previous;
    }
}
