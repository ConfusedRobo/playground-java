package company.papai;

import java.util.Scanner;

public class NSS {
    private final Scanner scanner;
    private final int[] age;
    private final String[] name;
    private boolean flag = false;

    NSS() {
        scanner = new Scanner(System.in);
        name = new String[50];
        age = new int[50];
    }

    public void input() {
        System.out.println("Enter the required values:-");
        for (int i = 0; i <= 50; i++) {
            System.out.print((i + 1) + ". Name of the student: ");
            name[i] = scanner.nextLine();
            System.out.print("   Age of the student: ");
            allowedAge(i);
        }

        scanner.close();
        flag = true;
    }

    public int[] getAge() {
        if (!flag) {
            System.out.println("Arrays are empty!");
            return null;
        } else {
            return age;
        }
    }

    public String[] getName() {
        if (!flag) {
            System.out.println("Arrays are empty!");
            return null;
        } else {
            return name;
        }
    }

    private void allowedAge(int term) {
        while (true) {
            int age = scanner.nextInt();
            if (age > 17 && age < 23) {
                this.age[term] = age;
                scanner.nextLine();
                return;
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }
}
