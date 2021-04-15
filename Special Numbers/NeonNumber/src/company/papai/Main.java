package company.papai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int myNum = scanner.nextInt();
        scanner.nextLine();

        if (!isNeon(myNum)) {
            System.out.println(myNum + " isn't a Neon number.");
        } else {
            System.out.println(myNum + " is a Neon number.");
        }

        scanner.close();
    }

    private static boolean isNeon(int number) {
        int remainder;
        int sumOfDigits = 0;

        for (int numberCpy = (int) Math.pow(number, 2); numberCpy > 0; numberCpy /= 10) {
            remainder = numberCpy % 10;
            sumOfDigits = sumOfDigits + remainder;
        }

        return number == sumOfDigits;
    }
}
