package src.main.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * In this example we are trying to replicate the scenario where multiple hacker threads will try to unlock the vault by
 * guessing the password of the vault, In the mean time police thread will take its some amount of time to catch the
 * hackers. If hacker threads guess the vault password before police arrives then they will run else police will catch
 * them.
 */
public class PoliceAndHackerThroughThread {

    public static final int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        for (Thread thread : threads) {
            thread.start();
        }
    }


    private static class Vault {
        private int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guess) {
            try {
                Thread.sleep(5);
            } catch (Exception ex) {

            }
            return this.password == guess;
        }
    }

    private static abstract class AbstractHackerThread extends Thread {
        public Vault vault;

        private AbstractHackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void run() {
            System.out.println("Starting thread :: " + this.getName());
            super.run();
        }
    }

    private static class AscendingHackerThread extends AbstractHackerThread {

        private AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int i = 0; i <= MAX_PASSWORD; i++) {
                if (vault.isCorrectPassword(i)) {
                    System.out.println(this.getName() + " guessed the password = " + i);
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHackerThread extends AbstractHackerThread {

        private DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int i = MAX_PASSWORD; i >= 0; i--) {
                if (vault.isCorrectPassword(i)) {
                    System.out.println(this.getName() + " guessed the password = " + i);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {

        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    System.out.println("police " + i + " second away.");
                    Thread.sleep(1000);
                } catch (Exception ex) {

                }
            }
            System.out.println("game over you hackers");
            System.exit(0);
        }
    }
}
