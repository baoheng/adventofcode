package data;

import static data.Constants.PAPER;
import static data.Constants.ROCK;
import static data.Constants.SCISSORS;

public class Rock implements Hand{

    @Override
    public int beat(Hand otherHand) {
        switch (otherHand.getHandName()) {
            case PAPER:
                return -1;
            case SCISSORS:
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public int score() {
        return 1;
    }

    @Override
    public String getHandName() {
        return ROCK;
    }
}
