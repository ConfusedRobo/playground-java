package session.testing;

import static session.testing.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();
        // anotherThread.run();    // running on the main thread

            new Thread() {
            /**
             * If this thread was constructed using a separate
             * {@code Runnable} run object, then that
             * {@code Runnable} object's {@code run} method is called;
             * otherwise, this method does nothing and returns.
             * <p>
             * Subclasses of {@code Thread} should override this method.
             *
             * @see #start()
             */
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        // Thread myRunnableThread = new Thread(new MyRunnable());
        Thread myRunnableThread = new Thread(new MyRunnable()) {
            /**
             * If this thread was constructed using a separate
             * {@code Runnable} run object, then that
             * {@code Runnable} object's {@code run} method is called;
             * otherwise, this method does nothing and returns.
             * <p>
             * Subclasses of {@code Thread} should override this method.
             *
             * @see #start()
             */
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");

                try {
                    // anotherThread.join();
                    // System.out.println(ANSI_RED + "AnotherThread terminated, so I'm running again");
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "AnotherThread terminated, or timed out, so I'm running again");
                } catch (InterruptedException exception) {
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted.");
                }
            }
        };
        myRunnableThread.start();
        // System.out.println(anotherThread.isInterrupted());
        // anotherThread.interrupt();
        // System.out.println(anotherThread.isInterrupted());
        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");
        Runnable runnable = () -> System.out.println(ANSI_CYAN + "Testing with the runnable interface. " +
                "That is, passing it to Thread." + ANSI_RESET);
        Thread runnableThread = new Thread(runnable, "Runnable thread - 2");
        runnableThread.start();
    }
}