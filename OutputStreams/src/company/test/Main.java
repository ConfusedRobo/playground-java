package company.test;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
         * A data output stream lets an application write primitive Java data types
         * to an output stream in a portable way. An application can then use
         * a data input stream to read the data back in.
         *
         * Note that, it writes the data in a binary format. Bit by bit.
         * */
        try (DataOutputStream outputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(
                                /*
                                 * Here, I could've used a .txt file but, I did not do so
                                 * because the user isn't meant to open a binary file as a
                                 * text file or, read the binary file's contents as text.
                                 * */
                                new File("tester.dat"))))) {

            for (char letter = 'A'; letter <= 'E'; letter++) {
                outputStream.writeUTF(letter + ", Type - " + letter + "\n");
            }

            for (int number = 1; number <= 5; number++) {
                outputStream.writeInt(number);
                outputStream.writeUTF("\n");
            }

            for (char letter = 'A'; letter <= 'E'; letter++) {
                String string = letter + ", Type - " + letter + "\n";
                char[] chars = string.toCharArray();
                for (char character : chars) {
                    outputStream.write(character);
                }
            }

            for (char letter = 'A'; letter <= 'E'; letter++) {
                char[] chars = (letter + ", Type - " + letter + "\n").toCharArray();
                for (char character : chars) {
                    byte toByte = (byte) character;
                    outputStream.write(toByte);
                }
            }
        }
    }
}
