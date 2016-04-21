package com.jsanghvi.algorithms.multithreading;

public class ProducerConsumer {
    public static void main(String[] args) {
        Box box = new Box();
        Producer producer = new Producer(box);
        Consumer consumer = new Consumer(box);

        try {
            producer.thread.join();
            consumer.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    private static class Box {
        private int value;
        private boolean valueSet = false;

        synchronized int get() {
            while (!valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }

            System.out.println("Got: " + value);
            valueSet = false;
            notify();
            return value;
        }

        synchronized void put(int inValue) {
            while (valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }

            value = inValue;
            System.out.println("Put: " + value);
            valueSet = true;
            notify();
        }
    }

    private static class Producer implements Runnable {
        public final Thread thread;
        private final Box box;

        public Producer(Box box) {
            this.box = box;
            thread = new Thread(this, "Producer");
            thread.start();
        }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                box.put(i * 10);
            }
        }
    }

    private static class Consumer implements Runnable {
        public final Thread thread;
        private final Box box;

        public Consumer(Box box) {
            this.box = box;
            thread = new Thread(this, "Consumer");
            thread.start();
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                box.get();
            }
        }
    }
}

