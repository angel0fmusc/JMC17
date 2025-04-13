package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> hand = new ArrayList<>();
    private int handValue = 0;
    private final boolean dealer;

    public Hand(List<Card> deck, boolean isDealer) {
        if(!deck.isEmpty()){
            for(int i = 0; i < 2; i++){
                Card tempCard = deck.remove(i);
                handValue += tempCard.rank();
                hand.add(tempCard);
            }
        }
        dealer = isDealer;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getHandValue() {
        return handValue;
    }

    public void printHand(){
        if(dealer){
            Card.printDeck(List.of(hand.get(0)), "Dealer's hand", 1);
            return;
        }

        Card.printDeck(hand, "Player's hand (" + handValue + ")", 1);
    }

}
