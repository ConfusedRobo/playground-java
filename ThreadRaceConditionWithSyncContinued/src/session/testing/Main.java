package session.testing;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class Countdown {
    private String scanner = "Dummy";
    // private Scanner scanner = new Scanner(System.in);
    // private Integer i = 10;
    private int i;

    public /*synchronized*/ void doCountdown() {
        String color;
        // Scanner scanner = new Scanner(System.in);
        String currentThread = Thread.currentThread().getName();

        // color encoding for better readability and illustration
        switch (currentThread) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        // synced with scanner
        synchronized (scanner) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + currentThread + ": i = " + i + ThreadColor.ANSI_RESET);
            }
        }
    }
}

class CountdownThread extends Thread {
    private final Countdown threadCountdown;    // a Countdown class object

    // initializing the value of threadCountdown variable via constructor
    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    @Override
    public void run() {
        threadCountdown.doCountdown();
    }
}