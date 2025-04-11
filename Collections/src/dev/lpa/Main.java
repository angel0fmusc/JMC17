package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);
//        Card.printDeck(deck, "Less Cards per row", 10);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART,'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        /*
        * Collections class has a fill method that is similar to Arrays.fill() method.
        * It takes a List and an element. The fill() method would fill the list
        * if the list size() was greater than 0; it will replace every element with the
        * element passed to the method.
        * The fill method does not actually add elements.
        * If the provided List is empty, then it will stay empty.
        * */
        List<Card> cards = new ArrayList<>(52); // Only initiates the capacity; does not fill with null references
        Collections.fill(cards, aceOfHearts); // Does not actually add elements
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        /*
        * Can use Collections.nCopies() method to create a new list with the number of
        * elements specified as the first argument and the element to fill the list with
        * as the second argument.
        * */
        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        /*
        * Like List, the Collections class includes an addAll() method.
        * First argument = List to add elements to
        * Second argument = Elements to be added
        * List's addAll method takes a Collection of elements to be added
        * */
        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        /*
        * The Collections.copy() method takes 2 arguments:
        *  - Destination of the copied elements, in this case, the cards List
        *  - Elements to be copied
        *
        * Cannot use the copy method if the number of elements is the current list
        * is less than the number of elements in the source list.
        * */
        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);
    }
}
