package company.university;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculateArea proxy = new CalculateArea();
        double valueA;
        double valueB;

        boolean quit = false;
        printMenu();
        while (!quit) {
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Application exited.");
                    break;
                case 1:
                    printMenu();
                    break;
                case 2:
                    System.out.print("Enter length value: ");
                    valueA = scanner.nextDouble();
                    System.out.print("Enter breath value: ");
                    valueB = scanner.nextDouble();

                    System.out.println("\nArea: " + proxy.getRectangleArea(valueA, valueB));
                    break;
                case 3:
                    System.out.print("Enter base value: ");
                    valueA = scanner.nextDouble();
                    System.out.print("Enter height value: ");
                    valueB = scanner.nextDouble();

                    System.out.println("\nArea: " + proxy.getTriangleArea(valueA, valueB));
                    break;
                case 4:
                    System.out.print("Enter sideA value: ");
                    valueA = scanner.nextDouble();
                    System.out.print("Enter sideB value: ");
                    valueB = scanner.nextDouble();

                    System.out.println("\nArea: " + proxy.getSquareArea(valueA, valueB));
                    break;
                case 5:
                    System.out.print("Enter radius value: ");
                    valueA = scanner.nextDouble();

                    System.out.println("\nArea: " + proxy.getCircleArea(valueA));
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
                           "  2 - Rectangle\n" +
                           "  3 - Triangle\n" +
                           "  4 - Square\n" +
                           "  5 - Circle");
    }
}