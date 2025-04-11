package dev.interview.algorithms;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i =0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(1000);
        }

        System.out.println("Before:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("\nAfter:");
        printArray(numbers);
    }

    private static void mergeSort(int[] inputArray){

        int inputLength = inputArray.length;

        //Exit case: Array has 1 element
        if(inputLength < 2){
            return;
        }

        // Divide the inputArray into two halves

        int midIndex = inputLength/2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength-midIndex]; // Accounts for odd-numbered lengths

        // Populate left half array
        for (int i = 0; i < midIndex; i++){
            leftHalf[i] = inputArray[i];
        }

        for(int i = midIndex; i < inputLength; i++){
            rightHalf[i-midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
//        System.out.println("Left:");
//        printArray(leftHalf);
//        System.out.println("Right:");
//        printArray(rightHalf);


        /*
        * Compare the first element of each array
        * Take the element that is smaller and add it to the merged array
        * Increment to the next element in the array that housed the smaller element
        * */

        merge(inputArray, leftHalf, rightHalf);

    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while(i < leftSize && j < rightSize){
            if(leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            } else{
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        // Add remaining elements
        while(i < leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while(j < rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    /**
     * Takes an integer array and prints out the array
     * @param numbers: Array of ints
     */
    public static void printArray(int[] numbers){
        System.out.println(Arrays.toString(numbers));
    }
}
