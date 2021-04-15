package company.university;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Copyright (c) Created by ConfusedRobo at 8/11/2020.
 * Do not reuse or modify without the developer's approval.
 */
public final class Matrix implements Comparable<Matrix> {
    private final int[][] matrixArray;
    private final int row;
    private final int column;

    /**
     * @param row initializes the row class field.
     * @param column initializes the column class field.
     * Lastly, it initializes the matrixArray field with
     * row and column.
     */
    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrixArray = new int[row][column];
    }

    /**
     * Used to set the array elements' values in matrix format.
     *
     * @exception InputMismatchException will be thrown and caught
     * if anything besides and integer is entered via Scanner.
     */
    public void setMatrix() throws InputMismatchException {
        System.out.println("Set the values of the matrix:-");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Position " + (1 + i) + (1 + j) + " = ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    matrixArray[i][j] = scanner.nextInt();
                } catch (InputMismatchException exception) {
                    throw new InputMismatchException();
                }
            }
        }
    }

    /**
     * @param matrix is the only parameter.
     * Extracts rows and columns from the given parameter's class
     * field matrixArray and subtracts with its co-responding class
     * field 'matrixArray' variable.
     * Meaning, array[0][0] = matrixArray[0][0] - matrix.matrixArray[0][0]
     * i.e. first element of the class field 'matrixArray' will
     * be subtracted from the first element of the provided parameter
     * of matrix.matrixArray.
     *
     * @return Matrix class variable that is the subtraction of this
     * matrix and parameter matrix. And null if matrix is not a
     * if parameter's order is not equal to this class' order.
     * */
    public Matrix subtract(Matrix matrix) {
        Matrix result = new Matrix(row, column);

        //will return null if the matrix is not square.
        if (notSquare()) {
            System.out.println("Matrix should be a square.");
            return null;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result.matrixArray[i][j] = this.matrixArray[i][j] - matrix.matrixArray[i][j];
            }
        }

        return result;
    }

    /**
     * When invoked it will give out the
     * logic: if row is equal to column or, not.
     *
     * @return true if row is not equal to column
     * otherwise false.
     */
    public boolean notSquare() {
        /*
        Alternate logic
        if (column == row) {
            return true;
        } else {
            return false;
        }
         */
        return row != column;
    }

    /**
     * Traverses the matrix.
     * Uses the StringBuilder class to add as, in
     * concatenate new values to the builder.
     * It does so by adding the contained arrays via
     * Arrays.toString() method and adds it via chunks.
     *
     * For example: 1st array is {1,2,3} and second is {2,3,4}
     * so, adding via chunks means {1,2,3} + "\n" + {2,3,4} i.e.
     * {1,2,3}
     * {2,3,4}
     * Will be the result.
     *
     * @return String
     * */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int[] element : matrixArray) {
            string.append(Arrays.toString(element)).append("\n");
        }

        return string.toString();
    }

    /**
     * @param matrix is the only parameter.
     * compares if the given matrices' rows is equal
     * to this class's row similarly, for columns.
     *
     * For example: If this class is 2|2 ordered matrix
     * and given class(the parameter) is 2|3 ordered matrix
     * then the method will return 0 and 1 if otherwise.
     *
     * @return Integer value i.e. 1 if isEqual variable gives out
     * true i.e. when parameter matrices' row is equal to that
     * of the this class matrix and likewise for columns.
     * */
    @Override
    public int compareTo(Matrix matrix) {
        boolean isEqual = this.row == matrix.row && this.column == matrix.column;
        return isEqual ? 1 : 0;
    }
}