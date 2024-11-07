package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        int[] forthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(forthArray));
        Arrays.sort(forthArray);

        System.out.println("Third Array unsorted: " + Arrays.toString(thirdArray));
        System.out.println("Forth Array (copy of third, sorted): " + Arrays.toString(forthArray));

        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        if(Arrays.binarySearch(sArray, "Mark") >= 0){
            System.out.println("Found Mark in the list");
        } else {
            System.out.println("Not found");
        }



    }

    public static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];
        // Enhanced for loop not suitable for setting values in an array
//        for (int element: newInt) {
//            element = random.nextInt(100);
//        }

        for(int i=0; i < len; i++){
            newInt[i] = random.nextInt(100);
        }

        return newInt;
    }
}
