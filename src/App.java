/**
 * Main application - orchestrates the race between Knight, Thief, and Wizard.
 */
public class App {
    public static void main(String[] args) {
        Knight knight = new Knight();
        Thief thief = new Thief();
        Wizard wizard = new Wizard();

        System.out.println("The Knight, the Thief, and the Wizard enter the arena... Let the games begin!");

        knight.start();
        thief.start();
        wizard.start();

        // Wait until a thread sets gameOver. Sleep briefly in the loop to avoid busy-waiting.
        while (!GameState.gameOver) {
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
