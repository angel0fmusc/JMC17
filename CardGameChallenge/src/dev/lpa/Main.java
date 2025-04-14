package dev.lpa;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Card> deck = Card.getStandardDeck();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Collections.shuffle(deck);

        /*
        * Players and dealer are dealt 2 cards initially
        * */
        Hand houseHand = new Hand(deck, true);
        Hand playerHand = new Hand(deck, false);

        houseHand.printHand("Dealer");
        playerHand.printHand("Player");
        boolean keepPlaying = true;

        while(true){

            if(naturalsCheck(houseHand, true) || naturalsCheck(playerHand,false)){
                System.out.println("Game over!");
                break;
            }

            // Player Game play
            /*
             * After each hit, calculate the current hand total. If the player busts (> 21), then the game is over
             * and the house wins. If the player's hand total is < 21, ask if they want to hit or stand
             */
            while(playerHand.getHandValue() <= 21 && !playerHand.isStand()){
                System.out.println("\nHit or stand? Enter 'H' for hit, or 'S' for stand: ");
                String choice = scanner.nextLine();
                switch(choice.toUpperCase()){
                    case "S":
                        playerHand.setStand(true);
                        break;
                    case "H":
                        playerHand.hit(deck);
                        break;
                    default:
                        System.out.println("Not a valid option");
                        break;
                }
                playerHand.printHand("Player");
                Collections.shuffle(deck);
            }

            if(playerHand.getHandValue() > 21){
                System.out.println("You busted\nCurrent hand value: " + playerHand.getHandValue());
                playerHand.setBusted(true);
            }

            /*
             * Dealer Play
             * After the Player's turn, the dealer's face-down card is turned up.
             * If the total is 17 or more, it must stand.
             * If the total is 16 or under, dealer must take a card and continue until
             * the hand value is 17 or more, but not over 21.
             * If the dealer has an ace, and counting it would bring the total to 17 or more
             * */
            houseHand.setDealer(false);
            houseHand.printHand("Dealer");

            while(houseHand.getHandValue() < 17 && !houseHand.isStand()){
                houseHand.hit(deck);
                houseHand.printHand("Dealer");
                Collections.shuffle(deck);

                if(houseHand.getHandValue() >= 17 && houseHand.getHandValue() <= 21){
                    houseHand.setStand(true);
                }
                
                if(houseHand.getHandValue() > 21){
                    houseHand.setBusted(true);
                }
            }
            
            // House and player bust
            if(houseHand.isBusted() && playerHand.isBusted()){
                System.out.println("Both the house and player have busted. Keep your bets");
            } else if(houseHand.getHandValue() == 21 && playerHand.getHandValue() == 21){ // Both get 21
                System.out.println("Both house and player have 21. Keep your bets");
            } else if (houseHand.getHandValue() > playerHand.getHandValue() && houseHand.getHandValue() <= 21) {
                System.out.println("House wins!");
            } else if(playerHand.getHandValue() > houseHand.getHandValue() && playerHand.getHandValue() <= 21){
                System.out.println("Player wins! Collect your bets!");
            } else{
                // Tie?
                System.out.println("\nSeems there might be a tie");
                houseHand.printHand("Dealer");
                playerHand.printHand("Player");
            }

            break;
        }

        scanner.close();
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
