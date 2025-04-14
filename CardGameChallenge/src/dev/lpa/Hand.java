package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> hand = new ArrayList<>();
    private int handValue = 0;
    private boolean dealer;
    private boolean stand;
    private boolean busted;

    public Hand(List<Card> deck, boolean isDealer) {
        if(!deck.isEmpty()){
            for(int i = 0; i < 2; i++){
                Card tempCard = deck.remove(i);
                handValue += tempCard.rank();
                hand.add(tempCard);
            }
        }
        dealer = isDealer;
        stand = false;
        busted = false;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getHandValue() {
        return handValue;
    }

    public boolean isBusted() {
        return busted;
    }

    public void setBusted(boolean busted) {
        this.busted = busted;
    }

    public boolean isStand() {
        return stand;
    }

    public void setStand(boolean stand) {
        this.stand = stand;
    }

    public void setDealer(boolean dealer) {
        this.dealer = dealer;
    }

    /**
     * Hit mechanics. If the provided deck is not empty
     * Then remove 1 card. If that card is an Ace and the initial
     * rank of 11 causes the player to bust, then automatically
     * adjust the rank to 1.
     * @param deck a List of Cards
     */
    public void hit(List<Card> deck){
        if(!deck.isEmpty()){
            Card tempCard = deck.remove(0);
            if(tempCard.face().equals("A") && handValue + tempCard.rank() > 21){
                // adjust the card rank
                tempCard = new Card(tempCard.suit(), tempCard.face(), 1);
            }
            hand.add(tempCard);
            handValue += tempCard.rank();
            return;
        }
        System.out.println("Deck is empty");
    }

    public void printHand(String description){
        if(dealer){
            Card.printDeck(List.of(hand.get(0)), description + "'s hand", 1);
            return;
        }

        Card.printDeck(hand, description + "'s hand (" + handValue + ")", 1);
    }

}
