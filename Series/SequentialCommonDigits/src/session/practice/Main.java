package session.practice;

import java.util.Scanner;

public class Main {

    /*
     * Create a function that takes two integers
     * and returns true if the number is repeated
     * three times in a row anywhere in num1 and
     * the same number is repeated twice in a row
     * in num2.
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int myA = scanner.nextInt();

        System.out.print("Enter a another: ");
        int myB = scanner.nextInt();

        System.out.println(isRepeated(myA, myB));
        scanner.close();
    }

    public static boolean isRepeated(int a, int b) {
        return duplicateDigit(a) == duplicateDigit(b);
    }

    public static int duplicateDigit(int number) {
        char[] toArray = Integer.toString(number).toCharArray();
        for (int i = 0; i < toArray.length; i++) {
            if (toArray[i] == toArray[i + 1]) {
                return Integer.parseInt(toArray[i] + "");
            }
        }

        return -1;
    }
}
