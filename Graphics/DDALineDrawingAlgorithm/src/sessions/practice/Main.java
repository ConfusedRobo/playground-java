package sessions.practice;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        out.print("x1 = ");
        var x1 = scanner.nextInt() + 0.0;
        out.print("y1 = ");
        var y1 = scanner.nextInt() + 0.0;

        out.print("x2 = ");
        var x2 = scanner.nextInt();
        out.print("y2 = ");
        var y2 = scanner.nextInt();

        var delX = x2 - x1;
        var delY = y2 - y1;
        var steps = Double.max(delX, delY);
        out.println("delX = " + delX + " | delY = " + delY);
        out.println("Step: " + steps);

        var xINC = delX / steps + 0.0;
        var yINC = delY / steps + 0.0;
        out.println("xINC = " + xINC + " | yINC = " + yINC);

        out.format("Start: (%s, %s)%n", (int) x1, (int) y1);
        for (int i = 0; i < steps; i++) {
            x1 = x1 + xINC;
            y1 = y1 + yINC;

            if (i == steps - 1) out.format("End: (%.1f, %.1f) | (%s, %s)%n",
                    x1, y1,
                    Math.round(x1), Math.round(y1));
            else out.format("Next: (%.1f, %.1f) | (%s, %s)%n",
                    x1, y1,
                    Math.round(Double.parseDouble(String.format("%.1f", x1))),
                    Math.round(Double.parseDouble(String.format("%.1f", y1))));
        }
        scanner.close();
    }
}
