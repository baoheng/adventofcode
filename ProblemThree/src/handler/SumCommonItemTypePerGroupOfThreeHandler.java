package handler;

import detector.CommonItemTypeByGroupDetector;
import strategy.SumUpBasedOnPriorityStrategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SumCommonItemTypePerGroupOfThreeHandler implements Handler<Integer> {

    private CommonItemTypeByGroupDetector detector;
    private SumUpBasedOnPriorityStrategy strategy;
    List<List<String>> rucksacksPerGroupOfThree;

    public SumCommonItemTypePerGroupOfThreeHandler() throws IOException {
        this.detector = new CommonItemTypeByGroupDetector();
        this.strategy = new SumUpBasedOnPriorityStrategy();
        this.rucksacksPerGroupOfThree = new ArrayList<>();
        List<String> rucksacks = Files.readAllLines(Paths.get("src/input/input.txt"));
        int tracker = 1;
        List<String> tempTracker = new ArrayList<>();
        for (String rucksack : rucksacks) {
            tempTracker.add(rucksack);
            if (tracker >= 3) {
                this.rucksacksPerGroupOfThree.add(tempTracker);
                tempTracker = new ArrayList<>();
                tracker = 1;
            } else {
                tracker++;
            }
        }
        if (!tempTracker.isEmpty()) {
            this.rucksacksPerGroupOfThree.add(tempTracker);
        }
    }

    @Override
    public Integer handle() {
        int sum = 0;
        for (List<String> rucksacks : rucksacksPerGroupOfThree) {
            List<Character> commonTypes = detector.detector(rucksacks);
            sum += strategy.executeStrategy(commonTypes);
        }
        return sum;
    }
}
