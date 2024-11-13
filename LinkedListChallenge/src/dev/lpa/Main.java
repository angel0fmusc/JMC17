package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedList<Location> placesToVisit = new LinkedList<>();
        Location[] towns = {
                new Location("Sydney",0),
                new Location("Adelaide", 1374),
                new Location("Alice Springs", 2771),
                new Location("Brisbane", 917),
                new Location("Darwin", 3972),
                new Location("Melbourne", 877),
                new Location("Perth", 3923)
        };
        for (Location place : towns) {
            addPlace(placesToVisit, place);
        }
//        System.out.println(placesToVisit);
//        forward(placesToVisit);

        var iterator = placesToVisit.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();
        while(!quitLoop){
            if(!iterator.hasPrevious()){
                System.out.println("Originating: " + iterator.next());
                forward = true;
            }
            if(!iterator.hasNext()){ // At the end of the list
                System.out.println("Final: " + iterator.previous());
                forward = false;
            }
            System.out.print("Enter value: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0,1);
            switch(menuItem){
                case "F" -> {
                    System.out.println("User wants to go forward");
                    if(!forward){   // Reversing direction
                        forward = true;
                        if(iterator.hasNext()){
                            iterator.next();    // Adjust position forward
                        }
                    }
                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                }
                case "B" -> {
                    System.out.println("User wants to go backwards");
                    if(forward){   // Reversing direction
                        forward = false;
                        if(iterator.hasPrevious()){
                            iterator.previous();    // Adjust position backwards
                        }
                    }
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                }
                case "M" -> printMenu();
                case "L" -> System.out.println(placesToVisit);
                default -> quitLoop = true;
            }
        }


    }

    private static void printMenu(){
        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit""");
    }

    private static void addPlace(LinkedList<Location> list, Location place){
        if(list.contains(place)){
            System.out.println("Found duplicate: " + place);
            return;
        }

        for (Location location : list) {
            if(location.town().equalsIgnoreCase(place.town())){
                System.out.println("Found duplicate: " + place.town());
                return;
            }
        }

        int matchedIndex = 0;
        for (var listPlace : list) {
            if(place.distance() < listPlace.distance()){
                list.add(matchedIndex, place);
                return;
            }
            matchedIndex++;
        }
        list.add(place);
    }

    private static void forward(LinkedList<Location> list){
        ListIterator<Location> listIterator = list.listIterator(1);
        Location currentTown;
        while(listIterator.hasNext()){
            currentTown = listIterator.next();
            System.out.println("---> " + currentTown.town() + ": " +
                    currentTown.distance() + "km from Sydney");
        }
    }

    private static void backward(LinkedList<Location> list){

    }
}
