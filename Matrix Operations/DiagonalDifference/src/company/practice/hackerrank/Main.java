package company.practice.hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> matrix = new LinkedList<>();

        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            List<Integer> temp = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                temp.add(scanner.nextInt());
            }

            matrix.add(temp);
        }

        System.out.println(matrix.toString() + diagonalDifference(matrix));
        scanner.close();
    }

    /**
     * Visit: https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sumOfDiagonals = 0;
        int count = arr.size();

        for (int i = 0; i < arr.size(); i++) {
            sumOfDiagonals += arr.get(i).get(--count) - arr.get(i).get(i);
        }

        if (Math.signum(sumOfDiagonals) < 0) {
            sumOfDiagonals /= -1;
        }

        return sumOfDiagonals;
    }
}
