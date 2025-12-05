import java.util.Random;

/**
 * Wizard character thread - races to reach a score of 1000.
 */
public class Wizard extends Thread {
    private int wScore = 0;

    public boolean isDone() {
        return Thread.currentThread().isInterrupted();
    }

    @Override
    public void run() {
        Random rng = new Random();
        try {
            while (!GameState.gameOver && wScore < 1000) {
                int roll = rng.nextInt(1, 20);

                switch (roll) {
                    case 1:
                        // placeholder
                        break;
                    case 2:
                        // placeholder
                        break;
                    case 3:
                        // placeholder
                        break;
                    case 4:
                        // placeholder
                        break;
                    case 5:
                        // placeholder
                        break;
                    case 6:
                        // placeholder
                        break;
                    case 7:
                        // placeholder
                        break;
                    case 8:
                        // placeholder
                        break;
                    case 9:
                        // placeholder
                        break;
                    case 10:
                        // placeholder
                        break;
                    case 11:
                        // placeholder
                        break;
                    case 12:
                        // placeholder
                        break;
                    case 13:
                        // placeholder
                        break;
                    case 14:
                        // placeholder
                        break;
                    case 15:
                        // placeholder
                        break;
                    case 16:
                        // placeholder
                        break;
                    case 17:
                        // placeholder
                        break;
                    case 18:
                        // placeholder
                        break;
                    case 19:
                        // placeholder
                        break;
                    case 20:
                        // placeholder
                        break;
                }

                wScore += roll;
                System.out.println("The Wizard's score: " + wScore);
                if (wScore >= 1000) {
                    if (!GameState.gameOver) {
                        System.out.println("The Wizard has eliminated the Knight!");
                        GameState.gameOver = true;
                    }
                    break;
                }
                Thread.sleep(rng.nextInt(750, 1000));
            }
        } catch (InterruptedException e) {
            System.out.println("Wizard's quest has ended.");
        }
    }
}
