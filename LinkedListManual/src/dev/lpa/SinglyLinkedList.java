package dev.lpa;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public int getLength() {
        return length;
    }

    public Node getTail() {
        return tail;
    }

    public Node getHead() {
        return head;
    }

    public void printList(){
        if(head == null){
            return;
        }

        Node currentNode = head;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while(currentNode != null){
            System.out.print(" --> " + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public void append(int value){
        Node newNode = new Node(value);
        this.tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    public void prepend(int  value){
        head = new Node(value, head);
        length++;
    }

    private Node traverseList(int index){
        Node iterator = head;
        int iteratorIndex = 0;
        while(iteratorIndex < index){
            iterator = iterator.getNext();
            iteratorIndex++;
        }
        return iterator;
    }

    public void insert(int index, int value){
        if(index > length-1 || index < 0){
            System.out.println("Invalid index: " + index);
        } else if (index == 0) {
            prepend(value);
        } else if (index == length-1) {
            append(value);
        } else{
            // need to traverse the list
            Node leader = traverseList(index-1);
            leader.setNext(new Node(value, leader.getNext()));
            length++;
        }
    }

    public Node remove(int index){
        Node removedNode;

        if(index < 0){ // remove first node?
            System.out.println("Invalid index: " + index);
            removedNode = null;
        } else if(index == 0){
            removedNode = head;
            head = removedNode.getNext();
            removedNode.setNext(null);
            length--;
        }
        else if(index >= length-1){
            // remove the last node
            Node leader = traverseList(length-2);
            removedNode = leader.getNext();
            leader.setNext(null);
            tail = leader;
            length--;
        }
        else{
            Node leader = traverseList(index-1);
            removedNode = leader.getNext();
            leader.setNext(removedNode.getNext());
            removedNode.setNext(null);
            length--;
        }
        return removedNode;
    }
}
