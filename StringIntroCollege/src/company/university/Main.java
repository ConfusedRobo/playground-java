package company.university;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp;

        System.out.print("Enter a string: ");
        String string = scanner.nextLine();
        StringFunctions stringFunctions = new StringFunctions(string);

        printList();
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 0 -> System.out.println("Reverse of string '" + string + "' is '" + stringFunctions.getReverse() + "'.");
            case 1 -> {
                System.out.print("Concatenate '" + string + "' with: ");
                temp = scanner.nextLine();
                System.out.println("'" + string + "' plus '" + temp + "' is '" + stringFunctions.concatenateString(temp) + "'.");
            }
            case 2 -> {
                System.out.print("Compare '" + string + "' with: ");
                temp = scanner.nextLine();
                int comparison = stringFunctions.compareString(temp);
                if (comparison == 0) {
                    System.out.println("'" + string + "' is equal to '" + temp + "'.");
                } else {
                    System.out.println("'" + string + "' is not equal to '" + temp + "'.");
                }
            }
            case 3 -> System.out.println("Switching '" + string + "' to uppercase '" + stringFunctions.toCapital() + "'.");
            case 4 -> System.out.println("Switching '" + string + "' to lowercase '" + stringFunctions.toSmall() + "'.");
            case 5 -> {
                System.out.println("Application exited.");
                System.exit(0);
            }
            default -> System.out.println("No such choice exists!");
        }

        scanner.close();
    }

    public static void printList() {
        System.out.println("""
                Press
                  0 - Reverse the string
                  1 - Concatenate with another string
                  2 - Compare with another string
                  3 - Switch all the letters to uppercase
                  4 - Switch all the letters to lowercase
                  5 - Quit""");
    }
}
