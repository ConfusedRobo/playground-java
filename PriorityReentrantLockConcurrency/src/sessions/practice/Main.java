package sessions.practice;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    // now there's no starvation problem -- reason: fairness
    // note that the tryLock method doesn't honor the fairness code
    // fairness can impact performance as extra filtering/management
    // takes place that which thread will go after which
    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        var thread1 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority - 10");
        var thread2 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority - 8");
        var thread3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority - 6");
        var thread4 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority - 4");
        var thread5 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority - 2");

        thread1.setPriority(10);
        thread2.setPriority(8);
        thread3.setPriority(6);
        thread4.setPriority(4);
        thread5.setPriority(2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    private static class Worker implements Runnable {
        private final String color;
        private int count = 0;

        public Worker(String color) {
            this.color = color;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    System.out.format(color
                                    + "%s Thread incremented count to: %d%s%n"
                            , Thread.currentThread().getName()
                            , count++
                            , ThreadColor.ANSI_RESET);
                    // execute critical section of the code
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
