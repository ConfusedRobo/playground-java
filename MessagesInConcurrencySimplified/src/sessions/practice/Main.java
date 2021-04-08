package sessions.practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var tester = new Tester();
        new Thread(tester::produce).start();
        new Thread(tester::consume).start();
    }
}

class Tester {
    private boolean exit = false;

    public synchronized void produce() {
        while (!exit) {
            try {
                System.out.println("Yawn~ I'm going to sleep...");
                wait();

                System.out.println("I've been awakened");
            } catch (InterruptedException exception) {
                System.out.println(ThreadColor.ANSI_RED
                        + "Oops! Something went wrong" + ThreadColor.ANSI_RESET);
            }
        }
    }

    public synchronized void consume() {
        while (!exit) {
            System.out.print("Waiting for input: ");
            this.exit = Boolean.parseBoolean(new Scanner(System.in).nextLine());

            System.out.println("All done~");
            notifyAll();
        }
    }
}
