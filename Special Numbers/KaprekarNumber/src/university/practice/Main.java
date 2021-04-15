package university.practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (!isKaprekar(number)) {
            System.out.println(number + " isn't a Kaprekar number.");
        } else {
            System.out.println(number + " is a Kaprekar number.");
        }
        scanner.close();
    }

    public static boolean isKaprekar(int number) {
        char[] array = ((Integer) (number * number)).toString().toCharArray();

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i < array.length/2) {
                left.append(array[i]);
            } else {
                right.append(array[i]);
            }
        }

        int leftPlusRight = Integer.parseInt(left.toString())
                + Integer.parseInt(right.toString());
        return leftPlusRight == number;
    }
}