package dev.lpa;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.printTree();
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);
        tree.printTree();

        if (tree.lookup(6) != null) {
            System.out.println("Found 6!");
        } else {
            System.out.println("Did not find 6");
        }

        if (tree.lookup(125) != null) {
            System.out.println("Found 125!");
        } else {
            System.out.println("Did not find 125");
        }

    }
}
