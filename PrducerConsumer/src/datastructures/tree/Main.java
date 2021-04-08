package datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static datastructures.tree.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        
        Producer producer = new Producer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        Consumer consumer1 = new Consumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        Consumer consumer2 = new Consumer(buffer, ThreadColor.ANSI_RED, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class Producer implements Runnable {
    private final List<String> buffer;
    private final String color;
    ReentrantLock bufferLock;

    public Producer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] numbers = {"1", "2", "3", "4", "5"};

        for (String number : numbers) {
            try {
                System.out.println(color + "Adding..." + number + ThreadColor.ANSI_RESET);
                bufferLock.lock();
                try {
                    buffer.add(number);
                } finally {
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException exception) {
                System.out.println("Production was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting..." + ThreadColor.ANSI_RESET);
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class Consumer implements Runnable {
    private final List<String> buffer;
    private final String color;
    ReentrantLock bufferLock;

    public Consumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        int counter = 0;

        while (true) {
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(ThreadColor.ANSI_GREEN + "The counter = " + counter + ThreadColor.ANSI_RESET);
                    counter = 0;

                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting" + ThreadColor.ANSI_RESET);
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0) + ThreadColor.ANSI_RESET);
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                ++counter;
            }
        }
    }
}