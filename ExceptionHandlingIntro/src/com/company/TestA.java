package com.company;

import java.util.Scanner;

public class TestA {

    public static void main(String[] args) {
        exceptionsTest();
    }

    private static void exceptionsTest() throws ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        System.out.println(i);
        scanner.close();
    }
}
