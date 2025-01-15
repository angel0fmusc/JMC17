package dev.interview.algorithms;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        char[] letters = {'a','d','z','e','r','b'};
        Arrays.sort(letters);
//        System.out.println(Arrays.toString(letters));

        int[] unsortedNumbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.print("Original: ");
        System.out.println(Arrays.toString(unsortedNumbers));

        System.out.println("Bubble Sort: " + Arrays.toString(myBubbleSort(unsortedNumbers)));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(unsortedNumbers)));
    }

    public static int[] myBubbleSort(int[] unsortedArray){
        int[] sortedNumbers = Arrays.copyOf(unsortedArray, unsortedArray.length);
        int maxIndex = sortedNumbers.length-2;
        for(int i = maxIndex; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int num1 = sortedNumbers[j];
                int num2 = sortedNumbers[j+1];
                if(num1 > num2){
                    sortedNumbers[j+1] = num1;
                    sortedNumbers[j] = num2;
                }
            }
        }
        return sortedNumbers;
    }

    public static void videoBubbleSort(int[] arr){
        int length = arr.length;
        for(int i = 0; i < length-1; i++){
            for(int j = 0; j < length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static int[] selectionSort(int[] unsortedArray){
        int[] sortedNumbers = Arrays.copyOf(unsortedArray, unsortedArray.length);
        int smallestNo;
        int smallestNoIndex;

        for(int i = 0; i < sortedNumbers.length; i++){
            smallestNo = sortedNumbers[i];
            smallestNoIndex = i;
            for(int j = i+1; j < sortedNumbers.length; j++){
                if(sortedNumbers[j] < smallestNo){
                    smallestNo = sortedNumbers[j];
                    smallestNoIndex = j;
                }
            }
            sortedNumbers[smallestNoIndex] = sortedNumbers[i];
            sortedNumbers[i] = smallestNo;
        }

        return sortedNumbers;
    }
}
