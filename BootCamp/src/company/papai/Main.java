package company.papai;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MAX register = new MAX();
        int count = 0;

        ArrayList<String> leaderCandidates = new ArrayList<>();

        register.input();

        System.out.println("Entered values:-");
        for (int i = 0; i < 51; i++) {
            System.out.println((i + 1) + ". Name: " + register.getName()[i] + ", Age: " + register.getAge()[i]);
        }

        System.out.println("\nMaximum aged students: ");
        for (int i = 0; i <= 50; i++) {
            if (register.output() == register.getAge()[i]) {
                System.out.println((count + 1) + ". Student's name: " + register.getName()[i] + ", Student's age: " + register.getAge()[i]);
                leaderCandidates.add("Student's name: " + register.getName()[i] + ", Student's age: " + register.getAge()[i]);
            }
        }

        Random random = new Random();
        String leader = leaderCandidates.get(random.nextInt(leaderCandidates.size()));

        System.out.print("\nLeader of the group: \n" + leader);

    }
}












