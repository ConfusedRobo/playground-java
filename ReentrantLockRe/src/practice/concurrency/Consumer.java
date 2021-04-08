package practice.concurrency;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static practice.concurrency.Main.EOF;

public class Consumer implements Runnable {
    private final List<Integer> buffer;
    private final String color;
    private final ReentrantLock reentrantLock;

    public Consumer(List<Integer> buffer, final String color, ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        while (true) {
            if (reentrantLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) continue;
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting..." + ThreadColor.ANSI_RESET);
                        break;
                    } else {
                        System.out.println(color + "Removed: " + buffer.remove(0) + ThreadColor.ANSI_RESET);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }
}
