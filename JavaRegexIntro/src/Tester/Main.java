package Tester;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputStr = scannerObject.nextLine();

        System.out.print("\nSearch: ");
        String searchStr = scannerObject.nextLine();

        scannerObject.close();

        Pattern patternObj = Pattern.compile(searchStr);
        Matcher matcherObj = patternObj.matcher(inputStr);

        System.out.print("\nMatches found: " + matcherObj.matches());
    }
}
