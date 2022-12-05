package strategy;

import data.Hand;

public class ElfStrategy implements Strategy {

    @Override
    public int executeStrategy(Hand opponentHand, Hand elfHand) {
        int outcome = elfHand.beat(opponentHand);
        int handScore = elfHand.score();
        switch (outcome) {
            case -1:
                return handScore;
            case 1:
                return handScore + 6;
            default:
                return handScore + 3;
        }
    }
}
