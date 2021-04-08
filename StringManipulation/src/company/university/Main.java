package company.university;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordOperations myOperations = new WordOperations();

        boolean quit = false;
        printMenu();
        while (!quit) {
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String myWord = scanner.nextLine();
                    System.out.println("Reverse of " + myWord + " is " + myOperations.reverse(myWord));
                    break;
                case 2:
                    System.out.print("Enter a word: ");
                    String myWord2 = scanner.nextLine();
                    System.out.println("Your word is " + (myOperations.isPalindrome(myWord2) ? "a palindrome." : "not a palindrome."));
                    break;
                case 3:
                    quit = true;
                    System.out.println("Application exited.");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Press\n" +
                           "  0 - Re-print menu\n" +
                           "  1 - Reverse a word\n" +
                           "  2 - Check if your word is a palindrome not\n" +
                           "  3 - Quit");
    }
}