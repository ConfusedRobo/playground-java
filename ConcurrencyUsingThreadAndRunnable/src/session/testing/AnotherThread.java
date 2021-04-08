package session.testing;

import static session.testing.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

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
        // System.out.println(ANSI_BLUE + "Hello from another thread.");
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {
            System.out.println(ANSI_BLUE + "Another thread woke me up");
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
    }
}
