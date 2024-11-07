package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(readIntegers()));
        int[] array = readIntegers();
        int min = findMin(array);
        System.out.println(min);

    }

    public static int[] readIntegers(){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];

        System.out.printf("Enter %d numbers below.%n", array.length);
        for(int i = 0; i < array.length; i++){
            System.out.printf("Number %d: ", i+1);
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int findMin(int[] array){
        Arrays.sort(array);
        return array[0];
    }
}
