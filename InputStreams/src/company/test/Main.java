package company.test;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
         * Here, I could've used a .txt file but, I did not do so
         * because the user isn't meant to open a binary file as a
         * text file or, read the binary file's contents as text.
         * */
        File binaryFile = new File("tester.dat");
        try (DataOutputStream outputStream = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(binaryFile)))) {

            for (char letter = 'A'; letter <= 'E'; letter++) {
                outputStream.writeUTF(letter + ", Type - " + letter + "\n");
            }
        }

        try (DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream(binaryFile)))) {

            StringBuilder fileText = new StringBuilder();
            boolean eof = false;
            while (!eof) {
                try {
                    fileText.append(inputStream.readUTF());
                } catch (EOFException exception) {
                    eof = true;
                }
            }
            
            System.out.print(fileText);
        }

        try (DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream(binaryFile)))) {

            int reads = inputStream.read();
            while (reads != -1) {
                System.out.print((char) inputStream.read());
                reads = inputStream.read();
            }
        }
    }
}
