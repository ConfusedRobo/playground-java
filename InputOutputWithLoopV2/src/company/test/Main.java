package company.test;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter("tester.txt")) {
            writer.write("Following are 10 the odd numbers:-\n");
            for (int i = 1; i <= 10; i += 2) {
                writer.append(((Integer) i).toString()).append("\n");
            }
        }
    }
}