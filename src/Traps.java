/**
 * Produces a random trap for flavor text purposes
 */
import java.util.Random;

public class Traps {
    private static final String[] traps = {
        "a snaring vine trap",
        "a fire trap",
        "a spike pit trap",
        "a switch, summoning " + LowLevelMonster.get(),
        "a dart trap",
        "a trap with a magical rune that casts " + LowLevelSpell.get(),
        "a trap with a swarm of insects",
        "a snake trap",
        "a lava pit trap",
        "a landmine",
        "an illusion trap",
        "a flashbang"
    };
    public static String get() {
        Random rng = new Random();
        int index = rng.nextInt(traps.length);
        return traps[index];
    }
}
