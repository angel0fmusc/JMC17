package dev.lpa;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        List<Card> deck = Card.getStandardDeck();
//        Card.printDeck(deck);
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

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed deck of cards", 4);

        var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed:",13);

        List<Card> kings = new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings,"Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16,20));
        Card.printDeck(tens,"Tens in deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, tens); //will return an integer if tens is found in the deck
        System.out.println("Sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint = " + disjoint2);

        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        Collections.sort(deck,sortingAlgorithm);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("Result of foundIndex = " + foundIndex);
        System.out.println(deck.get(foundIndex));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32,36), "Tens row", 1);

        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32,36), "Tens row", 1);

        System.out.println("Ten of Clubs Cards = " +
                Collections.frequency(deck, tenOfClubs));

        System.out.println("Best Card = " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgorithm));

        var sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit, Rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, 2); // Positive number passed moved elements from the end of the list
        // to the front of the list
        System.out.println("Unrotated: " + deck.subList(0,13));
        System.out.println("Rotated " + 2 + ": " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, -2); // Positive number passed moved elements from the end of the list
        // to the front of the list
        System.out.println("Unrotated: " + deck.subList(0,13));
        System.out.println("Rotated " + -2 + ": " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        for(int i = 0; i < copied.size() / 2; i++){
            Collections.swap(copied,i, copied.size()-1-i);
        }
        System.out.println("Manual reverse: " + copied);
    }
}
