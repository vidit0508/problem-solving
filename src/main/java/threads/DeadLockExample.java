package src.main.java.threads;

public class DeadLockExample implements Runnable {

    DeadOne deadOne = new DeadOne();
    DeadTwo deadTwo = new DeadTwo();

    public DeadLockExample() {
        Thread thread = new Thread(this);
        thread.start();
        deadOne.deadOne(deadTwo);
    }

    public void run() {
        deadTwo.deadTwo(deadOne);
    }

    public static void main(String[] args) {
        new DeadLockExample();
    }


}

class DeadOne {

    public synchronized void deadOne(DeadTwo deadTwo) {
        System.out.println("Thread one start the execution of deadOne() method.");
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {

        }
        System.out.println("Thread one trying to call the deadTwo.last() method.");
        deadTwo.last();
    }

    public synchronized void last() {
        System.out.println("Inside DeadOne last() method.");
    }
}

class DeadTwo {

    public synchronized void deadTwo(DeadOne deadOne) {
        System.out.println("Thread two start the execution of deadTwo() method.");
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {

        }
        System.out.println("Thread two trying to call the deadOne.last() method.");
        deadOne.last();
    }

    public synchronized void last() {
        System.out.println("Inside DeadTwo last() method.");
    }
}
