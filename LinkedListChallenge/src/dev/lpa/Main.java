package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        LinkedList<Location> placesToVisit = new LinkedList<>();
        Location[] towns = {
                new Location("Sydney",0),
                new Location("Adelaide", 1374),
                new Location("Alice Springs", 2771),
                new Location("Brisbane", 917),
                new Location("Darwin", 3972),
                new Location("Darwin", 3972),
                new Location("Melbourne", 877),
                new Location("Perth", 3923)
        };
        for (Location place : towns) {
            addPlace(placesToVisit, place);
        }
        System.out.println(placesToVisit);
        forward(placesToVisit);
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
}
