package company.rajat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tempZero = 0;
        int tempOne = 1;
        int temp = 1;

        System.out.print("Enter term number: ");
        int term = scanner.nextInt();

        System.out.print("Fibonacci series up to " + term + " are: ");
        for (int i = 1; i <= term; i++) {
            System.out.print(tempZero + ", ");
            tempZero = tempOne;
            tempOne = temp;
            temp = tempOne + tempZero;
        }

        scanner.close();
    }
}
