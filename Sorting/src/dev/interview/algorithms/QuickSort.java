package dev.interview.algorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i =0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("After:");
        printArray(numbers);

    }

    public static void quickSort(int[] inputArray, int lowIndex, int highIndex){

    }

    /**
     * Takes an integer array and prints out the array
     * @param numbers: Array of ints
     */
    public static void printArray(int[] numbers){
        System.out.println(Arrays.toString(numbers));
    }
}
