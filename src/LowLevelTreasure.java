/**
 * Produces some random low-level treasure for flavor text purposes
 */
import java.util.Random;

public class LowLevelTreasure {
    private static final String[] treasure = {
        "some copper",
        "some silver",
        "some gold",
        "a small gem",
        "a small piece of jewelry",
        "a low-level potion",
        "a small talisman",
        "a trinket",
        "a doodad",
        "a small figurine",
        "a platinum piece",
    };
    public static String get() {
        Random rng = new Random();
        int index = rng.nextInt(treasure.length);
        return treasure[index];
    }
}
