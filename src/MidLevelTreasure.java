/**
 * Produces some random mid-level treasure for flavor text purposes
 */
import java.util.Random;

public class MidLevelTreasure {
    private static final String[] treasure = {
        "a sack of copper",
        "a sack of silver",
        "a sack of gold",
        "some gems",
        "a fancy piece of jewelry",
        "a quality potion",
        "some expensive ale",
        "a gold talisman",
        "a decorative knife",
        "a really good doodad",
        "a painting",
        "an old book",
        "some platinum"
    };
    public static String get() {
        Random rng = new Random();
        int index = rng.nextInt(treasure.length);
        return treasure[index];
    }
}
