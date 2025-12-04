import java.util.Random;

public class App {
    public class Knight extends Thread {
        int kScore = 0;
        public Wizard wizard;
        public void setWizard(Wizard wiz) {
            this.wizard = wiz;
        }
        public void setback (int amount) {
            kScore -= amount;
            if (kScore < 0) kScore = 0;
        }
        public boolean isDone() {
            return Thread.currentThread().isInterrupted();
        }
        public void run() {
            System.out.println("Knight is on a quest to catch the thief!");
            Random d20 = new Random();
            try {
                while (kScore < 100) {
                    int roll = d20.nextInt(1, 20);
                    System.out.println("Knight rolls a d20 and gets: " + roll);
                    Thread.sleep(500);
                    kScore += roll;
                    System.out.println("The Knight is " + kScore + "% of the way to catching the Thief.");
                    wizard.setback(roll / 2);
                    Thread.sleep(500);
                }
                System.out.println("The Knight has caught the Thief!");
                this.interrupt();
            }
            catch (InterruptedException e) {
                System.out.println("Knight's quest has ended.");
            }
        }
    }
    public class Thief extends Thread {
        int tScore = 0;
        public Knight knight;
        public void setKnight(Knight kni) {
            this.knight = kni;
        }
        public void setback (int amount) {
            tScore -= amount;
            if (tScore < 0) tScore = 0;
        }
        public boolean isDone() {
            return Thread.currentThread().isInterrupted();
        }
        public void run() {
            System.out.println("Thief is on a quest to steal from the Wizard!");
            Random d20 = new Random();
            try {
                while (tScore < 100) {
                    int roll = d20.nextInt(1, 20);
                    System.out.println("Thief rolls a d20 and gets: " + roll);
                    Thread.sleep(500);
                    tScore += roll;
                    System.out.println("The Thief is " + tScore + "% of the way to robbing the Wizard.");
                    knight.setback(roll / 2);
                    Thread.sleep(500);
                }
                System.out.println("The Thief has secured his plunder!");
                this.interrupt();
            }
            catch (InterruptedException e) {
                System.out.println("Thief's quest has ended.");
            }
        }
    }
    public class Wizard extends Thread {
        int wScore = 0;
        public Thief thief;
        public void setThief(Thief thi) {
            this.thief = thi;
        }
        public void setback (int amount) {
            wScore -= amount;
            if (wScore < 0) wScore = 0;
        }
        public boolean isDone() {
            return Thread.currentThread().isInterrupted();
        }
        public void run() {
            System.out.println("Wizard is on a quest to vaniquish the Knight!");
            Random d20 = new Random();
            try {
                while (wScore < 100) {
                    int roll = d20.nextInt(1, 20);
                    System.out.println("Wizard rolls a d20 and gets: " + roll);
                    Thread.sleep(500);
                    wScore += roll;
                    System.out.println("The Wizard is " + wScore + "% of the way to vanquishing the Knight.");
                    thief.setback(roll / 2);
                    Thread.sleep(500);
                }
                System.out.println("The Wizard has eliminated the Knight!");
                this.interrupt();
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
        knight.setWizard(wizard);
        thief.setKnight(knight);
        wizard.setThief(thief);

        knight.start();
        thief.start();
        wizard.start();

        try {
            knight.join();
            thief.join();
            wizard.join();
            if (knight.isDone() || thief.isDone() || wizard.isDone()) {
                knight.interrupt();
                thief.interrupt();
                wizard.interrupt();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
}
