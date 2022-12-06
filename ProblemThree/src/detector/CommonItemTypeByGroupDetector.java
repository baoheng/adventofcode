package detector;

import java.util.ArrayList;
import java.util.List;

public class CommonItemTypeByGroupDetector implements Detector<List<String>, List<Character>> {

    @Override
    public List<Character> detector(List<String> input) {
        int[] rucksack = new int[52];
        for (String s : input) {
            char[] alphabets = s.toCharArray();
            markCommonType(alphabets, rucksack);
        }

        List<Character> result = new ArrayList<>();
        for (int i = 0; i < rucksack.length; i++) {
            if (rucksack[i] == input.size()) {
                if (i < 26) {
                    result.add((char) (i + 'a'));
                } else {
                    result.add((char) ((i - 26) + 'A'));
                }
            }
        }
        return result;
    }

    private void markCommonType(char[] alphabets, int[] rucksack) {
        int[] tempRucksack = new int[52];
        for (char c : alphabets) {
            int index = getIndex(c);
            if (tempRucksack[index] <= 0) {
                tempRucksack[index]++;
                rucksack[index]++;
            }
        }
    }

    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return c - 'A' +  26;
        }
    }
}
