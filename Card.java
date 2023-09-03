// Peter de Ruiter
// CSCI 1913
// Project 2
// Card

/**
 * This class creates an object of type card and follows the specified guidelines of the cards class provided
 */
public class Card {
    private int rank;
    private int suit;
    private String[] rankName = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private String[] suitName = {"Spades", "Hearts", "Clubs", "Diamonds"};

    /**
     * The Card constructor determines if the given rank and suit are valid and creates a card given
     * with those specifications
     * @param rank takes an integer between 1 and 13 and assigns it a card rank
     * @param suit takes an integer between 1 and 4 and assigns it to a corresponding suit
     */
    public Card(int rank, int suit) {
        boolean validCard = true;
        if ((rank > 0 && rank < 14) && (suit == 1 || suit == 2 || suit == 3 || suit == 4)) { // checks if the rank is between 1 and 13
            this.rank = rank;
            this.suit = suit;
        }
        else {
            System.out.println("Invalid Card");
            this.rank = 1;
            this.suit = 1;
            validCard = false;
        }
    }

    public int getRankNum() {
        return rank;
    }

    /**
     * This function returns the corresponding string of the value of rank
     * @return the string corresponing to the rank
     */
    public String getRankName() {
        String rankStr;
        rankStr = rankName[(rank - 1)]; // rankStr is assigned the string stored in the index of the rank-1 in the rankName array
        return rankStr;
    }

    /**
     * This function returns the name of the suit corresponding to the suit number given
     * @return returns the string name of the suit number
     */
    public String getSuitName() {
        String suitStr;
        suitStr = suitName[(suit - 1)]; // suitStr is assigned the string stored in the index of the suit number -1 of the suitName array
        return suitStr;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setRankName(String[] rankName) {
        this.rankName = rankName;
    }

    public void setSuitName(String[] suitName) {
        this.suitName = suitName;
    }

    @Override
    public String toString() {
        return (getRankName() + " of " + getSuitName());
    }

    /**
     * This function checks if an object is equal to the card.
     * @param obj the object being compared
     * @return if they are equal returns true, else false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            Card card = (Card) obj;
            return card.rank == rank && card.suit == suit;
        }
        return false;
    }
}
