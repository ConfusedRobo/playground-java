package company.matrix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Row value of the matrix: ");
        int row = scanner.nextInt();
        System.out.print("Column value of the matrix: ");
        int column = scanner.nextInt();

        Matrix matrix = new Matrix(row, column);
        int[][] myArray = new int[row][column];

        System.out.println();

        System.out.println("Enter the array elements:-");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("%s%s : ", i, j);
                myArray[i][j] = scanner.nextInt();
            }
        }

        System.out.println();

        for (int[] i : myArray) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        matrix.setArray(myArray);
        System.out.println("============================");
        System.out.println("Transpose:-");
        int[][] dummy = matrix.getTranspose();
        if (dummy != null) {
            for (int[] i : dummy) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid result! Try again.");
        }

        scanner.close();
    }
}
