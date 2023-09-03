// Peter de Ruiter
// CSCI 1913
// Project 2
// Hand

/**
 * This class creates an object of type Hand that follows the guidelines of a hand in the fame of uno war.
 */
public class Hand {
    private int size;
    private Deck deck;
    private Card[] handCards;

    /**
     * This constructor takes a deck of cards and draws the amount of specified card into a hand of cards.
     * @param deck the deck that the function is drawing from
     * @param size the amount of cards in the hand
     */
    public Hand(Deck deck, int size){
        this.size = size;
        this.deck = deck;
        Card[] newHand = new Card[size]; //creates an array of cards of the specfied size
        if(size > 0){ // if the size of the hand is bigger then 0
            for (int i = 0; i < size; i++) { // draws a card into each index
                newHand[i] = deck.draw();
            }
        }
        handCards = newHand; //The private variable hand is assigned the array of cards

    }

    public int getSize() {
        return size;
    }

    /**
     * This function finds the card at the specified index, if the card is found it is returned else the
     * first card is returned and an error is outputted
     * @param i the index of the card we are looking for
     * @return the function returns the card at index i, of not found the first card is returned
     */
    public Card get(int i){
        if(i -1 > size || i < 0){ // checks if i is a valid index
            System.out.println("Invalid hand index!");
            return handCards[0];
        }
        else{
            return handCards[i];
        }
    }

    /**
     * This function removes a specified card from the hand and replaces by drawing a new card to that index.
     * @param card the card being removed from the hand
     * @return returns true if the card has been removed else false
     */
    public boolean remove(Card card) {
        int foundIndex = -1;
        for (int j = 0; j < size; j++) { // searches for the card in the array
            if (handCards[j] == card) { // if the card is found, foundIndex is assigned new index
                foundIndex = j;
            }
        }
        if (foundIndex != -1) { // if the card has been found
            handCards[foundIndex] = deck.draw(); // the index of said card is reassigned a new card from the deck
            return true;
        } else {
            return false;
        }
    }

    public Card[] getHandCards() {
        return handCards;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setHandCards(Card[] handCards) {
        this.handCards = handCards;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
