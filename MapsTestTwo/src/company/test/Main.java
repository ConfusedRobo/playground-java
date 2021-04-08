package company.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter site name: ");
        String siteName = scanner.nextLine().toLowerCase();
        System.out.println("Site created.");
        System.out.println();

        AnimeSite site = new AnimeSite(siteName);
        System.out.println("Welcome to " + siteName + ".com");

        boolean quit = false;
        printMenu();
        while (!quit) {
            String key;
            String value;

            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Site exited.");
                    break;
                case 1:
                    printMenu();
                    break;
                case 2:
                    System.out.print("Enter the anime's name: ");
                    key = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Enter it's tags: ");
                    value = scanner.nextLine();

                    site.addAnime(key, value);
                    break;
                case 3:
                    if (!site.getAnimes().isEmpty()) {
                        System.out.print("Enter the anime's name: ");
                        key = scanner.nextLine();
                        scanner.nextLine();

                        site.removeAnime(key);
                    } else {
                        System.out.println("Unable to perform operation. List is empty.");
                    }
                    break;
                case 4:
                    if (!site.getAnimes().isEmpty()) {
                        System.out.print("Enter the tag name: ");
                        value = scanner.nextLine();
                        scanner.nextLine();

                        site.removeByTag(value);
                    } else {
                        System.out.println("Unable to perform operation. List is empty.");
                    }
                    break;
                case 5:
                    if (!site.getAnimes().isEmpty()) {
                        site.traverse();
                    } else {
                        System.out.println("Unable to perform operation. List is empty.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Press\n" +
                           "  0 - Quit\n" +
                           "  1 - Re-print menu\n" +
                           "  2 - Add an anime\n" +
                           "  3 - Remove an anime\n" +
                           "  4 - Remove anime by tag\n" +
                           "  5 - Traverse map");
    }
}