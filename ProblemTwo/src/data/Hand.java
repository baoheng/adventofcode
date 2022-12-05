package data;

public interface Hand {

    /**
     * Check if the current hand beats the incoming hand
     * @param otherHand incoming hand
     * @return true or false
     */
    int beat(Hand otherHand);

    /**
     * Return Score of the current hand
     * @return score in Integer.
     */
    int score();

    /**
     *
     * @return the name of the hand
     */
    String getHandName();
}
