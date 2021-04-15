package company.papai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int myNum = scanner.nextInt();
        scanner.nextLine();

        if (myNum % 7 == 0 || myNum % 10 == 7) {
            System.out.println(myNum + " is a Buzz number.");
        } else {
            System.out.println(myNum + " isn't a Buzz number.");
        }

        scanner.close();
    }
}
