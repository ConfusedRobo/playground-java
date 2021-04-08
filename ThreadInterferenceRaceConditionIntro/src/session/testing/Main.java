package session.testing;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");
        //CountdownThread t3 = new CountdownThread(countdown);
        //t3.setName("Thread 3");

        t1.start();
        t2.start();
        //t3.start();
    }
}

class Countdown {

    private int i;

    public void doCountdown() {
        String color;

        // color encoding for better readability and illustration
        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        for (/*int*/ i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            //try {
            //    Thread.sleep(1000);
            //} catch (InterruptedException exception) {
            //    System.out.println("Error occurred!");
            //}
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