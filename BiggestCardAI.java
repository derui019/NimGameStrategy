// Peter de Ruiter
// CSCI 1913
// Project 2
// Biggest Card AI

/**
 * This class extends the AI class and overides the play function to play the biggest cards, versus playing
 * random cards.
 */
public class BiggestCardAI extends AI{
    private Hand hand;
    private CardPile cardPile;

    /**
     * This function determines all playable cards in the deck and the determines which of the playable cards
     * is the largest. The largest card is returned, if there are no playable cards null is returned
     * @param hand the hand of cards being checked
     * @param cardPile checks if the card is playble on the topCard of the cardPile
     * @return this function returns the largest playable card else null
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        this.hand = hand;
        this.cardPile = cardPile;
        Card biggestCard = new Card(1, 1);
        int counter = 0;
        for (int i = 0; i < hand.getSize(); i++) { // Runs through all of the cards in the hand
            Card chosenCard = hand.get(i);
            if (cardPile.canPlay(chosenCard)) { // checks if the card is playable
                if (counter == 0) { // for the first playable card
                    biggestCard = chosenCard;
                    counter = 10; // variable to know that it is not the first playable card
                } else if (chosenCard.getRankNum() > biggestCard.getRankNum()) { // if the card is bigger the
                    // current biggest card the biggest card is assigned that card.
                    biggestCard = chosenCard;
                }
            }
        }
        if (counter == 10) { // if a playable card was found, return biggest card
            return biggestCard;
        } else { // if no playable cards were found return null
            return null;
        }
    }



    @Override
    public String toString() {
        return "Biggest Card AI";
    }
}
