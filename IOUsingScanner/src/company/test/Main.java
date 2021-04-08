package company.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter("testReader.txt")) {
            for (char letter = 'A'; letter <= 'C'; letter++) {
                writer.append(letter).append(", Type - ").append(letter).append("\n");
            }
        }

        try (Scanner scanner = new Scanner(new FileReader("testReader.txt"))) {
            scanner.useDelimiter(", ");
            StringBuilder list = new StringBuilder();

            while (scanner.hasNextLine()) {
                list.append(scanner.next().charAt(0)).append(": ");
                scanner.skip(scanner.delimiter());
                list.append(scanner.nextLine()).append("\n");
            }
            System.out.print("Test:-\n" + list);
        }
    }
}