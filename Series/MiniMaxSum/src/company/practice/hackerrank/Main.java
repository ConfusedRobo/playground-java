package company.practice.hackerrank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] test;

        System.out.print("Enter the array's limit: ");
        int limit = scanner.nextInt();
        test = new int[limit];

        System.out.println("Enter array elements:-");
        for (int i = 0; i < test.length; i++) {
            System.out.print("Element " + i + " value: ");
            test[i] = scanner.nextInt();
        }

        miniMaxSum(test);
        scanner.close();
    }

    public static void miniMaxSum(int[] arr) {
        int maxItem = Integer.MIN_VALUE;
        int minItem = Integer.MAX_VALUE;
        long itemSum = 0;

        for (int i : arr) {
            if (Integer.max(i, maxItem) == i) {
                maxItem = i;
            }

            if (Integer.min(i, minItem) == i) {
                minItem = i;
            }

            itemSum = Long.sum(itemSum, i);
        }

        System.out.print((itemSum - maxItem) + " " + (itemSum - minItem));
    }
}
