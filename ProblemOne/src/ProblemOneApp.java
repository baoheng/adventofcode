import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;

public class ProblemOneApp {
    public static void main(String[] args) {

        try {
            long startTime = System.currentTimeMillis();
            String content = new String(Files.readAllBytes(Paths.get("src/input.txt")));
            ElfCaloriesNoteParser parser = new ElfCaloriesNoteParser();
            PriorityQueue<ElfBackpack> elfBackpackPriorityQueue = parser.parse(content);

            long timeTaken = System.currentTimeMillis() - startTime;
            long bytesTaken = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.printf("The largest calories: %d\n" +
            "The top 3 largest calories: %d, %d, %d\n" +
                    "Runtime: %d ms\n" +
                            "Memory used: %d bytes\n",
            elfBackpackPriorityQueue.peek().getCalories(),
            elfBackpackPriorityQueue.poll().getCalories(),
            elfBackpackPriorityQueue.poll().getCalories(),
            elfBackpackPriorityQueue.poll().getCalories(),
            timeTaken,
            bytesTaken);

        } catch (IOException e) {
            System.out.println("There is some error: " + e);
        }
    }
}