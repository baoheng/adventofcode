import handler.SumCommonItemTypeHandler;
import handler.SumCommonItemTypePerGroupOfThreeHandler;

import java.io.IOException;

public class ProblemThree {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            // SumCommonItemTypeHandler handler = new SumCommonItemTypeHandler();
            SumCommonItemTypePerGroupOfThreeHandler handler = new SumCommonItemTypePerGroupOfThreeHandler();
            int prioritiesSum = handler.handle();

            long timeTaken = System.currentTimeMillis() - startTime;
            long bytesTaken = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.printf("The prioritiesSum: %d\n" +
                            "Runtime: %d ms\n" +
                            "Memory used: %d bytes\n",
                    prioritiesSum,
                    timeTaken,
                    bytesTaken);

        } catch (IOException e) {
            System.out.println("There is some error: " + e);
        }
    }
}