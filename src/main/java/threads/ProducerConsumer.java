package src.main.java.threads;

public class ProducerConsumer {
    public static void main(String[] args) {
        Generator generator = new Generator();
        new Producer(generator);
        new Consumer(generator);
    }
}

class Producer implements Runnable {
    Generator generator;

    public Producer(Generator generator) {
        this.generator = generator;
        Thread producer = new Thread(this, "producer");
        producer.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            generator.put(i++);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
        }
    }
}

class Consumer implements Runnable {

    Generator generator;

    public Consumer(Generator generator) {
        this.generator = generator;
        Thread consumer = new Thread(this, "consumer");
        consumer.start();
    }

    public void run() {
        while (true) {
            generator.get();
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
        }
    }
}

class Generator {

    int num;

    boolean hasValueSet;

    public synchronized void put(int num) {
        while (hasValueSet) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        System.out.println("put = " + num);
        this.num = num;
        hasValueSet = true;
        notify();
    }

    public synchronized void get() {
        while (!hasValueSet) {
            try {
                wait();
            } catch (Exception ex) {

            }
        }
        System.out.println("get = " + num);
        hasValueSet = false;
        notify();
    }
}