package UdemyJavaMasterclass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);

        int inputSum = 0;

        for (int i = 1; i < 11; ++i) {

            System.out.println("Enter " + i + "th number: ");
            if (scannerObject.hasNextInt())
                inputSum += scannerObject.nextInt();
            else
                System.out.println("Invalid Number!");

            scannerObject.nextLine();

        }

            System.out.println("Input sum: " + inputSum);

        scannerObject.close();

    }

}
