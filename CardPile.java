// Peter de Ruiter
// CSCI 1913
// Project 2
// Card Pile

/**
 * This class creates an object of type CardPile and follow the guidelines for a cardPile in a game
 * of uno war provided to us in the instructions
 */
public class CardPile {
    private Card topCard;
    private int numCards = 0;
    public CardPile(Card topCard){
        this.topCard = topCard;
        numCards = 1;
    }

    /**
     * Determines if the card is playable using the topCard of the deck
     * @param card the card being compared to the topCard
     * @return returns true if the card is playable else false
     */
    public boolean canPlay(Card card){
        if(card.getRankNum() >= topCard.getRankNum()){ // if the rank is bigger or equal to the top card
            return true;
        }
        else if(card.getSuitName() == topCard.getSuitName()){ // if they are both the same suit
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * This function plays the specifed card
     * @param card the card being played
     */
    public void play(Card card){
        if(card == null){ // if the card is null, outputs error message, no card is played
            System.out.println("Illegal move detected!");
        }
        else if(canPlay(card)){ // if the card is playable the topCard is assigned the playable card and
            // the number of the cards in the pile is increased by one
            topCard = card;
            numCards++;
        }
        else{ // All other moves are not legal
            System.out.println("Illegal move detected!");
        }
    }

    public int getNumCards() {
        return numCards;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }
}
