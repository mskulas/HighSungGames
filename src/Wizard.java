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
                        wScore -= 350;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 2:
                        wScore -= 200;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 3:
                        wScore -= 125;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 4:
                        wScore -= 100;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 5:
                        wScore -= 45;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 6:
                        wScore -= 10;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 7:
                        // no score change
                        break;
                    case 8:
                        // no score change
                        break;
                    case 9:
                        wScore += 10;
                        break;
                    case 10:
                        wScore += 25;
                        break;
                    case 11:
                        wScore += 45;
                        break;
                    case 12:
                        wScore += 85;
                        break;
                    case 13:
                        wScore += 100;
                        break;
                    case 14:
                        wScore += 120;
                        break;
                    case 15:
                        wScore += 185;
                        break;
                    case 16:
                        wScore += 230;
                        break;
                    case 17:
                        wScore += 300;
                        break;
                    case 18:
                        wScore += 375;
                        break;
                    case 19:
                        wScore += 500;
                        break;
                    case 20:
                        wScore += 999;
                        break;
                }

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
