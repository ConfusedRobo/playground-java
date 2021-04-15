package company.rajat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int myNum = scanner.nextInt();

        if (!triFibonacci(myNum)) {
            System.out.println(myNum + " is not a term of the tri-fibonacci series.");
        } else {
            System.out.println(myNum + " found at " + getTerm(myNum) + " position of the tri-fibonacci series.");
        }

        scanner.close();
    }

    private static boolean triFibonacci(int number) {
        int []temp = new int[4];
        temp[0] = 0;
        temp[1] = 0;
        temp[2] = 1;
        temp[3] = 1;

        for (int i = 1; i <= number; i++) {
            temp[0] = temp[1];
            temp[1] = temp[2];
            temp[2] = temp[3];
            temp[3] = temp[0] + temp[1] + temp[2];

            if (temp[0] == number) {
                return true;
            }
        }

        return false;
    }

    private static int getTerm(int number) {
        int []temp = new int[4];
        temp[0] = 0;
        temp[1] = 0;
        temp[2] = 1;
        temp[3] = 1;

        for (int i = 1; i <= number; i++) {
            temp[0] = temp[1];
            temp[1] = temp[2];
            temp[2] = temp[3];
            temp[3] = temp[0] + temp[1] + temp[2];

            if (temp[0] == number) {
                return i + 1;
            }
        }

        return -1;
    }
}
