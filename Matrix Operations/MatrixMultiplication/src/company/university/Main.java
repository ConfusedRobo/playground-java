package company.university;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                    System.out.println(matrixA + "multiplied by\n" + matrixB + "equals");
                    System.out.println(matrixA.multiply(matrixB));
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Press\n" +
                "  0 - Quit\n" +
                "  1 - Re-print\n" +
                "  2 - Change matrices\n" +
                "  3 - Multiply");
    }
}