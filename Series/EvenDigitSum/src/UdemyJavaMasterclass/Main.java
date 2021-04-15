package UdemyJavaMasterclass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);

        int numberParameter = scannerObject.nextInt();

        System.out.println(EvenDigitSum.getEvenDigitSum(numberParameter));

    }
    
}
