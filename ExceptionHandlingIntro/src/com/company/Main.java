package com.company;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Value of x: ");
            int x = scanner.nextInt();
            System.out.print("Value of y: ");
            int y = scanner.nextInt();

            System.out.println(x + " divided by " + y + " is " + divide(x, y) + ".");
        } catch (NoSuchElementException | ArithmeticException exception) {
            throw new NoSuchElementException();
        }

        scanner.close();
    }

    private static int divide(int x, int y) {
        return x / y;
    }
}
