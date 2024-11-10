package dev.lpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean quit = false;
        ArrayList<String> groceryList = new ArrayList<>();
//        String items;
//        String[] itemsArray;

        while(!quit){
            System.out.printf("""
                    Available actions:%n
                    0 - to shutdown%n
                    1- to add item(s) to a list (comma delimited list)%n
                    2 - to remove any items (comma delimited list)%n
                    Enter a number for which action you want to do:\s""");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
//                case 1 -> {
//                    System.out.printf("%nEnter item(s) to add to the list. Press Enter to complete.%n");
//                    items = scanner.nextLine(); //need to split into an array
//                    itemsArray = items.split("\\s*,\\s*");
//                    for(int i = 0; i < itemsArray.length; i++){
//                        if(!groceryList.contains(itemsArray[i])){
//                            groceryList.add(itemsArray[i]);
//                        }
//                    }
//                }
                case 1 -> addItems(groceryList);
                case 2 -> removeItems(groceryList);
//                case 2 -> {
//                    System.out.printf("%nEnter item(s) to remove from the list. Press Enter to complete.%n");
//                    items = scanner.nextLine(); //need to split into an array
//                    itemsArray = items.split("\\s*,\\s*");
//                    for(int i = 0; i < itemsArray.length; i++){
//                        if(groceryList.contains(itemsArray[i])){
//                            groceryList.remove(itemsArray[i]);
//                        }
//                    }
//                }
                default -> quit = true;
            }
            groceryList.sort(Comparator.naturalOrder());
            System.out.println(groceryList);
        }
        System.out.println("Thanks for playing!");
    }

    private static void addItems(ArrayList<String> groceries){
        System.out.println("Add item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");
        for(String i : items){
            String trimmed = i.trim();
            if(!groceries.contains(trimmed)){
                groceries.add(trimmed);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceries){
        System.out.println("Remove item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");
        for(String i: items){
            String trimmed = i.trim();
            if(groceries.contains(trimmed)){
                groceries.remove(trimmed);
            }
        }
    }
}
