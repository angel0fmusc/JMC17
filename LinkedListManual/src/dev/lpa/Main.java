package dev.lpa;

public class Main {
    public static void main(String[] args) {
//        SinglyLinkedList myLinkedList = new SinglyLinkedList(10);
//        myLinkedList.printList();
//
//        myLinkedList.append(5);
//        myLinkedList.append(16);
//        myLinkedList.printList();
//
//        myLinkedList.prepend(25);
//        myLinkedList.printList();
//        System.out.println("List length so far: " + myLinkedList.getLength());
//        myLinkedList.insert(2, 500);
//        myLinkedList.printList();
//        myLinkedList.insert(-1,30);
//        myLinkedList.insert(100,35);
//        myLinkedList.printList();
//        myLinkedList.insert(0,30);
//        myLinkedList.insert(5,35);
//        myLinkedList.printList();
//        System.out.println("List length so far: " + myLinkedList.getLength());
//        myLinkedList.insert(1, 20);
//        myLinkedList.printList();
//
//        // Remove by index
//        myLinkedList.remove(-1);
//        myLinkedList.printList();
//        Node removedNode = myLinkedList.remove(100);
//        System.out.println("Removed node with value: " + removedNode.getValue());
//        System.out.println("List length so far: " + myLinkedList.getLength());
//        myLinkedList.printList();
//        removedNode = myLinkedList.remove(3);
//        System.out.println("Removed node with value: " + removedNode.getValue());
//        System.out.println("List length so far: " + myLinkedList.getLength());
//        myLinkedList.printList();
//        removedNode = myLinkedList.remove(0);
//        System.out.println("Removed node with value: " + removedNode.getValue());
//        System.out.println("List length so far: " + myLinkedList.getLength());
//        myLinkedList.printList();

        DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList(10);
        myDoublyLinkedList.printForwardList();
        myDoublyLinkedList.printBackwardList();

        // Append
        myDoublyLinkedList.append(5);
        myDoublyLinkedList.append(15);
        myDoublyLinkedList.printForwardList();
        myDoublyLinkedList.printBackwardList();

        // Prepend
        myDoublyLinkedList.prepend(25);
        System.out.println("List length so far: " + myDoublyLinkedList.getLength());
        myDoublyLinkedList.printForwardList();
        myDoublyLinkedList.printBackwardList();

        // Insert
        myDoublyLinkedList.insert(1,30);
        myDoublyLinkedList.insert(2, 500);
        myDoublyLinkedList.printForwardList();
        myDoublyLinkedList.printBackwardList();

        // Remove
        Node2 removedNode = myDoublyLinkedList.remove(3);
        System.out.println("Removed node with value: " + removedNode.getValue());
        myDoublyLinkedList.printForwardList();
        myDoublyLinkedList.printBackwardList();

        SinglyLinkedList mySingleList = new SinglyLinkedList(10);
        mySingleList.append(1);
        mySingleList.append(16);
        mySingleList.append(88);
        mySingleList.printList();
        SinglyLinkedList myReversedList = mySingleList.reverse();
        myReversedList.printList();

    }
}
