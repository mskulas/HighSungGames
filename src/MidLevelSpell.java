/**
 * Produces a random mid-level spell for flavor text purposes
 */
import java.util.Random;

public class MidLevelSpell {
    private static final String[] spells = {
        "lightning bolt",
        "explosive rune",
        "ice storm",
        "sleep mist",
        "blood curse",
        "binding chains",
        "seal monster",
        "wall of darkness",
        "crushing boulder",
        "crystal shard",
        "psychic scream",
        "metal spike"
    };
    public static String get() {
        Random rng = new Random();
        int index = rng.nextInt(spells.length);
        return spells[index];
    }
}
