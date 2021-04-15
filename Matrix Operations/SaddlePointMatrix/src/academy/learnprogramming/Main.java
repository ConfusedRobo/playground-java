package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Matrix sizes");
        System.out.print("\nRow size : ");
        int rowSize = scanner.nextInt();
        System.out.print("\nColumn size : ");
        int columnSize = scanner.nextInt();


        int [][]matrixArray = new int[rowSize][columnSize];
        int highestColumn = 0;

        System.out.print("Array elements\n");

        for (int i = 0; i < rowSize; i++)
            for (int j = 0; j < columnSize; j++) {

                System.out.printf("\nElement location(%d, %d) : ", i, j);
                matrixArray[i][j] = scanner.nextInt();

            }

        System.out.print("\nMatrix representation : \n");

        for (int i = 0; i < rowSize; i++) {

            for (int j = 0; j < columnSize; j++)
                    System.out.print(matrixArray[i][j] + " ");
            System.out.print("\n");

        }

        for (int i = 0; i < rowSize; i++) {

            int lowestRow = matrixArray[i][0];
            int column = 0;

            for (int j = 1; j < columnSize; j++) {

                if (matrixArray[i][j] < lowestRow) {

                    lowestRow = matrixArray[i][j];
                    column = j;

                }

            }

            for (int k = 0; k < rowSize; k++) {

                if (lowestRow < matrixArray[k][column]) {

                    highestColumn = 0;
                    break;

                } else
                    highestColumn = lowestRow;

            }

            if (highestColumn != 0)
                System.out.println("Saddle point : " + highestColumn);

            else
                System.out.println("No, saddle point!");

        }

    }

}
