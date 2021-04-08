package practice.hackerrank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(camelcase(string));
        scanner.close();
    }

    public static int camelcase(String /*word*/ s) {
//        int count = 0;
//        if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') { ++count; }
//
//        for (char letter : word.toCharArray()) {
//            if (letter >= 'A' && letter < 'Z') { ++count; }
//        }
//
//        return count;

        return s.length() - s.replaceAll("[A-Z]", "").length() + 1;
    }
}