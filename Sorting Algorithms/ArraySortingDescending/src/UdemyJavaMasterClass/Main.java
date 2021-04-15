package UdemyJavaMasterClass;

import java.util.Scanner;

public class Main {

    private static Scanner scannerObject = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter array limit: ");
        int arrayLimit = scannerObject.nextInt();

        System.out.println();

        System.out.println("Enter array elements: ");
        int[] inputArray = getIntegers(arrayLimit);
        int[] sortedArray = sortIntegers(inputArray);

        System.out.println();

        System.out.println("Sorted array to descending order: ");
        printArray(sortedArray);

    }

    private static int[] getIntegers(int number) {

        int[] arrayVar = new int[number];

        for (int arrayCounter = 0; arrayCounter < arrayVar.length; arrayCounter++)
            arrayVar[arrayCounter] = scannerObject.nextInt();

        return arrayVar;

    }

    private static int[] sortIntegers(int[] numbers) {

        for (int arrayCounterA = 0; arrayCounterA < numbers.length; arrayCounterA++) {

            int temp;

            for (int arrayCounterB = arrayCounterA + 1; arrayCounterB < numbers.length; arrayCounterB++)
                if (numbers[arrayCounterA] < numbers[arrayCounterB]) {

                    temp = numbers[arrayCounterA];
                    numbers[arrayCounterA] = numbers[arrayCounterB];
                    numbers[arrayCounterB] = temp;

                }


        }

        return numbers;

    }

    private static void printArray(int[] numbers) {

        for (int arrayCounter = 0; arrayCounter < numbers.length; arrayCounter++)
            System.out.println(numbers[arrayCounter]);

    }

}
