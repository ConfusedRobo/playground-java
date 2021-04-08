package company.practice.hackerrank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = scanner.nextLine().toLowerCase();
        String reversedString = "";

        for (int i = string.length() - 1; i > -1; i--) {
            reversedString = reversedString.concat(String.valueOf(string.charAt(i)));
        }

        if (!string.equals(reversedString)) {
            System.out.print("No");
        } else {
            System.out.print("Yes");
        }

        scanner.close();
    }
}
