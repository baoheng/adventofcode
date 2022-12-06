package strategy;

import java.util.List;

public class SumUpBasedOnPriorityStrategy implements Strategy<List<Character>, Integer> {

    @Override
    public Integer executeStrategy(List<Character> commonItemType) {
        int sum = 0;
        for (char c : commonItemType) {
            if (c >= 'a' && c <= 'z') {
                sum += (c - 'a') + 1;
            } else {
                sum += (c - 'A') + 27;
            }
        }
        return sum;
    }
}
