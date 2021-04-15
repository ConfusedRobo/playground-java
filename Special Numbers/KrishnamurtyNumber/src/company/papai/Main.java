package company.papai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int myNum = scanner.nextInt();
        scanner.nextLine();

        if (!isKrishnamurty(myNum)) {
            System.out.println(myNum + " isn't a Krishnamurty number.");
        } else {
            System.out.println(myNum + " is a Krishnamurty number.");
        }

        scanner.close();
    }

    private static boolean isKrishnamurty(int number) {
        int remainder;
        int sumOfFactorialOfDigits = 0;

        for (int numberCpy = number; numberCpy > 0; numberCpy /= 10) {
            remainder = numberCpy % 10;
            sumOfFactorialOfDigits = sumOfFactorialOfDigits + getFactorial(remainder);
        }

        return number == sumOfFactorialOfDigits;
    }

    private static int getFactorial(int number) {
        int factorialNum = 1;

        for (int i = 1; i <= number; i++) {
            factorialNum = factorialNum * i;
        }

        return factorialNum;
    }
}
