import handler.ElfOutcomeBasedGameHandler;
import handler.ElfRockPaperScissorsGameHandler;

import java.io.IOException;

public class ProblemTwoApp {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            //ElfRockPaperScissorsGameHandler handler = new ElfRockPaperScissorsGameHandler();
            ElfOutcomeBasedGameHandler handler = new ElfOutcomeBasedGameHandler();
            int totalScore = handler.handle();

            long timeTaken = System.currentTimeMillis() - startTime;
            long bytesTaken = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.printf("The totalScore: %d\n" +
                            "Runtime: %d ms\n" +
                            "Memory used: %d bytes\n",
                    totalScore,
                    timeTaken,
                    bytesTaken);

        } catch (IOException e) {
            System.out.println("There is some error: " + e);
        }
    }
}