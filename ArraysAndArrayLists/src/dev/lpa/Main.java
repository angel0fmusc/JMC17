package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] originalArray = new String[]{"first", "second", "third"};
        var originalArrayList = Arrays.asList(originalArray);

        originalArrayList.set(0,"one");
        System.out.println("list: " + originalArrayList);
        System.out.println("array: " + Arrays.toString(originalArray));
    }
}
