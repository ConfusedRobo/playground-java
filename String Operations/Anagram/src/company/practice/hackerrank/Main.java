package company.practice.hackerrank;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String stringA = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String stringB = scanner.nextLine();

        if (!isAnagram(stringA, stringB)) {
            System.out.print("Not Anagrams");
        } else {
            System.out.print("Anagrams");
        }

        scanner.close();
    }

    // also look into Arrays.equals()
    public static boolean isAnagram(String a, String b) {
        char[] sortedA = a.toLowerCase().toCharArray();
        char[] sortedB = b.toLowerCase().toCharArray();

        java.util.Arrays.sort(sortedA);
        java.util.Arrays.sort(sortedB);

        return java.util.Arrays.toString(sortedA)
                .equals(java.util.Arrays.toString(sortedB));
    }
}
