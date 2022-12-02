import java.util.PriorityQueue;

/**
 * A Simple parser to return a list of ElfBackpack in ascending order
 */
public class ElfCaloriesNoteParser implements Parser<String, PriorityQueue<ElfBackpack>> {

    private static final String DELIMITER = "\n";
    @Override
    public PriorityQueue<ElfBackpack> parse(String inputString) {
        String[] caloriesLine = inputString.split(DELIMITER);
        PriorityQueue<ElfBackpack> result = new PriorityQueue<>();
        int calories = 0;
        for (String line : caloriesLine) {
            if (line != null) {
                if (line.isEmpty() && calories > 0) {
                    ElfBackpack elfBackpack = new ElfBackpack(calories);
                    result.add(elfBackpack);
                    calories = 0;
                } else {
                    calories += Integer.parseInt(line);
                }
            }
        }
        return result;
    }
}
