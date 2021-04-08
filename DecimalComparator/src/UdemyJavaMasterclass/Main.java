package UdemyJavaMasterclass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);

        double decimalParameterA = scannerObject.nextDouble();
        double decimalParameterB = scannerObject.nextDouble();

        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(decimalParameterA, decimalParameterB));

    }

}
