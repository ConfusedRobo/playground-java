package UdemyJavaMasterClass;

import java.util.*;

public class Main {

    static int simpleArraySum(int[] ar) {

        int sum = 0;

        for (int i = 0; i < ar.length; i++) {

            ar[i] = scanner.nextInt();
            sum += ar[i];

        }

        return sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(simpleArraySum(new int[6]));

    }

}