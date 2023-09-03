// Peter de Ruiter
// CSCI 1913
// Project 2
// Deck
import java.util.Random;

/**
 * This class creates an object of type deck and follows the guidelines of a deck in a game of uno war
 */
public class Deck {
    private Card[] newDeck = new Card[52];
    private int cardCount = 0;

    /**
     * This constructor creates a new deck of cards (an Array of cards)
     */
    public Deck(){
        Card newDeck[] = new Card[52];
        int counter = 0;
        for(int i = 0; i < 52; i++){ // Assigns each index in the array with a card
            if (i < 13){ // The first 13 cards are assigned spades
                newDeck[i] = new Card(i + 1, 1);
            }
            else if (13 <= i && i < 26){ // The second set of the 13 cards are assigned clubs
                newDeck[i] = new Card((i - 12), 2);
            }
            else if (26 <= i && i < 39){ // The third set of 13 cards are assigned hearts
                newDeck[i] = new Card((i - 25), 3);
            }
            else { // The last 13 card are assigned to be diamonds
                newDeck[i] = new Card((i - 38), 4);
            }


        }
        this.newDeck = newDeck;
        shuffle(); // shuffles the deck
        this.newDeck = newDeck;
    }

    /**
     * This function does take any parameters and uses the Durstenfelt-Fisher-Yates algoritim to shuffle
     * the array of cards (the deck).
     */
    public void shuffle(){
        Random rand = new Random();
        for (int i = 51; i > 0; i--) { // This loop works back from the last assigning the last position of the array first.
            int j = rand.nextInt(i + 1); // chooses a random index, the number can be between 0 and the amount of cards left
            Card placeHolder = newDeck[i]; // The placholder is assigned the card in the last index that has not yet been shuffled
            newDeck[i] = newDeck[j]; // The last unnshuffled psosition is assigned the random card chosen
            newDeck[j] = placeHolder; // The index of where the random card was chose from is assigned the card that was previously in the location of the card.
        }
    }

    /**
     * This function returns the top card of when the deck still has cards, if the deck is empty the
     * deck is reshuffled the amount of cards drawn from the deck is reset and the new top card is returned
     * @return the function returns the top card in the deck
     */
    public Card draw(){
        if(isEmpty()){ // Uses the isEmpty function to determine if the deck is empty or not
            shuffle();
            cardCount = 1;
            //System.out.println(newDeck[0]);
            return newDeck[0];
        }
        else{
            cardCount++;
           // System.out.println(newDeck[cardCount-1]);
            return newDeck[cardCount - 1];
        }
    }

    /**
     * This function subtract the amount of cards that have been drawn from the deck from 52
     * @return the function returns the amount of cards left in the deck
     */
    public int cardsRemaining(){
        return 52 - cardCount;
    }

    /**
     * Checks if the deck is empty, the deck is empty when 52 cards have been drawn
     * @return returns true if 52 cards have been drawn else false
     */
    public boolean isEmpty(){
        if(cardCount == 52){ // if 52 cards have been drawn
            return true;
        }
        else{
            return false;
        }
    }

    public int getCardCount() {
        return cardCount;
    }

    public void setCardCount(int cardCount) {
        this.cardCount = cardCount;
    }

    public Card[] getNewDeck() {
        return newDeck;
    }

    public void setNewDeck(Card[] newDeck) {
        this.newDeck = newDeck;
    }
}
