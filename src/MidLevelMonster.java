/**
 * Produces a random mid-level monster for flavor text purposes
 */
import java.util.Random;

public class MidLevelMonster {
    private static final String[] monsters = {
        "a hobgoblin",
        "a displacer beast",
        "a phantom",
        "a flesh golem",
        "a stone golem",
        "a mound of black ooze",
        "a vampire spawn",
        "a rust monster",
        "an elemental",
        "a dire wolf",
        "an orc",
        "an enemy fighter"
    };
    public static String get() {
        Random rng = new Random();
        int index = rng.nextInt(monsters.length);
        return monsters[index];
    }
}
