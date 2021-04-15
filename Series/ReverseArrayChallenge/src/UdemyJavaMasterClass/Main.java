package UdemyJavaMasterClass;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);

        System.out.print("Enter array limit: ");
        int arrayLt = scannerObject.nextInt();

        System.out.println();

        int[] arrayInput = new int[arrayLt];
        System.out.println("Enter array elements: ");
        for (int arrayCounter = 0; arrayCounter < arrayInput.length; arrayCounter++) {

            System.out.print("arrayInput[" + arrayCounter + "]: ");
            arrayInput[arrayCounter] = scannerObject.nextInt();

        }

        System.out.println();

        reverse(arrayInput);

        scannerObject.close();

    }

    private static void reverse(int[] array) {

        int[] reversedArray = new int[array.length];
        int arrayCounter = array.length - 1;
        int arrayCounterRev = 0;

        while (true) {

            if (arrayCounter > -1)
                reversedArray[arrayCounterRev++] = array[arrayCounter--];

            else
                break;

        }

        System.out.println("Entered array: " + Arrays.toString(array));
        System.out.println("Reversed array: " + Arrays.toString(reversedArray));

    }

}
