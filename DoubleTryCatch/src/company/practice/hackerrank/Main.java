package company.practice.hackerrank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int varA = scanner.nextInt();
            int varB = scanner.nextInt();

            System.out.print(varA / varB);
        } catch (java.lang.ArithmeticException exception) {
            System.out.print("java.lang.ArithmeticException: / by zero");
        } catch (java.util.InputMismatchException exception) {
            System.out.print("java.util.InputMismatchException");
        }

        scanner.close();
    }
}
