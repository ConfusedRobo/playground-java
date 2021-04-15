package company.rajat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack list = new Stack();

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
                    System.out.print("Enter a number to push: ");
                    data = scanner.nextInt();
                    list.push(data);
                    break;
                case 2:
                    list.pop();
                    break;
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("Stack is not empty.");
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 4:
                    if (list.isEmpty()) {
                        System.out.println("Top element value: " + list.peek());
                    } else {
                        System.out.println("Stack is empty!");
                    }
                    break;
                case 5:
                    list.traverse();
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
                "1 - Push data into stack\n" +
                "2 - Pop data out of stack\n" +
                "3 - Stack status\n" +
                "4 - Current top element value\n" +
                "5 - Traverse stack\n" +
                "6 - Quit");
    }
}
