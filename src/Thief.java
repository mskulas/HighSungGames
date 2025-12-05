import java.util.Random;

/**
 * Thief character thread - races to reach a score of 1000.
 */
public class Thief extends Thread {
    private int tScore = 0;

    public boolean isDone() {
        return Thread.currentThread().isInterrupted();
    }

    @Override
    public void run() {
        Random rng = new Random();
        try {
            while (!GameState.gameOver && tScore < 1000) {
                int roll = rng.nextInt(1, 20);

                switch (roll) {
                    case 1:
                        tScore -= 140;
                        if (tScore < 0) tScore = 0;
                        break;
                    case 2:
                        tScore -= 100;
                        if (tScore < 0) tScore = 0;
                        break;
                    case 3:
                        tScore -= 50;
                        if (tScore < 0) tScore = 0;
                        break;
                    case 4:
                        tScore -= 10;
                        if (tScore < 0) tScore = 0;
                        break;
                    case 5:
                        // no score change
                        break;
                    case 6:
                        // no score change
                        break;
                    case 7:
                        // no score change
                        break;
                    case 8:
                        // no score change
                        break;
                    case 9:
                        // no score change
                        break;
                    case 10:
                        // no score change
                        break;
                    case 11:
                        tScore += 10;
                        break;
                    case 12:
                        tScore += 25;
                        break;
                    case 13:
                        tScore += 40;
                        break;
                    case 14:
                        tScore += 85;
                        break;
                    case 15:
                        tScore += 125;
                        break;
                    case 16:
                        tScore += 200;
                        break;
                    case 17:
                        tScore += 250;
                        break;
                    case 18:
                        tScore += 315;
                        break;
                    case 19:
                        tScore += 400;
                        break;
                    case 20:
                        tScore += 600;
                        break;
                }

                System.out.println("The Thief's score: " + tScore);
                if (tScore >= 1000) {
                    if (!GameState.gameOver) {
                        System.out.println("The Thief has secured his plunder!");
                        GameState.gameOver = true;
                    }
                    break;
                }
                Thread.sleep(rng.nextInt(500, 750));
            }
        } catch (InterruptedException e) {
            System.out.println("Thief's quest has ended.");
        }
    }
}
