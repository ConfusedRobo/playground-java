package sessions.practice;

public class Main {
    // The lock is static -- i.e. there's only one instance of the object so no need
    // to pass the object reference in the constructor
    private static final Object lock = new Object();

    // So, starvation often occurs due to thread priority when we assign a high priority.
    // Priority as to a thread we are suggesting to the operating system that it should try
    // and run the thread before other waiting threads

    // Threads can languish even with when a lock is frequently released
    // Starvation describes a situation where a thread is unable to gain regular access to
    // shared resources and is unable to make progress. This happens when shared resources
    // are made unavailable for long periods by "greedy" threads. For example, suppose an
    // object provides a synchronized method that often takes a long time to return. If one
    // thread invokes this method frequently, other threads that also need frequent
    // synchronized access to the same object or it will often be blocked.
    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        // The priority is only a suggestion to the OS -- it's not actually binding in
        // any way -- we can never force the OS to run threads in a specific order
        // also comment out the setPriority() to and note what it shows as well
        t1.setPriority(Thread.MAX_PRIORITY);     // highest priority
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        // current order: t1 > t2 > t3 > t4 > t5
        // if the order is swapped/changed then you'll often find that the t1 isn't
        // executing first most of the times -- so, execution order actually matters
        // in this case
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static class Worker implements Runnable {
        private int runCount = 1;
        private final String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (lock) {
                    System.out.format(threadColor
                            + "%s: runCount = %d%n", Thread.currentThread().getName(), runCount++);
                    // execute critical section of code
                }
            }
        }
    }
}
