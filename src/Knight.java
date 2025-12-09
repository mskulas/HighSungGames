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
                        System.out.println("The Knight runs and cowers from " + FlavorText.get(FlavorText.lMonsters) + "! -200 points!");
                        kScore -= 200;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 2:
                        System.out.println("The Knight retreats from " + FlavorText.get(FlavorText.mMonsters) + "! -125 points!");
                        kScore -= 125;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 3:
                        System.out.println("The Knight stumbles into " + FlavorText.get(FlavorText.traps) + "! -85 points!");
                        kScore -= 85;
                        if (kScore < 0) kScore = 0;
                        break;
                    case 4:
                        System.out.println("The Knight is ambushed by " + FlavorText.get(FlavorText.mMonsters) + " and " + FlavorText.get(FlavorText.lMonsters) + "! -60 points!");
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
                        System.out.println("The Knight lands a solid strike on " + FlavorText.get(FlavorText.hMonsters) + "! +15 points!");
                        kScore += 15;
                        break;
                    case 12:
                        System.out.println("The Knight resists a " + FlavorText.get(FlavorText.mSpells) + " spell! +50 points!");
                        kScore += 50;
                        break;
                    case 13:
                        System.out.println("The Knight defeats " + FlavorText.get(FlavorText.lMonsters) + "! +75 points!");
                        kScore += 75;
                        break;
                    case 14:
                        System.out.println("The Knight stylishly slays " + FlavorText.get(FlavorText.lMonsters) + "! +100 points!");
                        kScore += 100;
                        break;
                    case 15:
                        System.out.println("The Knight slays " + FlavorText.get(FlavorText.mMonsters) + "! +150 points!");
                        kScore += 150;
                        break;
                    case 16:
                        System.out.println("The Knight crushes " + FlavorText.get(FlavorText.mMonsters) + " and " + FlavorText.get(FlavorText.lMonsters) + "! +215 points!");
                        kScore += 215;
                        break;
                    case 17:
                        System.out.println("The Knight vanquishes " + FlavorText.get(FlavorText.hMonsters) + "! +275 points!");
                        kScore += 275;
                        break;
                    case 18:
                        System.out.println("The Knight charges through a horde of enemies! +325 points!");
                        kScore += 325;
                        break;
                    case 19:
                        System.out.println("The Knight vanquishes " + FlavorText.get(FlavorText.mMonsters) + " and " + FlavorText.get(FlavorText.hMonsters) + " At once! +450 points!");
                        kScore += 450;
                        break;
                    case 20:
                        System.out.println("The Knight slays " + FlavorText.get(FlavorText.hMonsters) + " in one hit! A legendary feat of valor! +800 points!");
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
