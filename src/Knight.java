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
                        System.out.println("The Knight runs and cowers from " + LowLevelMonster.get() + "! -200 points!");
                        kScore -= 200;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 2:
                        System.out.println("The Knight retreats from " + MidLevelMonster.get() + "! -125 points!");
                        kScore -= 125;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 3:
                        System.out.println("The Knight stumbles into " + Traps.get() + "! -85 points!");
                        kScore -= 85;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 4:
                        System.out.println("The Knight is ambushed by " + MidLevelMonster.get() + " and " + LowLevelMonster.get() + "! -60 points!");
                        kScore -= 60;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 5:
                        System.out.println("The Knight fumbles with his sword! -10 points!");
                        kScore -= 10;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 6:
                        System.out.println("The Knight stands around.");
                        break;
                    case 7:
                        System.out.println("The Knight pauses to sharpen his sword.");
                        break;
                    case 8:
                        System.out.println("The Knight prays for guidance.");
                        break;
                    case 9:
                        System.out.println("The Knight surveys the battlefield.");
                        break;
                    case 10:
                        System.out.println("The Knight pumps up the crowd! +10 points!");
                        kScore += 10;
                        break;
                    case 11:
                        System.out.println("The Knight lands a solid strike on " + HighLevelMonster.get() + "! +15 points!");
                        kScore += 15;
                        break;
                    case 12:
                        System.out.println("The Knight resists a " + MidLevelSpell.get() + " spell! +50 points!");
                        kScore += 50;
                        break;
                    case 13:
                        System.out.println("The Knight defeats " + LowLevelMonster.get() + "! +75 points!");
                        kScore += 75;
                        break;
                    case 14:
                        System.out.println("The Knight stylishly slays " + LowLevelMonster.get() + "! +100 points!");
                        kScore += 100;
                        break;
                    case 15:
                        System.out.println("The Knight slays " + MidLevelMonster.get() + "! +150 points!");
                        kScore += 150;
                        break;
                    case 16:
                        System.out.println("The Knight crushes " + MidLevelMonster.get() + " and " + LowLevelMonster.get() + "! +215 points!");
                        kScore += 215;
                        break;
                    case 17:
                        System.out.println("The Knight vanquishes " + HighLevelMonster.get() + "! +275 points!");
                        kScore += 275;
                        break;
                    case 18:
                        System.out.println("The Knight charges through a horde of enemies! +325 points!");
                        kScore += 325;
                        break;
                    case 19:
                        System.out.println("The Knight vanquishes " + MidLevelMonster.get() + " and " + HighLevelMonster.get() + " At once! +450 points!");
                        kScore += 450;
                        break;
                    case 20:
                        System.out.println("The Knight slays " + HighLevelMonster.get() + " in one hit! A legendary feat of valor! +800 points!");
                        kScore += 800;
                        break;
                }

                System.out.println("The Knight's score: " + kScore);
                // if we reached the goal, set the global flag and break
                if (kScore >= 1000) {
                    if (!GameState.gameOver) {
                        System.out.println("The Knight has earned his victory!");
                        System.out.println("Knight Final Score: " + kScore);
                        
                        GameState.gameOver = true;
                    }
                    break;
                }
                Thread.sleep(rng.nextInt(750, 1250));
            }
        } catch (InterruptedException e) {
            System.out.println("The Knight resigns, bested.");
            System.out.println("Knight Final Score: " + kScore);
        }
    }
}
