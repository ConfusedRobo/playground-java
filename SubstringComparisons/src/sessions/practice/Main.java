package sessions.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        out.print("Enter a string: ");
        var string = scanner.nextLine();
        out.print("Enter the key value: ");
        var key = scanner.nextInt();

        out.printf("Smallest Largest | %s", getSmallestAndLargest(string, key));
        scanner.close();
    }

    public static String getSmallestAndLargest(String string, int subLen) {
        var list = new ArrayList<String>();
        for (var current = 0; current < string.length(); current++) try {
            list.add(string.substring(current, current + subLen));
        } catch (StringIndexOutOfBoundsException exception) {
            break;
        }

        Collections.sort(list);
        return list.get(0) + " " + list.get(list.size() - 1);
    }
}
