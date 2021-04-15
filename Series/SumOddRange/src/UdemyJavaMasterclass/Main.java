package UdemyJavaMasterclass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);

        int startParameter = scannerObject.nextInt();
        int endParameter = scannerObject.nextInt();

        System.out.println(SumOddRange.sumOdd(startParameter, endParameter));

    }

}
