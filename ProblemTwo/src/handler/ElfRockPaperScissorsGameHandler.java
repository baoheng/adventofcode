package handler;

import data.Hand;
import data.HandMapper;
import strategy.ElfStrategy;
import strategy.Strategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElfRockPaperScissorsGameHandler implements Handler<Integer> {
    private Map<Hand, Hand> rounds;
    private Strategy elfStrategy;

    public ElfRockPaperScissorsGameHandler () throws IOException {
        this.elfStrategy = new ElfStrategy();
        List<String> lines = Files.readAllLines(Paths.get("src/input/input.txt"));
        this.rounds = new HashMap<>();
        for (String line : lines) {
            if (line != null && !line.isEmpty()) {
                String[] hands = line.split(" ");
                this.rounds.put(HandMapper.mapHand(hands[0]), HandMapper.mapHand(hands[1]));
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
