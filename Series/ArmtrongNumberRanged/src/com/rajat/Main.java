package com.rajat;

import java.util.Scanner;

public class Main {

    private static boolean isArmstrong(int number) {
        if (number < 0) {
            return false;
        } else {
            int remainder;
            int sumOfCubeOfDigits = 0;
            int numberCopy = number;

            for (; numberCopy > 0; numberCopy = numberCopy / 10) {
                remainder = numberCopy % 10;
                sumOfCubeOfDigits = sumOfCubeOfDigits + (int) Math.pow(remainder, 3);
            }

            return sumOfCubeOfDigits == number;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the range(inclusive):-");
        System.out.print("\tStarting: ");
        int start = scanner.nextInt();
        System.out.print("\tEnding: ");
        int end = scanner.nextInt();

        if (start > end) {
            System.out.println("\nInvalid range!");
        } else {
            if (start < 0) {
                System.out.println("\nEntered range is not allowed! Positive integers are required.");
            } else {
                System.out.println("\nList of armstrong numbers from " + start + " to " + end + " are:-");

                for (int i = start; i <= end; i++) {
                    if (isArmstrong(i)) {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
