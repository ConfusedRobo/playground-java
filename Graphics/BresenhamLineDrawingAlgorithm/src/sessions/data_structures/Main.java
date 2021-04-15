package sessions.data_structures;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        out.print("Enter x1 = ");
        var x1 = scanner.nextInt();
        out.print("Enter y1 = ");
        var y1 = scanner.nextInt();

        out.print("Enter x2 = ");
        var x2 = scanner.nextInt();
        out.print("Enter y2 = ");
        var y2 = scanner.nextInt();

        var delX = x2 - x1;
        var delY = y2 - y1;

        var pk = 2 * delY - delX;
        out.println("(" + x1 + "," + y1 + ") == Exclusive");
        do {
            if (pk < 0) pk += 2 * delY;
            else {
                pk += 2 * delY - 2 * delX;
                y1++;
            }
            out.format("(%s,%s)%n", ++x1, y1);
        } while (x1 != x2 || y1 != y2);
        scanner.close();
    }
}
