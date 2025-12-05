/**
 * Produces a random high-level monster for flavor text purposes
 */
import java.util.Random;

public class HighLevelMonster {
    private static final String[] monsters = {
        "a red dragon",
        "a black dragon",
        "a titanium golem",
        "a giant",
        "a hydra",
        "a basilisk",
        "a medusa",
        "a lich",
        "a wyvern",
        "a gelatinous cube",
        "a demon",
        "a serpent"
    };
    public static String get() {
        Random rng = new Random();
        int index = rng.nextInt(monsters.length);
        return monsters[index];
    }
}
