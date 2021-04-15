package company.test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the array limit: ");
        int limit = scanner.nextInt();
        System.out.println();

        int[] myArray = new int[limit];
        System.out.println("Now, enter its elements:-");
        for (int i = 0; i < limit; i++) {
            System.out.print("Element #" + i + ": ");
            myArray[i] = scanner.nextInt();
        }

        Arrays.sort(myArray);
        System.out.println("Entered array elements: " + Arrays.toString(myArray));
        System.out.println();

        System.out.print("Enter search key: ");
        int myKey = scanner.nextInt();

        LinearSearch search = new LinearSearch(myArray);
        if (!search.isFound(myKey)) {
            System.out.println("No such element exists.");
        } else {
            System.out.println("Entered element " + myKey + " is found at " + search.getFoundAt() + " position.");
        }

        scanner.close();
    }
}