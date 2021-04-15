package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter a number : ");
        var scanner = new Scanner(System.in);
        var userInput = scanner.nextInt();

        if (isArmstrong(userInput)) System.out.printf("%d is an Armstrong number!", userInput);
        else System.out.printf("%d is not an Armstrong number!", userInput);
        scanner.close();
    }

    public static boolean isArmstrong(int number) {
        int sumOfDigitCube = 0;
        int remainder;
        int temp;

        temp = number;
        for (; temp != 0; temp /= 10) {
            remainder = temp % 10;
            sumOfDigitCube += Math.pow(remainder, 3);
        }

        return number == sumOfDigitCube;
    }
}
