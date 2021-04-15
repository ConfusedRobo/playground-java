package company.test;

import java.util.Scanner;

public class Matrix {
    private final int[][] matrixVar;
    private final int row;
    private final int column;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.matrixVar = new int[row][column];
    }

    public void setValues() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Element " + i + j + ": ");
                matrixVar[i][j] = scanner.nextInt();
            }
        }
    }

    public boolean isEqual(Matrix matrix) {
        return this.row == matrix.row && this.column == matrix.column;
    }

    public void add(Matrix matrixPar) {
        if (isEqual(matrixPar)) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(this.matrixVar[i][j]
                            + matrixPar.matrixVar[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix is not equal!");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result.append(matrixVar[i][j]).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
