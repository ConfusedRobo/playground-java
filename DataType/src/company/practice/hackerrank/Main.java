package company.practice.hackerrank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        try {
            long x = sc.nextLong();
            System.out.println(x + " can be fitted in:");

            if (x <= Byte.MAX_VALUE && x >= Byte.MIN_VALUE) {
                System.out.println("* byte");
            }

            if (x <= Short.MAX_VALUE && x >= Short.MIN_VALUE) {
                System.out.println("* short");
            }

            if (x <= Integer.MAX_VALUE && x >= Integer.MIN_VALUE) {
                System.out.println("* int");
            }

            System.out.print("* long");
            System.out.println();
        } catch (Exception exception) {
            System.out.println(sc.next() + " can't be fitted anywhere.");
        }

        sc.close();
    }
}
