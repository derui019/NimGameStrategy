// Peter de Ruiter
// CSCI 1913
// Project 2
// Tournament

/**
 * This is a runnable class that runs 9 match-ups of games of uno war specfied to us and calulates the
 * win rate of each AI
 */
public class Tournament {
    /**
     * This function runs all possible games and outputs the names of the games as specifed in the
     * instructions and returns the win rate of the specified AI.
     * @param args
     */
    public static void main(String[] args){
        AI rand = new AI();
        AI small = new SmallestCardAI();
        AI big = new BiggestCardAI();
        UnoWarMatch game1 = new UnoWarMatch(rand, rand); //Creates new game with specified Ai's
        System.out.println(rand + " vs. " + rand + " winRate: " + game1.winRate(10000));
        UnoWarMatch game2 = new UnoWarMatch(rand, small); //Creates new game with specified Ai's
        System.out.println(rand + " vs. " + small + " winRate: " + game2.winRate(10000));
        UnoWarMatch game3 = new UnoWarMatch(rand, big); //Creates new game with specified Ai's
        System.out.println(rand + " vs. " + big + " winRate: " + game3.winRate(10000));
        UnoWarMatch game4 = new UnoWarMatch(small, rand); //Creates new game with specified Ai's
        System.out.println(small + " vs. " + rand + " winRate: " + game4.winRate(10000));
        UnoWarMatch game5 = new UnoWarMatch(small, small); //Creates new game with specified Ai's
        System.out.println(small + " vs. " + small + " winRate: " + game5.winRate(10000));
        UnoWarMatch game6 = new UnoWarMatch(small, big); //Creates new game with specified Ai's
        System.out.println(small + " vs. " + big + " winRate: " + game6.winRate(10000));
        UnoWarMatch game7 = new UnoWarMatch(big, rand); //Creates new game with specified Ai's
        System.out.println(big + " vs. " + rand + " winRate: " + game7.winRate(10000));
        UnoWarMatch game8 = new UnoWarMatch(big, small); //Creates new game with specified Ai's
        System.out.println(big + " vs. " + small + " winRate: " + game8.winRate(10000));
        UnoWarMatch game9 = new UnoWarMatch(big, big); //Creates new game with specified Ai's
        System.out.println(big + " vs. " + big + " winRate: " + game9.winRate(10000));
    }
}
