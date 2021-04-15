package company.rajat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter stack element limit: ");
        int maxStackValue = scanner.nextInt();
        CircularQueue list = new CircularQueue(maxStackValue);

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
                    System.out.println(list.toString());
                    break;
                case 5:
                    System.out.println("Queue limit: " + maxStackValue);
                    break;
                case 6:
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
                "1 - En-queue data\n" +
                "2 - De-queue data\n" +
                "3 - Queue status\n" +
                "4 - Traverse queue\n" +
                "5 - Re-view queue limit\n" +
                "6 - Quit");
    }

}