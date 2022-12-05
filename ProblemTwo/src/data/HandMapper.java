package data;

public final class HandMapper {
    private HandMapper() {}

    public static Hand mapHand(String stringHand) {
        if ("A".equals(stringHand.trim()) || "X".equals(stringHand.trim())) {
            return new Rock();
        } else if ("B".equals(stringHand.trim()) || "Y".equals(stringHand.trim())) {
            return new Paper();
        } else {
            return new Scissors();
        }
    }
}
