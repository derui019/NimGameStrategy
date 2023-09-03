// Peter de Ruiter
// CSCI 1913
// Project 2
// Ai (Random)

/**
 * This class creates an AI that can play a game of unoWar.
 */
public class AI {
    private Hand hand;
    private CardPile cardPile;

    /**
     * This function determines what the first playable card (finding the first is essentially random
     * since the deck was shuffled) in the hand is and returns that card, if there are no playable cards
     * in the hand the ai returns null.
     * @param hand the hand of cards being checked
     * @param cardPile checks if the the card is playble on the topCard of the cardPile
     * @return first playable card in hand else null
     */
    public Card getPlay(Hand hand, CardPile cardPile){
        this.hand = hand;
        this.cardPile = cardPile;
        for( int i = 0; i < hand.getSize(); i++){ // This loop find the first playable card and returns it
            Card chosenCard = hand.get(i);
            if(cardPile.canPlay(chosenCard)){
                return chosenCard;
            }
        }
        return null; // If no playable cards are found null is returned

    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public CardPile getCardPile() {
        return cardPile;
    }

    public void setCardPile(CardPile cardPile) {
        this.cardPile = cardPile;
    }


    @Override
    public String toString() {
        return "Random Card AI";
    }
}
