package company.papai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int myNum = scanner.nextInt();
        scanner.nextLine();

        if (!isMagic(myNum)) {
            System.out.println(myNum + " isn't a Magic number.");
        } else {
            System.out.println(myNum + " is a Magic number.");
        }

        scanner.close();
    }

    private static boolean isMagic(int number) {
        for (int i = number; i > 0 ; i = getSumOfDigits(i)) {
            if (i == 1) {
                return true;
            }
        }

        return false;
    }

    private static int getSumOfDigits(int number) {
        int remainder;
        int sumOfDigits = 0;

        if (number > 1 && number <= 9) {
            return 0;
        } else {
            for (; number > 0; number /= 10) {
                remainder = number % 10;
                sumOfDigits += remainder;
            }

            return sumOfDigits;
        }
    }
}
