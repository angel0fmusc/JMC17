package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {

    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        /**
         * this.ordinal() returns the position of 'this' constant in the enum.
         * Using the char[] array assigns the ASCII values to the constants; otherwise
         * the values returned by ordinal() would begin at 0. Order matters.
         * @return a char value of the ASCII table for the symbol
         */
        public char getImage(){
            return (new char[]{9827,9830,9829,9824})[this.ordinal()];
        }
    }

    @Override
    public String toString() {
        int index = face.equals("10") ? 2 : 1; // returns the number of digits to be retrieved
        /*
        * Retrieve either the first number or face field
        * of the card, or if the card is a 10 return 10
        * */
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }

    public static Card getNumericCard(Suit suit, int cardNumber){

        // Check if the card number is within the range of the numerical
        // values in a deck of cards: 2 - 10
        if(cardNumber > 1 && cardNumber < 11){
            // Lowest card has a rank of 0. Since 2 is the lowest, subtract 2 from the cardNumber
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
        }
        System.out.println("Invalid Numeric card selected");
        return null;
    }

    public static Card getFaceCard(Suit suit, char abbrev){
        // Validate the character passed is one of these 4 abbreviated
        // characters
        int charIndex = "JQKA".indexOf(Character.toUpperCase(abbrev));
        if(charIndex > -1){
            // J(ack) gets the rank of 9, A(ce) gets the rank of 12
            return new Card(suit, ""+abbrev, charIndex+9);
        }
        System.out.println("Invalid Face card selected");
        return null;
    }

    public static List<Card> getStandardDeck(){
        List<Card> deck = new ArrayList<>(52);
        for(Suit suit : Suit.values()){
            for(int i = 2; i <= 10; i++){
                deck.add(getNumericCard(suit, i));
            }
            for(char c : new char[]{'J','Q','K','A'}){
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> deck){
        printDeck(deck, "Current Deck", 4);
    }

    public static void printDeck(List<Card> deck, String description, int rows){
        System.out.println("-".repeat(30));
        if(description != null){
            System.out.println(description);
        }
        int cardsInRow = deck.size() / rows; // Number of cards to display divided by the given number of rows

        /*
        * Loop through the provided number of rows.
        * Determine the first card number and the last card number based on the row.
        * sublist(int start, int end) returns a new list that contains items
        * in the list between two indices. Note, the item at the last index is not
        * included.
        * */
        for(int i = 0; i < rows; i++){
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

}
