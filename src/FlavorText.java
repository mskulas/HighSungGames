/**
 * This class represents flavor text associated with various entities in the application.
 * It can be used to store descriptive or thematic text that enhances the user experience.
 */

import java.util.Random;

public class FlavorText {

    public static final String[] lMonsters = {
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

    public static final String[] lSpells = {
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

    public static final String[] lTreasure = {
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

    public static final String[] mMonsters = {
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

    public static final String[] mSpells = {
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

    public static final String[] mTreasure = {
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
    
    public static final String[] hMonsters = {
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

    public static final String[] hSpells = {
        "fireball, blowing up multiple enemies",
        "hypnotic lights, putting all their foes in a trance",
        "control weather, summoning a fierce storm",
        "thousand needles, striking many targets",
        "raise dead, summoning undead minions",
        "domination, putting " + FlavorText.get(mMonsters) + " under their control",
        "meteor swarm, raining destruction from above",
        "zone of darkness, plunging the arena into magical darkness",
        "change gravity, causing the arena to shift dramatically",
        "wild magic, causing chaos in the arena",
        "midas touch, turning " + FlavorText.get(lMonsters) + " into a gold statue",
        "time stop, freezing their enemies in place"
    };

    public static final String[] hTreasure = {
        "a load of copper",
        "a load of silver",
        "a load of gold",
        "a big sack of gems",
        "a priceless tiara",
        "a huge rare gemstone",
        "a ceremonial chalice",
        "a magical artifact",
        "a mummified finger wrapped in paper",
        "an antique painting",
        "a jeweled dagger",
        "a sack of platinum",
        "a real dragon scale"
    };

    public static final String[] traps = {
        "a snaring vine trap",
        "a fire trap",
        "a spike pit trap",
        "an alarm that summons " + FlavorText.get(lMonsters),
        "a dart trap",
        "a trap with a magical rune that casts " + FlavorText.get(lSpells),
        "a trap with a swarm of insects",
        "a snake trap",
        "a lava pit trap",
        "a landmine",
        "an illusion trap",
        "a flashbang"
    };

    public static String get(String[] list) {
        Random rng = new Random();
        int index = rng.nextInt(list.length);
        return list[index];
    }
}
