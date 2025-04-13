package dev.lpa;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);

        /*
        * Players and dealer are dealt 2 cards initially
        * */
        Hand houseHand = new Hand(deck, true);
        Hand playerHand = new Hand(deck, false);
//        Card.printDeck(houseHand.getHand(), "Dealer's hand ("+ houseHand.getHandValue()+ ")", 1);
//        Card.printDeck(playerHand.getHand(), "Player's hand", 1);

        houseHand.printHand();
        playerHand.printHand();

        System.out.println("Does Dealer have a natural BlackJack? " + naturalsCheck(houseHand, true));
        System.out.println("Does Player have a natural BlackJack? " + naturalsCheck(playerHand, false));

    }

    /**
     * After each hand is dealt, check if the players and dealer have a natural
     * Blackjack (i.e. an Ace and a 10). If the dealer has an Ace or 10 as their top
     * card, then they will look at their bottom card. The game is over if someone has
     * a natural blackjack.
     * @param currentHand List of Cards
     * @param isDealer a boolean if the current hand is held by the dealer
     * @return a boolean determining if the player has a natural
     */
    public static boolean naturalsCheck(Hand currentHand, boolean isDealer){
        /*
        * If the dealer's top card is not a face card, 10, or Ace, then
        * we do not check for a natural. Return false.
        * */
        if(isDealer && currentHand.getHand().get(0).rank() < 10){
            return false;
        }
        return currentHand.getHandValue() == 21;
    }
}
