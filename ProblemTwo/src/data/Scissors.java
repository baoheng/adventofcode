package data;

import static data.Constants.PAPER;
import static data.Constants.ROCK;
import static data.Constants.SCISSORS;

public class Scissors implements Hand {

    @Override
    public int beat(Hand otherHand) {
        switch (otherHand.getHandName()) {
            case ROCK:
                return -1;
            case PAPER:
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public int score() {
        return 3;
    }

    @Override
    public String getHandName() {
        return SCISSORS;
    }
}
