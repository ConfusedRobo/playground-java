package sessions.practice;

public class Main {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    // Note to future me: IllegalMonitorStateException is thrown
    // to indicate that a thread has attempted to wait
    // on an object's monitor or to notify other threads
    // waiting on an object's monitor without owning the
    // specified monitor.

    // Before the modification the locks were obtained in a
    // circular fashion now, it is obtained in a ordered
    // fashion

    // In Outer synchronized block (say)
    // That is, before class A was obtaining lock X and
    // class B was obtaining lock Y simultaneously and now

    // In Inner synchronized block (say)
    // When A's inner synchronized block tries to obtain lock Y
    // then it finds that the lock is not yet released by class B
    // yet. Hence, the thread block -- same is for the class B
    // and they both hold the lock forever and tries to obtain
    // each other's lock forever -- hence, the term "deadlock"
    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignore) {
                }
                System.out.println("Thread 1: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Released lock2");
                }
                System.out.println("Thread 1: Released lock2");
            }
            System.out.println("Thread 1: Released lock1. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2: Has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignore) {
                }
                System.out.println("Thread 1: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 2 has lock1 and lock2");
                }
                System.out.println("Thread 2: Released lock2");
            }
            System.out.println("Thread 2: Released lock1. Exiting...");
        }
    }
}
