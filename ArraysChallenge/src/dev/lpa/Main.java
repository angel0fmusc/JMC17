package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int arrayLength = 10;
        int[] myArray = getRandomArray(arrayLength);
        System.out.println("First Array (unsorted): " + Arrays.toString(myArray));
        Arrays.sort(myArray); // sorts in ascending order
        System.out.println("First Array (sorted): " + Arrays.toString(myArray));

        int[] reverseArray = new int[arrayLength];

        for(int i = 0; i < arrayLength; i++){
            reverseArray[i] = myArray[arrayLength-1-i];
        }

        System.out.println("Reverse sorted array: " + Arrays.toString(reverseArray));

        int[] sortedArray = sortIntegers(new int[] {7,30,35});
        System.out.println(Arrays.toString(sortedArray));
        
    }

    public static int[] getRandomArray(int len){
        Random random = new Random();
        int[] intArray = new int[len];

        for(int i=0; i < len; i++){
            intArray[i] = random.nextInt(1000);
        }

        return intArray;
    }

    public static int[] sortIntegers(int[] array){

        System.out.println(Arrays.toString(array));
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;

            for(int i=0; i < sortedArray.length -1; i++){
                if(sortedArray[i] < sortedArray[i+1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                    System.out.println("----->" + Arrays.toString(sortedArray));
                }
            }
            System.out.println("--->" + Arrays.toString(sortedArray));
        }

        return sortedArray;
    }
}
