package session.testing;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path rootPath = FileSystems.getDefault().getPath("D:" + File.separator + "Documents");
        FileTreeWalker walker = new FileTreeWalker("Introduction_to_algorithms-3rd Edition.txt");

        try {
            Files.walkFileTree(rootPath, walker);
            for (Path path : walker.matchedPaths()) {
                System.out.println(path.toAbsolutePath());
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
