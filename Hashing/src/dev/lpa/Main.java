package dev.lpa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l","He","lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(
                aText, bText, cText, dText, eText
        );

        hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));

        /**
         * HashSet is the
         */
        Set<String> mySet = new HashSet<>(hellos);
        System.out.println("mySet = " + mySet);
        System.out.println("# of elements = " + mySet.size());

        for(String setVal : mySet){
            System.out.print(setVal + ": ");
            for(int i = 0; i < hellos.size(); i++){
                if(setVal == hellos.get(i)){
                    System.out.print(i + ", ");
                }
            }
            System.out.println(" ");
        }

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards =
                Arrays.asList(aceHearts,kingClubs,queenSpades);

        cards.forEach(card -> System.out.println(card + ": " + card.hashCode()));

        Set<PlayingCard> deck = new HashSet<>();
        for(PlayingCard c : cards){
            if(!deck.add(c)){
                System.out.println("Found a duplicate for " + c);
            }
        }
        System.out.println(deck);
    }
}
