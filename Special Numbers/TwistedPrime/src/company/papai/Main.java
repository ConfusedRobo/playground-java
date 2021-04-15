package company.papai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int myNum = scanner.nextInt();
        scanner.nextLine();

        if (isPrime(myNum) && isPrime(getReverse(myNum))) {
            System.out.println(myNum + " is a Twisted-Prime number.");
        } else {
            System.out.println(myNum + " isn't a Twisted-Prime number.");
        }

        scanner.close();
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }

            return count < 3;
        }
    }

    private static int getReverse(int number) {
        int remainder;
        int revOfDigits = 0;

        for (int numberCopy = number; numberCopy > 0; numberCopy /= 10) {
            remainder = numberCopy % 10;
            revOfDigits = revOfDigits * 10 + remainder;
        }

        return revOfDigits;
    }
}
