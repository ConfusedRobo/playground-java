package company.papai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int myNum = scanner.nextInt();
        scanner.nextLine();

        if (isPrime(myNum) && isPrime(myNum + 2) || isPrime(myNum - 2)) {
            System.out.println(myNum + " is a Twin-Prime number.");
        } else {
            System.out.println(myNum + " isn't a Twin-Prime number.");
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
}
