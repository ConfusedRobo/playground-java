package com.rajat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Press");
        System.out.println("  0 - Reprint menu");
        System.out.println("  1 - Prime number check");
        System.out.println("  2 - Perfect number check");
        System.out.println("  3 - Exit");
        while (!quit) {
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            int myNumber;

            switch (choice) {
                case 0:
                    System.out.println("Press");
                    System.out.println("  0 - Reprint menu");
                    System.out.println("  1 - Prime number check");
                    System.out.println("  2 - Perfect number check");
                    System.out.println("  3 - Exit");
                    break;

                case 1:
                    System.out.print("\nEnter a number: ");
                    myNumber = scanner.nextInt();
                    int count = 0;

                    for (int i = 1; i <= myNumber; i++) {
                        if (myNumber % i == 0) {
                            count++;
                        }
                    }

                    if (count > 2) {
                        System.out.println(myNumber + " is not a prime number.");
                    }
                    else {
                        if (count == 1) {
                            System.out.println(myNumber + " is not a prime number.");
                        } else {
                            System.out.println(myNumber + " is a prime number.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("\nEnter a number: ");
                    myNumber = scanner.nextInt();
                    int sumOfDivisors = 0;

                    for (int i = 1; i < myNumber; i++) {
                        if (myNumber % i == 0) {
                            sumOfDivisors = sumOfDivisors + i;
                        }
                    }

                    if (sumOfDivisors == myNumber) {
                        System.out.println(myNumber + " is a perfect number.");
                    } else {
                        System.out.println(myNumber + " is not a perfect number.");
                    }
                    break;

                case 3:
                    quit = true;
                    System.out.println("Application exited!");
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        }
        scanner.close();
    }
}
