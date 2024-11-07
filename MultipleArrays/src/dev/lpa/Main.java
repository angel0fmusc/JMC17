package dev.lpa;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] array2 = new int[4][4];
        System.out.println(Arrays.toString(array2));
        System.out.println("array2.length = " + array2.length);

//        for(int[] outer : array2){
//            System.out.println(Arrays.toString(outer));
//        }

        for(int[] row : array2){
            for(var element : row){
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.println(Arrays.deepToString(array2));

        array2[1] = new int[] {10,20,30};
        System.out.println(Arrays.deepToString(array2));
    }
}
