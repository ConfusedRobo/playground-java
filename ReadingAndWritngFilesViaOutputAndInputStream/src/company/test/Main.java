package company.test;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File binaryFile = new File("binary.dat");
        try (DataOutputStream outputStream =
                     new DataOutputStream(new BufferedOutputStream(new FileOutputStream(binaryFile)))) {
            for (char letter = 'A'; letter <= 'E'; letter++) {
                String textToBeWritten = letter + ", Type: " + letter + "\n";
                outputStream.writeUTF(textToBeWritten);
            }
        }

        try (DataInputStream inputStream =
                     new DataInputStream(new BufferedInputStream(new FileInputStream(binaryFile)))) {
            StringBuilder dataInFile = new StringBuilder();
            boolean eof = false;

            while (!eof) {
                try {
                    dataInFile.append(inputStream.readUTF());
                } catch (EOFException exception) {
                    eof = true;
                }
            }

            System.out.println("Data stored in " + binaryFile.getName() + ":-\n" + dataInFile);
        }

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(binaryFile))) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        }

        try (FileInputStream inputStream = new FileInputStream(binaryFile)) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        }

        try (BufferedInputStream inputStream
                     = new BufferedInputStream(new DataInputStream(new FileInputStream(binaryFile)))) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        }

        try (Scanner scanner
                     = new Scanner(new BufferedInputStream(new DataInputStream(new FileInputStream(binaryFile))))) {
            while (scanner.hasNext()) {
                System.out.print(scanner.next());
            }
        }

        try (DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(
                "binaryUser.dat")));
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter a line: ");
            String line = scanner.nextLine();
            outputStream.writeUTF(line);
        }

        try (DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(
                "binaryUser.dat")))) {
            System.out.println("Data in file:-\n" + inputStream.readUTF());
        }
    }
}