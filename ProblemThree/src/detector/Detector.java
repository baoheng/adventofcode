package detector;

public interface Detector<I, O> {

    /**
     * based on input, do detection and return output
     * @param input input
     * @return output O
     */
    O detector(I input);
}
