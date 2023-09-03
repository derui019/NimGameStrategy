// Peter de Ruiter
// CSCI 1913
// Project 2
// Uno War Match

/**
 * This is a class that plays a game of uno War following the rules of uno War specified to us in
 * the project guidelines.
 */
public class UnoWarMatch {
    private AI ai1;
    private AI ai2;
    private Hand player1Hand;
    private Hand player2Hand;
    private CardPile gameCardPile;
    private boolean player1Alive = true;
    private boolean player2Alive = true;
    private int player1Points = 0;
    private int player2Points = 0;
    private Card player1Card;
    private Card player2Card;
    private boolean player1Turn = true;
    private Deck gameDeck;
    private boolean gameAlive = true;
    public UnoWarMatch(AI ai1, AI ai2){
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * This function plays a game of unowar (up to 10 points) using the AI's specified in the constructor.
     * The function then returns true if the AI1 wins and returns false if AI2 wins.
     * @return returns true if AI1 wins, false if AI2
     */
    public boolean playGame(){
        gameDeck = new Deck();
        player1Hand = new Hand(gameDeck, 5);
        player2Hand = new Hand(gameDeck, 5);
        player1Turn = true;
        player1Points = 0;
        player2Points = 0;
        while(player1Points < 10 && player2Points < 10){
            // The game is continued to be played until one player gets 10 points
            gameAlive = true;
            if(player1Turn){ // if player 1 is starting
                gameCardPile = new CardPile(gameDeck.draw());
                while(gameAlive){ // while both players still have playable cards
                    player1Card = ai1.getPlay(player1Hand,gameCardPile);
                    if(player1Card == null) {
                        //if the Ai has no playable cards the other Ai gets a point and starts the next turn
                        player2Points++;
                        player1Turn = false;
                        gameAlive = false;
                    }
                    else{ // if the card is playable, the card is played
                        gameCardPile.play(player1Card);
                        player1Hand.remove(player1Card);
                    }
                    player2Card = ai2.getPlay(player2Hand, gameCardPile);
                    if(player2Card == null){
                        // if Ai 2 does not have any playable cards, Ai 1 gets a point and starts next round
                        player1Points++;
                        player1Turn = true;
                        gameAlive = false;
                    }
                    else{ // if the card is playable the card is played
                        gameCardPile.play(player2Card);
                        player2Hand.remove(player2Card);
                    }
                }
            }
            else{ // if Ai2 is starting the round
                gameCardPile = new CardPile(gameDeck.draw());
                while(gameAlive){ // while both players have playable cards
                    player2Card = ai2.getPlay(player2Hand, gameCardPile);
                    if(player2Card == null){
                        // if the Ai has no playable cards, the opponent gets a point and starts next round
                        player1Points++;
                        player1Turn = true;
                        gameAlive = false;
                    }
                    else{ // if the card is playable, the card is played
                        gameCardPile.play(player2Card);
                        player2Hand.remove(player2Card);
                    }
                    player1Card = ai1.getPlay(player1Hand,gameCardPile);
                    if(player1Card == null) {
                        // if the player has no playable cards left the opponent gets a point and starts the next rounf
                        player2Points++;
                        player1Turn = false;
                        gameAlive = false;
                    }
                    else{ // if the card is playable, the card is played
                        gameCardPile.play(player1Card);
                        player1Hand.remove(player1Card);
                    }
                }
            }
        }
        if(player1Points == 10){ // if player 1 has 10 points returns true
            return true;
        }
        else if (player2Points == 10) { // if player 2 has 10 points returns false
            //System.out.println("Player 1 won: " + player1Points);
            return false;
        }
        else{ // if for some reason my code is buggy, prints an error ad returns false
            System.out.println("error in unowar");
            return false;
        }

    }

    /**
     * This function runs the play game function nTrials times and records which AI wins, the amount of
     * wins that AI1 gets is then divided by nTrials to determine AI1s win rate
     * @param nTrials the nnumber of times the game is played
     * @return a double representing the win rate of AI1
     */
    public double winRate(int nTrials){
        double player1Wins = 0.0;
        double player2Wins = 0.0;
        double winRate;

        for(int i = 0; i < nTrials; i++){ // runs a game of unoWar the specified amount of times
            if(playGame()){ // if player 1 wins, 1 is added to the win total
                player1Wins = player1Wins + 1.0;
            }
            else{ // if player 2 wins, 1 is added to win total
                player2Wins = player2Wins + 1.0;
            }
        }
        winRate = player1Wins/nTrials; // winrate is player1's wins divided by the amount of games played
        return winRate;
    }

    public AI getAi1() {
        return ai1;
    }

    public void setAi1(AI ai1) {
        this.ai1 = ai1;
    }

    public AI getAi2() {
        return ai2;
    }

    public void setAi2(AI ai2) {
        this.ai2 = ai2;
    }

    public boolean isGameAlive() {
        return gameAlive;
    }

    public void setGameAlive(boolean gameAlive) {
        this.gameAlive = gameAlive;
    }

    public boolean isPlayer1Alive() {
        return player1Alive;
    }

    public void setPlayer1Alive(boolean player1Alive) {
        this.player1Alive = player1Alive;
    }

    public boolean isPlayer2Alive() {
        return player2Alive;
    }

    public void setPlayer2Alive(boolean player2Alive) {
        this.player2Alive = player2Alive;
    }

    public boolean isPlayer1Turn() {
        return player1Turn;
    }

    public void setPlayer1Turn(boolean player1Turn) {
        this.player1Turn = player1Turn;
    }

    public Card getPlayer1Card() {
        return player1Card;
    }

    public void setPlayer1Card(Card player1Card) {
        this.player1Card = player1Card;
    }

    public Card getPlayer2Card() {
        return player2Card;
    }

    public void setPlayer2Card(Card player2Card) {
        this.player2Card = player2Card;
    }

    public CardPile getGameCardPile() {
        return gameCardPile;
    }

    public void setGameCardPile(CardPile gameCardPile) {
        this.gameCardPile = gameCardPile;
    }

    public Deck getGameDeck() {
        return gameDeck;
    }

    public void setGameDeck(Deck gameDeck) {
        this.gameDeck = gameDeck;
    }

    public Hand getPlayer1Hand() {
        return player1Hand;
    }

    public void setPlayer1Hand(Hand player1Hand) {
        this.player1Hand = player1Hand;
    }

    public Hand getPlayer2Hand() {
        return player2Hand;
    }

    public void setPlayer2Hand(Hand player2Hand) {
        this.player2Hand = player2Hand;
    }

    public int getPlayer1Points() {
        return player1Points;
    }

    public void setPlayer1Points(int player1Points) {
        this.player1Points = player1Points;
    }

    public int getPlayer2Points() {
        return player2Points;
    }

    public void setPlayer2Points(int player2Points) {
        this.player2Points = player2Points;
    }
}
