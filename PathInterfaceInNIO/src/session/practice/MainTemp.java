package session.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainTemp {

    public static void main(String[] args) throws IOException {
        Path pathRelative = Paths.get("sample.txt");
        printFile(pathRelative);

        // D:\Programming & Development\JavaPrograms\PathInterfaceInNIO\files\sample_in_file.txt
        Path pathFiled = Paths.get(".", "files", "sample_in_file.txt");
        System.out.println(pathFiled);
        System.out.println(pathFiled.toAbsolutePath());
        printFile(pathFiled);

        Path pathAbsolute = Paths.get("D:\\Programming & Development\\" +
                "JavaPrograms\\PathInterfaceInNIO\\sample.txt");
        printFile(pathAbsolute);

        Path test1 = Paths.get(".");
        System.out.println(test1.toAbsolutePath());

        Path test2 = Paths.get("D:\\",  "Programming & Development",
                "JavaPrograms\\PathInterfaceInNIO\\sample.txt");
        printFile(test2.normalize());
        System.out.println(test2.toAbsolutePath());

        Path test3 = FileSystems.getDefault().getPath(".", "files", "..", "files", "sample_in_file.txt");
        printFile(test3);
        printFile(test3.normalize());
        System.out.println(test3.normalize());
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
