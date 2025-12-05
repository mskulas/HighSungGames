/**
 * Produces a random high-level spell for flavor text purposes
 */
import java.util.Random;

public class HighLevelSpell {
    private static final String[] spells = {
        "fireball, blowing up multiple enemies",
        "hypnotic lights, putting all their foes in a trance",
        "control weather, summoning a fierce storm",
        "thousand needles, striking many targets",
        "raise dead, summoning undead minions",
        "domination, putting " + MidLevelMonster.get() + " under their control",
        "meteor swarm, raining destruction from above",
        "zone of darkness, plunging the arena into magical darkness",
        "change gravity, causing the arena to shift dramatically",
        "wild magic, causing chaos in the arena",
        "midas touch, turning " + LowLevelMonster.get() + " into a gold statue",
        "time stop, freezing their enemies in place"
    };
    public static String get() {
        Random rng = new Random();
        int index = rng.nextInt(spells.length);
        return spells[index];
    }
}
