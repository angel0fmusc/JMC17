package dev.lpa;

public class DoublyLinkedList {
    private Node2 head;
    private Node2 tail;
    private int length;

    public DoublyLinkedList(int value) {
        head = new Node2(value);
        tail = head;
        length = 1;
    }

    public Node2 getHead() {
        return head;
    }

    public Node2 getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printForwardList(){
        if(head == null){
            return;
        }

        Node2 currentNode = head;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while(currentNode != null){
            System.out.print(" --> " + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public void printBackwardList(){
        if(tail == null){
            return;
        }

        Node2 currentNode = tail;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getPrevious();
        while(currentNode != null){
            System.out.print(" --> " + currentNode.getValue());
            currentNode = currentNode.getPrevious();
        }
        System.out.println();
    }

    /**
     * Add to the end of the doubly linked list
     * @param value - an integer
     */
    public void append(int value){
        Node2 newNode = new Node2(value, null, tail); // Create a new node
        this.tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    /**
     * Add to the beginning of the doubly linked list
     * @param value - an integer
     */
    public void prepend(int value){
        Node2 newNode = new Node2(value, head, null);
        this.head.setPrevious(newNode);
        head = newNode;
        length++;
    }

    private Node2 traverseForward(int index){
        Node2 iterator = head;
        int iteratorIndex = 0;
        while(iteratorIndex < index){
            iterator = iterator.getNext();
            iteratorIndex++;
        }
        return iterator;
    }

    private Node2 traverseBackward(int index){
        Node2 iterator = tail;
        int iteratorIndex = length-1;
        while(iteratorIndex > index){
            iterator = iterator.getPrevious();
            iteratorIndex--;
        }
        return iterator;
    }

    /**
     * Insert past the head or before the tail of the
     * doubly linked list
     * @param index - an int, the index to insert to
     * @param value - an int, the value to insert
     */

    public void insert(int index, int value){
        if(index > length-1 || index < 0){
            System.out.println("Invalid index: " + index);
        } else if (index == 0) {
            prepend(value);
        } else if (index == length-1) {
            append(value);
        } else{
            // need to traverse the list
            Node2 before = traverseForward(index-1);
            Node2 after = before.getNext();
            Node2 doubleNode = new Node2(value, after, before);
            before.setNext(doubleNode);
            // Need to get the next node after the leader
            after.setPrevious(doubleNode);
            length++;
        }
    }

    public Node2 remove(int index){
        Node2 removedNode;

        if(index < 0){ // remove first node?
            System.out.println("Invalid index: " + index);
            removedNode = null;
        } else if(index == 0){
            removedNode = head;
            head = removedNode.getNext(); // Set head to the next node
            // Set the next and previous of the removed node to null
            removedNode.setNext(null);
            removedNode.setPrevious(null);
            // Set the previous of the new head to null
            head.setPrevious(null);
            length--;
        } else if(index >= length-1){
            // remove the last node
            Node2 leader = traverseBackward(index-1);
            removedNode = leader.getNext();
            removedNode.setPrevious(null);
            leader.setNext(null);
            tail = leader;
            length--;
        }
        else{
            // If the index is greater than half the length
            // Traverse backward, otherwise traverse forward
            if(index > length/2){
                //traverse backwards
                Node2 afterRemovedNode = traverseBackward(index+1);
                removedNode = afterRemovedNode.getPrevious();

                afterRemovedNode.setPrevious(removedNode.getPrevious());
                (removedNode.getPrevious()).setNext(afterRemovedNode);
            } else{ //traverse forwards
                Node2 beforeRemovedNode = traverseForward(index-1);
                removedNode = beforeRemovedNode.getNext();
                // Need to get the getNext of removedNode and getPrevious of removed
                // node to connect those
                beforeRemovedNode.setNext(removedNode.getNext());
                (removedNode.getNext()).setPrevious(beforeRemovedNode);
                // Set the previous and next of the removedNode to null
            }
            removedNode.setNext(null);
            removedNode.setPrevious(null);
            length--;
        }
        return removedNode;
    }
}
