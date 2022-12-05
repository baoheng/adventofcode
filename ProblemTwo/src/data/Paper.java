package data;

import static data.Constants.PAPER;
import static data.Constants.ROCK;
import static data.Constants.SCISSORS;

public class Paper implements Hand {
    @Override
    public int beat(Hand otherHand) {
        switch (otherHand.getHandName()) {
            case SCISSORS:
                return -1;
            case ROCK:
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public int score() {
        return 2;
    }

    @Override
    public String getHandName() {
        return PAPER;
    }
}
