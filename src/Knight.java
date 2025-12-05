import java.util.Random;

/**
 * Knight character thread - races to reach a score of 1000.
 */
public class Knight extends Thread {
    private int kScore = 0;

    public boolean isDone() {
        return Thread.currentThread().isInterrupted();
    }

    @Override
    public void run() {
        Random rng = new Random();
        try {
            while (!GameState.gameOver && kScore < 1000) {
                int roll = rng.nextInt(1, 20);

                switch (roll) {
                    case 1:
                        System.out.println("The Knight runs and cowers from " + LowLevelMonster.get() + "!");
                        kScore -= 200;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 2:
                        kScore -= 125;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 3:
                        kScore -= 85;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 4:
                        kScore -= 60;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 5:
                        kScore -= 10;
                        if (kScore < 0) kScore = 0;
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
                        kScore += 10;
                        break;
                    case 11:
                        kScore += 15;
                        break;
                    case 12:
                        kScore += 50;
                        break;
                    case 13:
                        kScore += 75;
                        break;
                    case 14:
                        kScore += 100;
                        break;
                    case 15:
                        kScore += 150;
                        break;
                    case 16:
                        kScore += 215;
                        break;
                    case 17:
                        kScore += 275;
                        break;
                    case 18:
                        kScore += 325;
                        break;
                    case 19:
                        kScore += 450;
                        break;
                    case 20:
                        kScore += 800;
                        break;
                }

                System.out.println("The Knight's score: " + kScore);
                // if we reached the goal, set the global flag and break
                if (kScore >= 1000) {
                    if (!GameState.gameOver) {
                        System.out.println("The Knight has caught the Thief!");
                        GameState.gameOver = true;
                    }
                    break;
                }
                Thread.sleep(rng.nextInt(500, 1000));
            }
        } catch (InterruptedException e) {
            System.out.println("Knight's quest has ended.");
        }
    }
}
