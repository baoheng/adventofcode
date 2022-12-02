/**
 * This is a Parser interface to parse input
 */
public interface Parser<I, O> {

    /**
     * Parse the input and return specific output
     * @param input input
     * @return specific output
     */
    O parse(I input);
}
