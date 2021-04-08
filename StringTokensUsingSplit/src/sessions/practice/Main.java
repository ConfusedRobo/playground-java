package sessions.practice;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var string = scanner.nextLine();

        var split = java.util.Arrays.stream(string
                .split("[^\\p{Alpha}]+"))
                .filter(stringLam -> !stringLam.isEmpty())
                .toArray();

        out.println(split.length);
        Arrays.asList(split).forEach(out::println);
        scanner.close();
    }
}