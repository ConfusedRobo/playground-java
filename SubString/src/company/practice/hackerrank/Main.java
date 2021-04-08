package company.practice.hackerrank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        System.out.print("\nEnter starting point: ");
        int start = scanner.nextInt();

        System.out.print("Enter ending point: ");
        int end = scanner.nextInt();

        System.out.println("Substring from " + start + " to " + end + " is: " + string.substring(start, end));
    }
}
