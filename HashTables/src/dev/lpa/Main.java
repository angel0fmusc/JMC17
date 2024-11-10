package dev.lpa;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        HashTable myHashTable = new HashTable(50);
        myHashTable.set("grapes", 10000);
        myHashTable.set("apples", 54);
        myHashTable.set("oranges", 2);

        System.out.println("value for key grapes: " + myHashTable.get("grapes"));
        System.out.println("value for key apple: " + myHashTable.get("apples"));
        System.out.println("value for key apple: " + myHashTable.get("oranges"));
        System.out.println("list of keys: " + Arrays.toString(myHashTable.keys()));
    }
}
