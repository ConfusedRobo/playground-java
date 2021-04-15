package company.rajat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueLinked list = new QueueLinked();

        boolean quit = false;
        printMenu();
        while (!quit) {
            System.out.print("\nEnter choice: ");
            int choice = scanner.nextInt();
            int data;

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    System.out.print("Enter a number to en-queue: ");
                    data = scanner.nextInt();
                    list.enQueue(data);
                    break;
                case 2:
                    list.deQueue();
                    break;
                case 3:
                    if (!list.isEmpty()) {
                        System.out.println("Queue is not empty.");
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 4:
                    if (list.getFront() == null) {
                        System.out.println("Couldn't get front data. Reason: Front node is null.");
                    } else {
                        System.out.println("Front element of the queue is: " + list.getFront().data);
                    }
                    break;
                case 5:
                    if (list.getRear() == null) {
                        System.out.println("Couldn't get rearmost data. Reason: Rear node is null.");
                    } else {
                        System.out.println("Rearmost element of the queue is: " + list.getRear().data);
                    }
                    break;
                case 6:
                    System.out.println(list.toString());
                    break;
                case 7:
                    System.out.println("Application exited!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Press\n" +
                "0 - Reprint menu\n" +
                "1 - Insert data into queue\n" +
                "2 - Delete data out of queue\n" +
                "3 - Queue status\n" +
                "4 - View queue's front element\n" +
                "5 - View queue's rearmost element\n" +
                "6 - Traverse queue\n" +
                "7 - Quit");
    }
}
