package company.practice.university;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /*
    * Write a Java program to replicate all matrix algorithms
    * namely, addition, subtraction, multiplication and transpose.
    * Also, include a menu in your main method for the user to
    * choose from.
    * For example, the menu may look like:-
    * Press
    *   0 - Re-print menu
    *   1 - Add two matrices
    *   2 - Subtract two matrices
    *   3 - Multiply two matrices
    *   4 - Quit application
    *   5 - Transpose of a matrix
    *   Choice: <your_choice_int>
    *
    * Lastly, include try and catch block to demonstrate exception
    * handling.
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Matrix - A.row: ");
            int rowA = scanner.nextInt();
            System.out.print("Matrix - A.column: ");
            int columnA = scanner.nextInt();
            Matrix matrixA = new Matrix(rowA, columnA);
            matrixA.setMatrix();
            System.out.println("Matrix - A\n" + matrixA);

            System.out.print("Matrix - B.row: ");
            int rowB = scanner.nextInt();
            System.out.print("Matrix - B.column: ");
            int columnB = scanner.nextInt();
            Matrix matrixB = new Matrix(rowB, columnB);
            matrixB.setMatrix();
            System.out.println("Matrix - B\n" + matrixB);

            boolean quit = false;
            printMenu();

            while (!quit) {
                System.out.print("Choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        quit = true;
                        System.out.println("Application exited.");
                        break;
                    case 1:
                        printMenu();
                        break;
                    case 2:
                        System.out.print("Matrix - A.row: ");
                        rowA = scanner.nextInt();
                        System.out.print("Matrix - A.column: ");
                        columnA = scanner.nextInt();
                        matrixA = new Matrix(rowA, columnA);
                        matrixA.setMatrix();
                        System.out.println("Matrix - A\n" + matrixA);

                        System.out.print("Matrix - B.row: ");
                        rowB = scanner.nextInt();
                        System.out.print("Matrix - B.column: ");
                        columnB = scanner.nextInt();
                        matrixB = new Matrix(rowB, columnB);
                        matrixB.setMatrix();
                        System.out.println("Matrix - B\n" + matrixB);
                        break;
                    case 3:
                        System.out.println(matrixA + "plus\n" + matrixB + "equals");
                        System.out.println(matrixA.add(matrixB));
                        break;
                    case 4:
                        System.out.println(matrixA + "minus\n" + matrixB + "equals");
                        System.out.println(matrixA.subtract(matrixB));
                        break;
                    case 5:
                        System.out.println(matrixA + "multiplied by\n" + matrixB + "equals");
                        System.out.println(matrixA.multiply(matrixB));
                        break;
                    case 6:
                        boolean isNull = matrixA.getTranspose() == null;

                        if (!isNull) {
                            System.out.println("Transpose of Matrix - A is");
                            for (int[] element : matrixA.getTranspose()) {
                                System.out.println(Arrays.toString(element));
                            }
                        } else {
                            System.out.println("Try again. Square matrix is required.");
                        }

                        isNull = matrixB.getTranspose() == null;
                        if (!isNull) {
                            System.out.println("Transpose of Matrix - B is");
                            for (int[] element : matrixB.getTranspose()) {
                                System.out.println(Arrays.toString(element));
                            }
                        } else {
                            System.out.println("Try again. Square matrix is required.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Non-integers aren't allowed.");
            main(args);
        }
        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Press\n" +
                "  0 - Quit\n" +
                "  1 - Re-print\n" +
                "  2 - Change matrices\n" +
                "  3 - Add\n" +
                "  4 - Subtract\n" +
                "  5 - Multiply\n" +
                "  6 - Transpose\n");
    }
}
