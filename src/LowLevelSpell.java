/**
 * Produces a random low-level spell for flavor text purposes
 */
import java.util.Random;

public class LowLevelSpell {
    private static final String[] spells = {
        "acid splash",
        "firebolt",
        "dazzling lights",
        "poison spray",
        "thunderclap",
        "freeze",
        "electric spark",
        "force blast",
        "fear",
        "slashing blades",
        "magic missile",
        "bug swarm"
    };
    public static String get() {
        Random rng = new Random();
        int index = rng.nextInt(spells.length);
        return spells[index];
    }
}
