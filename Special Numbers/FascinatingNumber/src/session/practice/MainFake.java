package session.practice;

import java.util.Scanner;

public class MainFake {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to be checked");
        int number = scanner.nextInt();

        System.out.println("Entered number is" + (isFascinating(number) ? " fascinating." : "n't fascinating."));
        scanner.close();
    }

    public static boolean isFascinating(int number) {
        int count = 0;
        String concatenatedValue = ("" + number + number * 2 + number * 3 + 0);

        for (char i = '1'; i <= '9'; i++) {
            for (int j = 0; j < concatenatedValue.length(); j++) {
                if (concatenatedValue.charAt(j) == i) {
                    count++;
                }
            }
        }
        return count == 9;
    }
}