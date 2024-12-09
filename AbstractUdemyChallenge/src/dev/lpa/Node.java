package dev.lpa;

public class Node extends ListItem{


    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem setNext(ListItem rightLink) {
        return this.rightLink = rightLink;
    }

    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setPrevious(ListItem leftLink) {
        return this.leftLink = leftLink;
    }

    /**
     * Compare the value of the current node to a given node
     * If they are equal, return 0
     * If the current node is greater than the given node, return 1
     * otherwise, return -1
     * @param other - a node of type ListItem
     * @return an integer: -1, 0, or 1
     */
    @Override
    int compareTo(ListItem other) {
        int x = Integer.parseInt(String.valueOf(value)); // this object
        int y = Integer.parseInt(String.valueOf(other.value));
        if(x == y){
            return 0;
        }
        return x > y ? 1 : -1;
    }
}
