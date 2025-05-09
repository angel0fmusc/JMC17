package dev.lpa;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.printTree();
        tree.insert(35);
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

        tree.remove(15);
        tree.printTree();

        tree.insert(15);
        tree.printTree();

        List<Integer> result = tree.breadthFirstSearch();
        System.out.println(result);

        List<Integer> result2 = tree.breadthFirstSearchRecursive();
        System.out.println("Recursively BFS: " + result2);

        List<Integer> dfsInOrderResult = tree.depthFirstSearchInOrder(DfsSearchType.IN_ORDER);
        System.out.println("DFS In Order: " + dfsInOrderResult);

        List<Integer> dfsPreOrder = tree.depthFirstSearchInOrder(DfsSearchType.PRE_ORDER);
        System.out.println("DFS Pre-Order: " + dfsPreOrder);

        List<Integer> dfsPostOrder = tree.depthFirstSearchInOrder(DfsSearchType.POST_ORDER);
        System.out.println("DFS Post-Order: " + dfsPostOrder);
    }
}
