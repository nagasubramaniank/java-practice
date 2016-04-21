package com.jsanghvi.algorithms.multithreading;

import java.util.Random;

public class ReadersWriters {
    public static void main(String[] args) {
        Box box = new Box();

        for (int i = 0; i < 4; i++) {
            new Writer(i, box);
            new Reader(i, box);
        }
    }

    private static class Box {
        private final Random random = new Random();
        private int content = 0;
        private int numReaders = 0;

        public void read(final String caller) {
            synchronized (this) {
                numReaders += 1;
                System.out.println(caller + " started reading: " + content);
            }

            // Read the content. Let other readers also read the content together.
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                System.out.println("read() interrupted");
            }

            synchronized (this) {
                System.out.println(caller + " finished reading: " + content);
                numReaders -= 1;
                if (numReaders == 0) {
                    this.notifyAll();
                }
            }
        }

        // Mark the method synchronized, as only one thread should be able to enter it at a given time.
        public synchronized void write(final String caller, final int inContent) {

            // Entering this function does not mean there are no reader threads. They must be reading the data, while
            // still being out of synchronized block.
            while (numReaders > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("write() interrupted");
                }
            }

            // None of the reader threads are reading the content at this point.
            content = inContent;
            System.out.println(caller + " started writing: " + content);

            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                System.out.println("write() interrupted");
            }

            System.out.println(caller + " finished writing: " + content);
            this.notifyAll();
        }
    }

    private static class Reader implements Runnable {
        public final Thread thread;
        private final int index;
        private final Box box;

        public Reader(int index, Box box) {
            this.index = index;
            this.box = box;

            thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run() {
            box.read("Reader " + index);
        }
    }

    private static class Writer implements Runnable {
        public final Thread thread;
        private final int index;
        private final Box box;

        public Writer(int index, Box box) {
            this.index = index;
            this.box = box;

            thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run() {
            box.write("Writer " + index, (index + 1) * 10);
        }
    }
}
