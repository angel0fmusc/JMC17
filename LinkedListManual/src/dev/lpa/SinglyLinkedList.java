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

    public void insert(int index, int value){
        if(index > length-1 || index < 0){
            System.out.println("Invalid index: " + index);
        } else if (index == 0) {
            prepend(value);
        } else if (index == length-1) {
            append(value);
        } else{
            // need to traverse the list
            Node iterator = head;
            int iteratorIndex = 0;
            while(iteratorIndex < index-1){
                iterator = iterator.getNext();
                iteratorIndex++;
            }
            iterator.setNext(new Node(value, iterator.getNext()));
            length++;
        }
    }
}
