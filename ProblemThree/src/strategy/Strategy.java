package strategy;

public interface Strategy<I, O> {

    /**
     * Execute the strategy based on input
     * @param input input
     * @return output
     */
    O executeStrategy(I input);
}
