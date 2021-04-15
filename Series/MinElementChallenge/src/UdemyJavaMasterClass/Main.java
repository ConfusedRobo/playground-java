package UdemyJavaMasterClass;

import java.util.Scanner;

public class Main {

    private static Scanner scannerObject = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Array limit: ");
        int arrayLim = scannerObject.nextInt();

        System.out.println();

        System.out.println("Enter array values: ");
        int[] mainArray = readIntegers(arrayLim);

        System.out.println();

        System.out.println("Minimum array element: ");
        System.out.println(findMin(mainArray));

    }

    private static int[] readIntegers(int count) {

        int[] array = new int[count];

        for (int arrayCounter = 0; arrayCounter < count; arrayCounter++)
            array[arrayCounter] = scannerObject.nextInt();

        return array;

    }

    private static int findMin(int[] array) {

        int minValue = Integer.MAX_VALUE;

        for (int arrayCounter = array.length - 1; arrayCounter >= 0; arrayCounter--)
            if (array[arrayCounter] < minValue)
                minValue = array[arrayCounter];

        return minValue;

    }

}
