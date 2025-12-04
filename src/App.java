import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class App {
    // volatile so changes are visible across threads immediately
    public static volatile boolean gameOver = false;
    
    public class Knight extends Thread {
        // Knight's score - must be 1000 to win
        int kScore = 0;
        public boolean isDone() {
            return Thread.currentThread().isInterrupted();
        }
        public void run() {
            System.out.println("Knight is on a quest to catch the thief!");
            Random rng = new Random();
            try {
                while (!gameOver && kScore < 1000) {
                    int roll = rng.nextInt(1, 20);
                    System.out.println("Knight rolls a rng and gets: " + roll);
                    kScore += roll;
                    System.out.println("The Knight is " + kScore + "% of the way to catching the Thief.");
                    // if we reached the goal, set the global flag and break
                    if (kScore >= 1000) {
                        if (!gameOver) {
                            System.out.println("The Knight has caught the Thief!");
                            gameOver = true;
                        }
                        break;
                    }
                    Thread.sleep(rng.nextInt(500, 1000));
                }
            }
            catch (InterruptedException e) {
                System.out.println("Knight's quest has ended.");
            }
        }
    }
    public class Thief extends Thread {
        int tScore = 0;
        public boolean isDone() {
            return Thread.currentThread().isInterrupted();
        }
        public void run() {
            System.out.println("Thief is on a quest to steal from the Wizard!");
            Random rng = new Random();
            try {
                while (!gameOver && tScore < 1000) {
                    int roll = rng.nextInt(1, 20);
                    System.out.println("Thief rolls a rng and gets: " + roll);
                    tScore += roll;
                    System.out.println("The Thief is " + tScore + "% of the way to robbing the Wizard.");
                    if (tScore >= 1000) {
                        if (!gameOver) {
                            System.out.println("The Thief has secured his plunder!");
                            gameOver = true;
                        }
                        break;
                    }
                    Thread.sleep(rng.nextInt(500, 1000));
                }
            }
            catch (InterruptedException e) {
                System.out.println("Thief's quest has ended.");
            }
        }
    }
    public class Wizard extends Thread {
        int wScore = 0;
        public boolean isDone() {
            return Thread.currentThread().isInterrupted();
        }
        public void run() {
            System.out.println("Wizard is on a quest to vanquish the Knight!");
            Random rng = new Random();
            try {
                while (!gameOver && wScore < 1000) {
                    int roll = rng.nextInt(1, 20);
                    System.out.println("Wizard rolls a rng and gets: " + roll);
                    wScore += roll;
                    System.out.println("The Wizard is " + wScore + "% of the way to vanquishing the Knight.");
                    if (wScore >= 1000) {
                        if (!gameOver) {
                            System.out.println("The Wizard has eliminated the Knight!");
                            gameOver = true;
                        }
                        break;
                    }
                    Thread.sleep(rng.nextInt(500, 1000));
                }
            }
            catch (InterruptedException e) {
                System.out.println("Wizard's quest has ended.");
            }
        }
    }
    public static void main(String[] args) {
        Knight knight = new App().new Knight();
        Thief thief = new App().new Thief();
        Wizard wizard = new App().new Wizard();

        knight.start();
        thief.start();
        wizard.start();

        // Wait until a thread sets gameOver. Sleep briefly in the loop to avoid busy-waiting.
        while (!gameOver) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // ignore and re-check
            }
        }

        // interrupt other threads so they wake from sleep and exit promptly
        knight.interrupt();
        thief.interrupt();
        wizard.interrupt();

        // wait for threads to finish before exiting
        try {
            knight.join();
            thief.join();
            wizard.join();
        } catch (InterruptedException e) {
            // if main is interrupted, just exit
        }
    }
}
