//maths mind tricks
package academy.learnprogramming;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random randomGenarator = new Random();

        int firstNumber = randomGenarator.nextInt(8) +2;
        int secondNumber = randomGenarator.nextInt(8) +2;

        var subtraction = randomGenarator.nextInt(8) +2;
        int answer;
        String prompt = ". Don't type in the answer, just press ENTER when you're ready to continue";

        System.out.println("Think of a number between 1 and 10" + prompt);
        scanner.nextLine();
        System.out.println("Multiply your number by " + firstNumber + prompt);
        scanner.nextLine();
        System.out.println("Now multiply the result by " + secondNumber + prompt);
        scanner.nextLine();
        System.out.println("Divide the number you originally thought of" + prompt);
        scanner.nextLine();
        System.out.println("Now subtract " + subtraction + prompt);
        scanner.nextLine();

        answer = firstNumber * secondNumber - subtraction;
        System.out.println("The answer is " + answer);

        scanner.close();
    }
}
