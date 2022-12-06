package handler;

import detector.CommonItemTypeByGroupDetector;
import strategy.SumUpBasedOnPriorityStrategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SumCommonItemTypeHandler implements Handler<Integer> {

    private CommonItemTypeByGroupDetector detector;
    private SumUpBasedOnPriorityStrategy strategy;
    List<String> rucksacks;

    public SumCommonItemTypeHandler() throws IOException {
        this.detector = new CommonItemTypeByGroupDetector();
        this.strategy = new SumUpBasedOnPriorityStrategy();
        this.rucksacks = Files.readAllLines(Paths.get("src/input/input.txt"));
    }

    @Override
    public Integer handle() {
       int sum = 0;
       for (String rucksack : rucksacks) {
            List<String> partitions = new ArrayList<>();
            partitions.add(rucksack.substring(0, rucksack.length() / 2));
            partitions.add(rucksack.substring(rucksack.length() / 2));
            List<Character> commonTypes = detector.detector(partitions);
            sum += strategy.executeStrategy(commonTypes);
       }
       return sum;
    }
}
