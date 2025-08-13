package dev.lpa;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Stack myStack = new Stack();

        // Push
        myStack.push("google");
        myStack.push("udemy");
        myStack.push("discord");

        // Peek
        System.out.println(myStack.peek());

        // Pop
        System.out.println(myStack);
        System.out.println(myStack.pop());
        System.out.println(myStack);
        System.out.println(myStack.pop());

        /* Stack using Arrays instead */
//        String[] myArrayStack = new String[10];
        ArrayList<String> myArrayStack = new ArrayList<>();
        myArrayStack.add("google");
        myArrayStack.add("udemy");
        myArrayStack.add("discord");

        System.out.println(myArrayStack);

        myArrayStack.remove(myArrayStack.size()-1);
        System.out.println(myArrayStack);

//        Queue myQueue = new Queue();
//        myQueue.enqueue("Joy");
//        myQueue.enqueue("Matt");
//        myQueue.enqueue("Pavel");
//        myQueue.enqueue("Samir");
//        System.out.println("First item in queue: " + myQueue.peek());
//        System.out.println(myQueue);
//        System.out.println("Removing from queue: " + myQueue.dequeue()); // google
//        System.out.println("First item now in queue: " + myQueue.peek()); //udemy
//        System.out.println(myQueue);
//        System.out.println("Removing from queue: " + myQueue.dequeue()); //udemy
//        System.out.println("First item now in queue: " + myQueue.peek()); //discord
//        System.out.println(myQueue);
//        System.out.println("Removing from queue: " + myQueue.dequeue()); //discord
//        System.out.println("First item now in queue: " + myQueue.peek()); //empty
//        System.out.println(myQueue);

    }
}
