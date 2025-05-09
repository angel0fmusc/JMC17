package dev.lpa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum DfsSearchType { IN_ORDER, PRE_ORDER, POST_ORDER }

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    int count = 0;
    public void printTree() {
        count = 0;
        printTree(root);
    }

    private void printTree(Node node) {
        System.out.print(node.getValue());
        System.out.println();
        count++;
        if(node.getLeft() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) + "Left: ");
            printTree(node.getLeft());
        }
        if(node.getRight() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) +"Right: ");
            printTree(node.getRight());
        }
        count--;
    }

    /**
     * Insert a node into the Binary Search Tree in order
     * @param value - int to be inserted
     */
    public void insert(int value){
        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
            return;
        }

        // Get current node
        Node currentNode = root;
        // Compare incoming value to root
        while(currentNode != null){
            if(value < currentNode.getValue()){
                // Traverse left
                // Exit case: currentNode.left is null
                if(currentNode.getLeft() == null){
                    currentNode.setLeft(newNode);
                    return;
                } else{
                    currentNode = currentNode.getLeft();
                }
            } else if (value > currentNode.getValue()) {
                // Traverse right
                // Exit case: currentNode.right is null
                if(currentNode.getRight() == null){
                    currentNode.setRight(newNode);
                    return;
                } else{
                    currentNode = currentNode.getRight();
                }
            } else{
                // Node values match; do not add
                return;
            }
        }

    }

    /**
     * Given a value, determine if the node
     * containing the value exists in the tree
     * @param value - int, the value to look for
     * @return - Node containing the value or null
     */
    public Node lookup(int value){
        if(root == null){
            return null;
        }

        Node currentNode = root;
        while(currentNode != null){
            if(value < currentNode.getValue()){
                // Traverse left
                currentNode = currentNode.getLeft();
            } else if(value > currentNode.getValue()){
                // traverse right
                currentNode = currentNode.getRight();
            } else{
                return currentNode;
            }
        }
        return null;
    }

    public void remove(int value) {
        if (root == null) {
            return;
        }

        Node nodeToRemove = root;
        Node parentNode = null;
        while (nodeToRemove.getValue() != value) { //Searching for the node to remove and it's parent
            parentNode = nodeToRemove;
            if (value < nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getLeft();
            } else if (value > nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getRight();
            }
        }

        Node replacementNode = null;
        if (nodeToRemove.getRight() != null) { //We have a right node
            replacementNode = nodeToRemove.getRight();
            if(replacementNode.getLeft() == null) { //We don't have a left node
                replacementNode.setLeft(nodeToRemove.getLeft());
            } else { //We have a have a left node, lets find the leftmost
                Node replacementParentNode = nodeToRemove;
                while (replacementNode.getLeft() != null) {
                    replacementParentNode = replacementNode;
                    replacementNode = replacementNode.getLeft();
                }
                replacementParentNode.setLeft(null);
                replacementNode.setLeft(nodeToRemove.getLeft());
                replacementNode.setRight(nodeToRemove.getRight());
            }
        } else if(nodeToRemove.getLeft() != null) {//We only have a left node
            replacementNode = nodeToRemove.getLeft();
        }

        if(parentNode == null) {
            root = replacementNode;
        } else if(parentNode.getLeft() == nodeToRemove) { //We are a left child
            parentNode.setLeft(replacementNode);
        } else { //We are a right child
            parentNode.setRight(replacementNode);
        }
    }

    public List<Integer> breadthFirstSearch(){
        Node currentNode = root;
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        // Add first node to the queue
        queue.add(currentNode);

        // Want to go from current node to its children node
        while(!queue.isEmpty()){
            // remove the first item in the queue and return it
            currentNode = queue.poll();
            list.add(currentNode.getValue());

            // Check if the current item has children
            // If so, add the children from left to right into
            // the queue.
            if(currentNode.getLeft() != null){
                queue.add(currentNode.getLeft());
            }
            if(currentNode.getRight() != null){
                queue.add(currentNode.getRight());
            }
        }

        return list;
    }

    public List<Integer> breadthFirstSearchRecursive(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        return breadthFirstSearchRecursive(queue, new ArrayList<>());
    }

    private List<Integer> breadthFirstSearchRecursive(Queue<Node> queue, List<Integer> list){

        /*
        * Exit condition - if the queue is empty, then return the existing list
        * back up the stack.
        * */
        if(queue.isEmpty()){
            return list;
        }

        // Pop the current value off the queue
        // and add it to the list.
        Node currentNode = queue.poll();
        list.add(currentNode.getValue());

        // Add the left and right children
        // to the queue
        if(currentNode.getLeft() != null){
            queue.add(currentNode.getLeft());
        }
        if(currentNode.getRight() != null){
            queue.add(currentNode.getRight());
        }

        // Recursively call the method
        return breadthFirstSearchRecursive(queue, list);
    }

    public List<Integer> depthFirstSearchInOrder(DfsSearchType searchType){
        if(searchType == DfsSearchType.IN_ORDER){
            return depthFirstSearchInOrder(root, new ArrayList<>());
        } else if (searchType == DfsSearchType.PRE_ORDER) {
            return dfsPreOrder(root, new ArrayList<>());
        } else{
            return dfsPostOrder(root, new ArrayList<>());
        }
    }

    private List<Integer> depthFirstSearchInOrder(Node currentNode, List<Integer> list){
        // Exit condition - on a leaf node
        if(currentNode.getLeft() == null && currentNode.getRight() == null){
            list.add(currentNode.getValue());
            return list;
        }

        // Traverse left and add child to list
        if(currentNode.getLeft() != null){
            depthFirstSearchInOrder(currentNode.getLeft(), list);
        }
        list.add(currentNode.getValue());
        if(currentNode.getRight() != null){
            depthFirstSearchInOrder(currentNode.getRight(), list);
        }
        return list;
    }

    /**
     * Depth First Search (DFS) Pre-Order implementation.
     * Parent, left child, right child
     * @param currentNode current Node we are on in the tree
     * @param list current list of integers from tree traversal
     * @return List of integers in post-order
     */
    private List<Integer> dfsPreOrder(Node currentNode, List<Integer> list){
        /*
        * DFS goes as far down the branches as possible
        * Pre-Order adds the parent, traverses left, then traverses right
        * */

        // Exit condition - on a leaf node
        if(currentNode.getLeft() == null && currentNode.getRight() == null){
            list.add(currentNode.getValue());
            return list;
        }

        list.add(currentNode.getValue());
        if(currentNode.getLeft() != null){
            dfsPreOrder(currentNode.getLeft(), list);
        }

        // Traverse down right branch
        if(currentNode.getRight() != null){
            dfsPreOrder(currentNode.getRight(), list);
        }

        return list;
    }

    /**
     * Depth First Search Post-Order implementation adds the children
     * before the parent to the list
     * @param currentNode type Node, current node in the tree
     * @param list List<Integers>, the current list of values from the tree
     *             in post-order
     * @return the list of integers
     */
    private List<Integer> dfsPostOrder(Node currentNode, List<Integer> list){
        /*
        * Add the children before the parent. The true root of the tree should
        * be the last value in the list.
        * */

        // Exit condition - leaf node; add value and return
        if(currentNode.getLeft() == null && currentNode.getRight() == null){
            list.add(currentNode.getValue());
            return list;
        }

        // Traverse left
        if(currentNode.getLeft() != null){
            dfsPostOrder(currentNode.getLeft(), list);
        }
        if(currentNode.getRight()!= null){
            dfsPostOrder(currentNode.getRight(), list);
        }
        list.add(currentNode.getValue());
        // Traverse right
        // Add parent

        return list;
    }


}
