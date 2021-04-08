package UdemyJavaMasterclass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);

        int parameterA = scannerObject.nextInt();
        int parameterB = scannerObject.nextInt();
        int parameterC = scannerObject.nextInt();

        IntEqualityPrinter.printEqual(parameterA, parameterB, parameterC);

    }

}
