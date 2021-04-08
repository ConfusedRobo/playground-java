package test.filehandling;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Path filePath = FileSystems.getDefault().getPath("tester.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            writer.write("This is sample text.\n" +
                    "This is sample text.\n" +
                    "This is sample text.\n" +
                    "This is sample text.\n" +
                    "This is sample text.\n");
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            ArrayList<String> fileData = new ArrayList<>(reader.lines().collect(Collectors.toUnmodifiableList()));
            for (String currentLine : fileData) {
                System.out.println(currentLine);
            }
        }

        try (Scanner scanner = new Scanner(Files.newBufferedReader(filePath))) {
            scanner.useDelimiter("sample ");
            StringBuilder customizedFileData = new StringBuilder();
            while (scanner.hasNext()) {
                customizedFileData.append(scanner.next());
                scanner.skip(scanner.delimiter());
                customizedFileData.append(scanner.next());
            }

            System.out.print(customizedFileData);
        }

        System.out.println(Files.getLastModifiedTime(filePath));
        System.out.println(Files.readString(filePath));

        Files.writeString(filePath, "This is another text.");
        System.out.println(Files.readString(filePath));

        Path copyPath = FileSystems.getDefault().getPath("copyDemo.txt");
        Files.copy(filePath, copyPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(Files.readString(copyPath));

        System.out.println(Files.deleteIfExists(filePath) ? "Deleted file." : "File doesn't exist.");
        Files.delete(copyPath);

        Path streamPath = FileSystems.getDefault().getPath("binary.dat");

        if (!Files.exists(streamPath)) {
            System.out.println("File doesn't exist - Creating it now...");
            Files.createFile(streamPath);
            System.out.println("File created.");
        }

        try (DataOutputStream stream
                     = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(streamPath)))) {
            stream.writeUTF("This is a sample text.");
        }

        try (DataInputStream stream
                     = new DataInputStream(new BufferedInputStream(Files.newInputStream(streamPath)))) {
            boolean eof = false;
            StringBuilder fileData = new StringBuilder();
            while (!eof) {
                try {
                    fileData.append(stream.readUTF()).append("\n");
                } catch (EOFException exception) {
                    eof = true;
                }
            }

            System.out.println(fileData);
        }

        Path writeDemo = FileSystems.getDefault().getPath("writeBinary.dat");
        if (!Files.exists(writeDemo)) {
            System.out.println("File doesn't exist - creating it now...");
            Files.createFile(writeDemo);
            System.out.println("File has been created.");
        }

        try {
            Files.write(writeDemo,
                    "This is a sample text.\nThis is a sample text.\n".getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
            byte[] fileDataBytes = Files.readAllBytes(writeDemo);
            for (byte character : fileDataBytes) {
                System.out.print((char) character);
            }

            ArrayList<String> fileDataLinesA = new ArrayList<>(Files.readAllLines(writeDemo, StandardCharsets.UTF_8));
            for (String line : fileDataLinesA) {
                System.out.println(line);
            }

            List<String> fileDataLinesB = Files.readAllLines(writeDemo);
            for (String line : fileDataLinesB) {
                System.out.println(line);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}