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
                        System.out.println("The Wizard fumbles a powerful spell! -350 points!");
                        wScore -= 350;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 2:
                        System.out.println("The Wizard is overwhelmed by " + FlavorText.get(FlavorText.hMonsters) + "! -200 points!");
                        wScore -= 200;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 3:
                        System.out.println("The Wizard is caught off guard by " + FlavorText.get(FlavorText.mMonsters) + "! -125 points!");
                        wScore -= 125;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 4:
                        System.out.println("The Wizard stumbles into " + FlavorText.get(FlavorText.traps) + "! -100 points!");
                        wScore -= 100;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 5:
                        System.out.println("The Wizard is tries to blast " + FlavorText.get(FlavorText.lMonsters) + ", but the spell fizzles! -45 points!");
                        wScore -= 45;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 6:
                        System.out.println("The Wizard drops their spellbook! -10 points!");
                        wScore -= 10;
                        if (wScore < 0) wScore = 0;
                        break;
                    case 7:
                        System.out.println("The Wizard meditates to regain focus.");
                        break;
                    case 8:
                        System.out.println("The Wizard prepares their spells.");
                        break;
                    case 9:
                        System.out.println("The Wizard glows brightly, wowing the audience! +10 points!");
                        wScore += 10;
                        break;
                    case 10:
                        System.out.println("The Wizard powers up their arcane aura! +25 points!");
                        wScore += 25;
                        break;
                    case 11:
                        System.out.println("The Wizard blows back " + FlavorText.get(FlavorText.mMonsters) + "! +45 points!");
                        wScore += 45;
                        break;
                    case 12:
                        System.out.println("The Wizard magically disarms " + FlavorText.get(FlavorText.traps) + " successfully! +70 points!");
                        wScore += 85;
                        break;
                    case 13:
                        System.out.println("The Wizard casts " + FlavorText.get(FlavorText.lSpells) + " on " + FlavorText.get(FlavorText.lMonsters) + "! +100 points!");
                        wScore += 100;
                        break;
                    case 14:
                        System.out.println("The Wizard Casts " + FlavorText.get(FlavorText.mSpells) + " on " + FlavorText.get(FlavorText.lMonsters) + "! +120 points!");
                        wScore += 120;
                        break;
                    case 15:
                        System.out.println("The Wizard banishes " + FlavorText.get(FlavorText.mMonsters) + "! +185 points!");
                        wScore += 185;
                        break;
                    case 16:
                        System.out.println("The Wizard casts " + FlavorText.get(FlavorText.mSpells) + " on " + FlavorText.get(FlavorText.mMonsters) + "! +230 points!");
                        wScore += 230;
                        break;
                    case 17:
                        System.out.println("The Wizard casts " + FlavorText.get(FlavorText.mSpells) + " on " + FlavorText.get(FlavorText.hMonsters) + "! +230 points!");
                        wScore += 300;
                        break;
                    case 18:
                        System.out.println("The Wizard casts " + FlavorText.get(FlavorText.hSpells) + "! +375 points!");
                        wScore += 375;
                        break;
                    case 19:
                        System.out.println("The Wizard obliterates a hoarde of monsters with " + FlavorText.get(FlavorText.mSpells) + "! +375 points!");
                        wScore += 500;
                        break;
                    case 20:
                        System.out.println("The Wizard chants a powerful incantation with devastating effect! +999 points!");
                        wScore += 999;
                        break;
                }

                System.out.println("The Wizard's score: " + wScore);
                if (wScore >= 1000) {
                    if (!GameState.gameOver) {
                        System.out.println("The Wizard has secured their victory!");
                        System.out.println("Wizard Final Score: " + wScore);
                        GameState.gameOver = true;
                    }
                    break;
                }
                Thread.sleep(rng.nextInt(1000, 1250));
            }
        } catch (InterruptedException e) {
            System.out.println("The Wizard withdraws, humbled.");
            System.out.println("Wizard Final Score: " + wScore);
        }
    }
}
