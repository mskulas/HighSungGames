/**
 * Produces some random high-level treasure for flavor text purposes
 */
import java.util.Random;

public class HighLevelTreasure {
    private static final String[] treasure = {
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
    public static String get() {
        Random rng = new Random();
        int index = rng.nextInt(treasure.length);
        return treasure[index];
    }
}
