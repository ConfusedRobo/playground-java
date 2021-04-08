package company.test;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
         * Creating a file called test.txt in src/resources file path.
         * I did this because of my preference. Writing out the file name
         * everytime is annoying.
         * */
        File test = new File("test.txt");

        System.out.println("Writing data to file...");
        try (FileWriter writer = new FileWriter(test)) {
            /*
             * Looping from A to E (inclusive). and then appending
             * currentLetter + ", Type - " + currentLetter to the file.
             *
             * write() is being used before the loop to erase everything in the file.
             * */
            writer.write("");
            for (char letter = 'A'; letter <= 'E'; letter++) {
                /*
                 * I'm using append() because write() erases everything and then writes to
                 * the file i.e. every time it is invoked it deletes everything in the
                 * file and then writes data to it.
                 *
                 * append() actually adds (concatenates) to the already entered value.
                 * */
                writer.append(letter).append(", Type - ").append(letter).append("\n");
            }
            System.out.println("Done writing data to file.\n");
        }

        /*
         * Just a FileReader class i.e. being used for reading data from test.txt file.
         * It is to illustrate that FileReader class can be used independently.
         */
        try (FileReader reader = new FileReader(test)) {
            int read;
            while ((read = reader.read()) != -1) {
                System.out.print((char) read);
            }
        }

        System.out.println("Testing with buffered reader:-");
        /*
         * This buffered reader will take FileReader(test)
         * as its constructor parameter - also the FileReader
         * will take the file 'test' as its constructor parameter.
         * */
        try (BufferedReader reader = new BufferedReader(new FileReader(test))) {
            /*
             * String line in the loop statement will initially store the first line
             * it reads from the file.
             * And, if the value (initial) is a null value that means the file is empty.
             * and the loop will hence terminate. Else, it'll go inside the loop and
             * execute its statements.
             * Next, it'll update the line variable with the next line and it'll again check
             * if the line it read is null or not. It will keep on going like this until it has
             * reached EOF.
             *
             * But, how does do we know that it has reached the end of file?
             * Well, for that take a look at the code snippet below - notice how readLine() is
             * being used to parse the lines from the file to String line variable.
             *
             * The method readLine() actually returns 'null' when it has encountered EOF. So, when
             * the loop reads the line after the last, it'll return 'null' which I'm storing in
             * the line variable.
             * Visit: https://stackoverflow.com/a/36516401 for more details.
             *
             * Note: readLine() method '\n' as its delimiter.
             * */
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println("\t" + line);
            }
            System.out.println();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(test))) {
            /*
            * Here, I'm trying to replicate the useDelimiter() and the skip() combo
            * using BufferedReader. So, instead of that I've used the split() method
            * and a String variable named 'delimiter' to store the delimiter (obviously).
            *
            * But, here in this case the delimiter is ", " i.e. a comma and a space. So, the
            * split(", ") method in this case looks for ", " string and when it encounters it
            * saves up the values that it read (except the delimiter) to an array.
            * Now, suppose there are multiple matches, then in that case, it'll store the
            * value from after the most recent match to the next match (if any).
            * */
            String delimiter = ", ";
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                /*
                * Here, you can also use: line.split(delimiter)[0] + ": " + line.split(delimiter)[1]
                * I've created words because it is clean.
                * */
                String[] words = line.split(delimiter);
                /*
                * Here, the readLine() method in the loop statement, reads up to the end of line
                * then that line is broken down into two parts - using the delimiter - and is
                * stored into a string variable called words. Now, as there are and will
                * be only two elements in this array, we can guess that the 0th element is
                * the first part of the string and the 1st is the second.
                *
                * Note that words is overwritten everytime the loop is iterated. It is because
                * line variable is also being updated as it moves to the next line.
                * */
                System.out.println("\t" + words[0] + ": " + words[1]);
            }
            System.out.println();
        }

        /*
        * I don't know what I did here. I just followed my instincts.
        * */
        try (BufferedReader reader = new BufferedReader(new FileReader(test))) {
            for (String line : reader.lines().collect(Collectors.toUnmodifiableList())) {
                System.out.println("\t" + line);
            }
            System.out.println();
        }

        System.out.println("Testing with scanner:-");
        /*
        * Here, the hasNextLine() method looks out for the '\n' character in the
        * text file. If there's no next line left in the file then it'll return
        * true, false if otherwise.
        * So the loop will keep on iterating if there are lines left to read in the
        * file.
        * */
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(test)))) {
            while (scanner.hasNextLine()) {
                /*
                * nextLine() throws an exception if theres no lines left to read.
                * So, the hasNextLine() method is looking out for that.
                * */
                System.out.println("\t" + scanner.nextLine());
            }
            System.out.println();
        }

        /*
        * Here, scanner is directly being read from file.
        * */
        try (Scanner scanner = new Scanner(test)) {
            /*
            * (, )? regex looks for a comma and a space after that comma and this whole
            * delimiter should match only once with the current line if there are more,
            * then the line is invalid.
            * */
            scanner.useDelimiter("(, )?");
            while (scanner.hasNext()) {
                System.out.print("\t" + scanner.next() + ": ");
                scanner.skip(scanner.delimiter());
                System.out.println(scanner.nextLine());
            }
        }

        /*
         * Here, scanner is directly reads from the file. Here, data read speed is lower
         * than the BufferedReader wrapped by the scanner one - because here it reads data
         * bit by bit from the file.
         * */
        try (Scanner scanner = new Scanner(test)) {
            /*
             * (, )? regex looks for a comma and a space after that comma and this whole
             * delimiter should match only once with the current line if there are more,
             * then the line is invalid.
             * */
            scanner.useDelimiter("(, )?");
            while (scanner.hasNext()) {
                System.out.print("\t" + scanner.next() + ": ");
                scanner.skip(scanner.delimiter());
                System.out.println(scanner.nextLine());
            }
            System.out.println();
        }

        /*
         * Creating a separate file for testing buffer reader. And, populating it with
         * A to E i.e. by inserting 'A, Type - A' where the first and last letters will
         * increment.
         * */
        File bufferTest = new File("bufferTest.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bufferTest))) {
            for (char letter = 'A'; letter <= 'E'; letter++) {
                writer.append(letter).append(", Type - ").append(letter).append("\n");
            }
        }

        /*
         * Testing the BufferedReader with BufferedReader.
         * Note that the BufferedReader reads a chunk of data at a time 8KB to be more specific.
         * It does not read data bit by bit like the traditional file reader.
         * */
        try (BufferedReader reader = new BufferedReader(new FileReader(bufferTest))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] divideInto = line.split(", ");
                System.out.println("\t" + divideInto[0] + ": " + divideInto[1]);
            }
        }
    }
}