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
                        System.out.println("The Thief is ambushed by " + FlavorText.get(FlavorText.lMonsters) + "! -140 points!");
                        tScore -= 140;
                        if (tScore < 0) tScore = 0;
                        break;
                    case 2:
                        System.out.println("The Thief trips " + FlavorText.get(FlavorText.traps) + "! -100 points!");
                        tScore -= 100;
                        if (tScore < 0) tScore = 0;
                        break;
                    case 3:
                        System.out.println("The Thief is spotted by " + FlavorText.get(FlavorText.mMonsters) + "! -50 points!");
                        tScore -= 50;
                        if (tScore < 0) tScore = 0;
                        break;
                    case 4:
                        System.out.println("The Thief loudly fumbles her lockpicks! -10 points!");
                        tScore -= 10;
                        if (tScore < 0) tScore = 0;
                        break;
                    case 5:
                        System.out.println("The Thief sneaks around unnoticed.");
                        break;
                    case 6:
                        System.out.println("The Thief blends into the shadows.");
                        break;
                    case 7:
                        System.out.println("The Thief listens carefully for prying enemies.");
                        break;
                    case 8:
                        System.out.println("The Thief checks for traps ahead.");
                        break;
                    case 9:
                        System.out.println("The Thief scouts the area.");
                        break;
                    case 10:
                        System.out.println("The Thief messes with her dagger.");
                        break;
                    case 11:
                        System.out.println("The Thief does a cool dagger trick! +10 points!");
                        tScore += 10;
                        break;
                    case 12:
                        System.out.println("The Thief avoids " + FlavorText.get(FlavorText.traps) + "! +25 points!");
                        tScore += 25;
                        break;
                    case 13:
                        System.out.println("The Thief disarms " + FlavorText.get(FlavorText.traps) + "! +40 points!");
                        tScore += 40;
                        break;
                    case 14:
                        System.out.println("The Thief finds " + FlavorText.get(FlavorText.lTreasure) + "! +85 points!");
                        tScore += 85;
                        break;
                    case 15:
                        System.out.println("The Thief backstabs " + FlavorText.get(FlavorText.lMonsters) + "! +125 points!");
                        tScore += 125;
                        break;
                    case 16:
                        System.out.println("The Thief uncovers " + FlavorText.get(FlavorText.mTreasure) + "! +200 points!");
                        tScore += 200;
                        break;
                    case 17:
                        System.out.println("The Thief swiftly takes out " + FlavorText.get(FlavorText.mMonsters) + "! +250 points!");
                        tScore += 250;
                        break;
                    case 18:
                        System.out.println("The Thief tricks " + FlavorText.get(FlavorText.mMonsters) + " into tripping " + FlavorText.get(FlavorText.traps) + "! +315 points!");
                        tScore += 315;
                        break;
                    case 19:
                        System.out.println("The Thief loots " + FlavorText.get(FlavorText.lTreasure) + ", " + FlavorText.get(FlavorText.mTreasure) + ", and " + FlavorText.get(FlavorText.hTreasure) + " from " + FlavorText.get(FlavorText.hMonsters) + "! +400 points!");
                        tScore += 400;
                        break;
                    case 20:
                        System.out.println("The Thief uncovers a hidden, priceless relic in the arena! +600 points!");
                        tScore += 600;
                        break;
                }

                System.out.println("The Thief's score: " + tScore);
                if (tScore >= 1000) {
                    if (!GameState.gameOver) {
                        System.out.println("The Thief has secured her victory!");
                        System.out.println("Thief Final Score: " + tScore);
                        GameState.gameOver = true;
                    }
                    break;
                }
                Thread.sleep(rng.nextInt(750, 1000));
            }
        } catch (InterruptedException e) {
            System.out.println("The Thief concedes defeat.");
            System.out.println("Thief Final Score: " + tScore);
        }
    }
}
