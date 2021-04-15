package company.papai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String myStr = scanner.nextLine();

        if (myStr.charAt(0) == '0') {
            System.out.println(myStr + " is a Duck number.");
        } else {
            System.out.println(myStr + " isn't a Duck number.");
        }

        scanner.close();
    }
}
