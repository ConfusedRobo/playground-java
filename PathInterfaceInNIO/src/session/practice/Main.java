package session.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path pathRelative = FileSystems.getDefault().getPath("sample.txt");
        printFile(pathRelative);

        Path pathFiled = FileSystems.getDefault().getPath("files", "sample_in_file.txt");
        printFile(pathFiled);

        Path pathAbsolute = FileSystems.getDefault().getPath("D:\\Programming & Development\\" +
                "JavaPrograms\\PathInterfaceInNIO\\sample.txt");
        printFile(pathAbsolute);
    }

    public static void printFile(Path path) throws IOException {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}