package practice.bubble_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter the array length: ");
            int length = Integer.parseInt(reader.readLine());   // array length
            var array = new int[length];    // array to be sorted


            // populating array
            for (int i = 0; i < length; i++) {
                System.out.print("Element " + i + ": ");
                array[i] = Integer.parseInt(reader.readLine());
            }

            System.out.print("True - asc | False - des: ");
            String ascending = reader.readLine();

            if (ascending.equalsIgnoreCase("true")
                    || ascending.equalsIgnoreCase("false")) {
                BubbleSort bubbleSort = new BubbleSort(array);
                boolean descending = Boolean.parseBoolean(ascending.toLowerCase(Locale.ENGLISH));

                // prints the sorted array - using naive approach
                System.out.print("\u001B[34m");
                System.out.println("Sorted array[NAIVE]: "
                        + Arrays.toString(bubbleSort.sortV1(descending)));
                System.out.println("Sorted array[HONEST]: "
                        + Arrays.toString(bubbleSort.sortV2(descending)));
                System.out.println("Sorted array[HONEST - OP]: "
                        + Arrays.toString(bubbleSort.sortV3(descending)));
            } else {
                System.out.println("\u001B[31m" + "Invalid choice, Try again!");
            }

            System.out.print("\u001B[0m");
        } catch (Exception exception) {
            throw new InputMismatchException("Invalid format");
        }
    }
}
