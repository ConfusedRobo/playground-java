package com.rajat;

import java.util.Scanner;

public class Main {

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your range(inclusive):- ");
        System.out.print("\tStarting: ");
        int start = scanner.nextInt();
        System.out.print("\tEnding: ");
        int end = scanner.nextInt();

        if (start > end) {
            System.out.println("\nInvalid range!");
        } else {
            if (start < 0) {
                System.out.println("\nEntered range not allowed! Enter positive integers as range.");
            } else {
                System.out.println("\nPrime numbers from " + start + " to " + end + " are as follows:- ");
                for (int i = start; i <= end; i++) {
                    if (isPrime(i)) {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
