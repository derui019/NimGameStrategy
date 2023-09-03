// Peter de Ruiter
// CSCI 1913
// Project 2
// Smallest Card AI

/**
 * This class extends the Ai class and overides the getPlay function by returning the smallest card
 * possible instead of returning a random playable card.
 */
public class SmallestCardAI extends AI {
    private Hand hand;
    private CardPile cardPile;

    /**
     * This function determines which cards in the hand are playable and returns the smallest playable card.
     * @param hand the hand of cards being checked
     * @param cardPile checks if the the card is layble on the topCard of the cardPile
     * @return the function returns the smallest playable card in the hand, if there are no playable cards
     * null is returned.
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        this.hand = hand;
        this.cardPile = cardPile;
        Card smallestCard = new Card(13, 1);
        int counter = 0;
        for (int i = 0; i < hand.getSize(); i++) { // runs through all indexes of the hand array
            Card chosenCard = hand.get(i);
            if(cardPile.canPlay(chosenCard)){ // if the card is playable
                if(counter == 0){ // if this is the first playable card
                    smallestCard = chosenCard; // smallest card is the first playable card
                    counter = 10;
                }
                else if(chosenCard.getRankNum()< smallestCard.getRankNum()){ // if the ranks smaller then
                    // the current smallest card, smallest card is reassigned to be the current card.
                    smallestCard = chosenCard;
                }
            }
        }
        if (counter == 10) { //if a playable card was found
            return smallestCard;
        }
        else { // if no playable cards were found return null
            return null;
        }
    }

    @Override
    public String toString() {
        return "Smallest Card AI";
    }
}



