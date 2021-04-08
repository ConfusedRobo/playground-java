package Tester;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);

        System.out.print("String input: ");
        String parameterWord = scannerObject.nextLine();

        System.out.print("\nString reverse: " + wordReverse(parameterWord));

    }

    public static String wordReverse(String word) {

        StringBuilder readWord = new StringBuilder();

        for (int i = word.length() - 1;i > -1;i--) {

            char temp = word.charAt(i);
            readWord.append(temp);

        }

        return readWord.toString();

    }

}
