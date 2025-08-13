package dev.lpa;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(40);
        minHeap.add(10);
        minHeap.add(50);
        minHeap.add(30);
        minHeap.add(60);
        System.out.println(minHeap.peek());
        minHeap.poll();
        System.out.println(minHeap.peek());

//        while(!minHeap.isEmpty()){
//            System.out.println(minHeap.poll());
//        }

    }
}
