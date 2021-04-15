package company.rajat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();

        boolean quit = false;
        printMenu();
        while (!quit) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    System.out.print("Enter data value: ");
                    choice = scanner.nextInt();
                    list.push(choice);
                    break;
                case 2:
                    if (list.isEmpty()) {
                        System.out.println("List is empty.");
                    } else {
                        System.out.println("List isn't empty.");
                    }
                    break;
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("Couldn't traverse. Reason: List is empty.");
                    } else {
                        System.out.println(list.toString());
                    }
                    break;
                case 4:
                    System.out.println("Application exited.");
                    quit = true;
                    break;
                case 5:
                    list.pop();
                    break;
                case 6:
                    System.out.print("Enter data value: ");
                    choice = scanner.nextInt();
                    list.append(choice);
                    break;
                case 7:
                    list.removeFromLast();
                    break;
                case 8:
                    list.next();
                    break;
                case 9:
                    list.previous();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Press\n" +
                "  0 - Re-print menu\n" +
                "  1 - Push into list\n" +
                "  2 - List status\n" +
                "  3 - Traverse list\n" +
                "  4 - Quit\n" +
                "  5 - Pop from list\n" +
                "  6 - Append list\n" +
                "  7 - Remove a node from last\n" +
                "  8 - Make next node head\n" +
                "  9 - Make previous node head\n");
    }
}
