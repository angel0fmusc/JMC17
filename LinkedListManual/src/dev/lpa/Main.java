package dev.lpa;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList myLinkedList = new SinglyLinkedList(10);
        myLinkedList.printList();

        myLinkedList.append(5);
        myLinkedList.append(16);
        myLinkedList.printList();

        myLinkedList.prepend(25);
        myLinkedList.printList();
        System.out.println("List length so far: " + myLinkedList.getLength());
        myLinkedList.insert(2, 500);
        myLinkedList.printList();
        myLinkedList.insert(-1,30);
        myLinkedList.insert(100,35);
        myLinkedList.printList();
        myLinkedList.insert(0,30);
        myLinkedList.insert(5,35);
        myLinkedList.printList();
        System.out.println("List length so far: " + myLinkedList.getLength());
        myLinkedList.insert(1, 20);
        myLinkedList.printList();

        // Remove by index
        myLinkedList.remove(-1);
        myLinkedList.printList();
        Node removedNode = myLinkedList.remove(100);
        System.out.println("Removed node with value: " + removedNode.getValue());
        myLinkedList.printList();
        removedNode = myLinkedList.remove(3);
        System.out.println("Removed node with value: " + removedNode.getValue());
        myLinkedList.printList();
        removedNode = myLinkedList.remove(0);
        System.out.println("Removed node with value: " + removedNode.getValue());
        myLinkedList.printList();


    }
}
