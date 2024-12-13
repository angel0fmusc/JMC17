package dev.lpa;

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
}
