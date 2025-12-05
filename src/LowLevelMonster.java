/**
 * Produces a random low-level monster for flavor text purposes
 */
import java.util.Random;

public class LowLevelMonster {
    private static final String[] monsters = {
        "a goblin",
        "a kobold",
        "a skeleton",
        "a zombie",
        "a mimic",
        "a small slime",
        "a giant rat",
        "a giant spider",
        "a giant scorpion",
        "a regular size wolf",
        "an animated suit of armor",
        "a swarm of bats"
    };
    public static String get() {
        Random rng = new Random();
        int index = rng.nextInt(monsters.length);
        return monsters[index];
    }
}
