package practice.concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        var buffer = new ArrayBlockingQueue<String>(6);
        var execService = Executors.newFixedThreadPool(3);

        var producer = new Producer(buffer, ThreadColor.ANSI_BLUE);
        var consumer1 = new Consumer(buffer, ThreadColor.ANSI_PURPLE);
        var consumer2 = new Consumer(buffer, ThreadColor.ANSI_RED);

        execService.execute(producer);
        execService.execute(consumer1);
        execService.execute(consumer2);

        var future = execService.submit(() -> "This is a Callable result");
        try {
            System.out.println(future.get());
        } catch (ExecutionException exception) {
            System.out.println("Oops! Something went wrong");
        } catch (InterruptedException exception) {
            System.out.println("Thread running tasks was interrupted");
        }

        execService.shutdown();
    }
}

class Producer implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public Producer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        var random = new Random();
        var numbers = new String[]{"1", "2", "3", "4", "5"};

        for (String number : numbers) {
            try {
                System.out.println(color + "Adding..." + number + ThreadColor.ANSI_RESET);
                buffer.put(number);
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException exception) {
                System.out.println("Production was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting..." + ThreadColor.ANSI_RESET);
        try {
            buffer.put("EOF");
        } catch (InterruptedException exception) {
            System.out.println("Interrupted: Couldn't queue data");
        }
    }
}

class Consumer implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public Consumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) continue;
                    if (buffer.peek().equals(Main.EOF)) {
                        System.out.println(color + "Exiting" + ThreadColor.ANSI_RESET);
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take() + ThreadColor.ANSI_RESET);
                    }
                } catch (InterruptedException ignore) {
                }
            }
        }
    }
}
