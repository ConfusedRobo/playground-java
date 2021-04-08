package company.practice.easy;

import java.util.Scanner;

public class Geeks {
    // Function to take input using Scanner class
    static void IOFunction(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println(sc.nextInt());
            System.out.println(sc.nextFloat());
            System.out.println(sc.nextLong());
            System.out.println(sc.nextByte());
            sc.nextLine();

            System.out.println(sc.nextLine());
        }

        sc.close();

    }
}
