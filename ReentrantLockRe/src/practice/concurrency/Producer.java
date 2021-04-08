package practice.concurrency;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static practice.concurrency.Main.EOF;

public class Producer implements Runnable {
    private final List<Integer> buffer;
    private final String color;
    private final ReentrantLock reentrantLock;

    public Producer(List<Integer> buffer, String color, ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        var numbers = new int[]{1, 2, 3, 4, 5};
        for (var number : numbers) {
            System.out.println(color + "Adding: " + number + ThreadColor.ANSI_RESET);
            reentrantLock.lock();
            try {
                buffer.add(number);
            } finally {
                reentrantLock.unlock();
            }
        }

        System.out.println(color + "Adding EOF and exiting..." + ThreadColor.ANSI_RESET);
        reentrantLock.lock();
        try {
            buffer.add(EOF);
        } finally {
            reentrantLock.unlock();
        }
    }
}
