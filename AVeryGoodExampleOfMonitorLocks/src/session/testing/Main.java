package session.testing;

public class Main {
    private int count = 0;
    //private static final Integer monitor = 1;

    public static void main(String[] args) {
        Main main = new Main();
        main.doWork();
        main.doWork();
        main.doWork();
        main.doWork();
        main.doWork();
        main.doWork();
        main.doWork();
    }

    public void increment() {
        synchronized (/*monitor*/Object.class) {
            count++;
        }
    }

    public void doWork() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException exception) {
            System.out.println("Message: " + exception.getMessage());
        }

        System.out.println(count);
        count = 0;
    }
}