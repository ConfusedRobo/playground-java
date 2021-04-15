package com.rajat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int myNumber = scanner.nextInt();
        int myNumberCopy = myNumber;
        int remainder;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (myNumberCopy > 0) {
            remainder = myNumberCopy % 10;

            if (max < remainder) {
                max = remainder;
            }

            if (min > remainder) {
                min = remainder;
            }
            myNumberCopy = myNumberCopy / 10;
        }
        System.out.println(myNumber + "'s greatest digit is " + max + " and it's smallest digit is " + min + ".");
        scanner.close();
    }
}
