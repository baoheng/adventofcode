package handler;

import data.Hand;
import data.HandMapper;
import data.Paper;
import data.Rock;
import data.Scissors;
import strategy.ElfStrategy;
import strategy.Strategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElfOutcomeBasedGameHandler implements Handler<Integer> {
    private Map<Hand, Hand> rounds;
    private Strategy elfStrategy;

    public ElfOutcomeBasedGameHandler() throws IOException {
        this.elfStrategy = new ElfStrategy();
        List<String> lines = Files.readAllLines(Paths.get("src/input/input.txt"));
        this.rounds = new HashMap<>();
        for (String line : lines) {
            if (line != null && !line.isEmpty()) {
                String[] hands = line.split(" ");
                if ("Y".equals(hands[1])) {
                    this.rounds.put(HandMapper.mapHand(hands[0]), HandMapper.mapHand(hands[0]));
                } else if ("X".equals(hands[1])){
                    switch (hands[0]) {
                        case "A":
                            this.rounds.put(HandMapper.mapHand(hands[0]), new Scissors());
                            break;
                        case "B":
                            this.rounds.put(HandMapper.mapHand(hands[0]), new Rock());
                            break;
                        default:
                            this.rounds.put(HandMapper.mapHand(hands[0]), new Paper());

                    }
                } else {
                    switch (hands[0]) {
                        case "A":
                            this.rounds.put(HandMapper.mapHand(hands[0]), new Paper());
                            break;
                        case "B":
                            this.rounds.put(HandMapper.mapHand(hands[0]), new Scissors());
                            break;
                        default:
                            this.rounds.put(HandMapper.mapHand(hands[0]), new Rock());

                    }
                }
            }
        }
    }

    @Override
    public Integer handle() {
        int totalScore = 0;
        for (Map.Entry<Hand, Hand> entry : rounds.entrySet()) {
            Hand opponentHand = entry.getKey();
            Hand selfHand = entry.getValue();
            int score = elfStrategy.executeStrategy(opponentHand, selfHand);
            totalScore += score;
        }
        return totalScore;
    }
}
