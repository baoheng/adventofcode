package strategy;

import data.Hand;

public interface Strategy {

    /**
     * Execute Strate for the two hands
     *
     * @param opponentHand
     * @param elfHand
     * @return Scores of the strategy
     */
    public int executeStrategy(Hand opponentHand, Hand elfHand);
}
