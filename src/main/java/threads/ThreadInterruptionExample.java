package src.main.java.threads;

import src.main.java.topicwise.dp.ClimbingStairs;

import java.math.BigInteger;

/**
 * In this example we will cover below scenarios of thread interruption
 * 1. When the main thread is done by doing its job but child thread get blocked so we will interrupt the child thread.
 * 2. When the main thread is done by doing its job and child thread is stuck in some long computation
 * then we will interrupt the child thread to stop.
 * 2.1. Even after doing longComputationThread.interrupt(), the child thread will not stop as there is no handling of
 * the interrupt. So, to handle this, we will add the condition to check whether the child thread is interrupted or not
 * IF YES it is interrupted then we will stop the child thread execution as it has the implementation of the interrupt.
 * 3. In this way we can interrupt the thread even if the class implementing Runnable do not handle the interruption by
 * setting the daemon property = true at the time of creating the thread.
 */
public class ThreadInterruptionExample {

    public static void main(String[] args) {
        // example of point 1.
        // in below two lines child thread will start working but takes longer time ever after finishing the task
//        Thread blockingTask = new Thread(new BlockingTask());
//        blockingTask.start();

        // now we will interrupt the thread to stop
//        blockingTask.interrupt();

        // example of point 2.
        Thread longComputationThread =
                new Thread(new LongComputation(new BigInteger("200000"), new BigInteger("1000000")));

        // use the setDaemon when you want to interrupt the thread when the main thread has completed its task.
        // longComputationThread.setDaemon(true);
        longComputationThread.start();

        longComputationThread.interrupt();
    }

    private static class BlockingTask implements Runnable {

        /**
         * Runs this operation.
         */
        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException iex) {
                System.out.println("Exiting blocking thread.");
            }
        }
    }

    private static class LongComputation implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComputation(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        /**
         * Runs this operation.
         */
        @Override
        public void run() {
            System.out.println(base + " ^ " + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger pow) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(pow) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("prematurely interrupted thread.");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }
}
