package dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] myArray = new int[5];

        for(int i = 0; i < myArray.length; i++){
            myArray[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(myArray));
        reverse(myArray);

    }

    private static void reverse(int[] array){
        int temp;
        int i = 0;
        int j = array.length -1;

        while(i < j){
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            i++;
            j--;
        }
        System.out.println(Arrays.toString(array));

    }
}
