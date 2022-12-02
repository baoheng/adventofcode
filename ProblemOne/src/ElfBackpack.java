/**
 * Data representation of  Elf backpack
 */
public class ElfBackpack implements Comparable<ElfBackpack> {

    private int calories;

    public int getCalories() {
        return calories;
    }

    public ElfBackpack(int calories) {
        this.calories = calories;
    }

    @Override
    public int compareTo(ElfBackpack other) {
        return other.getCalories() - getCalories();
    }
}
