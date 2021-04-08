package session.testing;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple file/directory finder class that extends the SimpleFileVisitor<Path>
 * class.
 *
 * @author Confused Robo
 * Dated: 04-01-21<br>
 * Do not modify.
 * */
public class FileTreeWalker extends SimpleFileVisitor<Path> {
    private final List<Path> matches = new ArrayList<>();
    private final String match;

    /**
     * This constructor is used so, that the matcher can only be used once
     * That is, it basically assigns to the match member field variable
     *
     * @param match is the file name (with extension) to be matched
     * */
    public FileTreeWalker(String match) {
        this.match = match;     // setting value to the member var
    }

    /**
     * Invoked for a file in a directory.
     *
     * <p> This method returns {@link FileVisitResult#CONTINUE
     * CONTINUE}.
     *
     * @param file is the path to be currently visited i.e. reference to the file
     * @param attributes is the file attributes that are in that path
     * @return a FileVisitResult value
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
        if (file.endsWith(match)) {     // if the file name matches
            matches.add(file);          // that Path will be added to matched path list
        }

        return FileVisitResult.CONTINUE;    // continue traversing even if a match is found
    }

    /**
     * Invoked for a file that could not be visited.
     *
     * <p> Unless overridden, this method re-throws the I/O exception that prevented
     * the file from being visited.
     *
     * @param file that is to be accessed
     * @param exception that is to be thrown if any error occurs during accession
     * @return FileVisitResult value
     */
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exception) {
        System.out.println("Failed at: " + file.toAbsolutePath());      // print the path it has failed at
        return FileVisitResult.CONTINUE;    // continue traversing even if accession error occurs
    }

    /**
     * Method that stores and returns the matched paths in the form of an
     * unmodifiable list.
     * Note that it will return a null (empty) list if there's no items in the list.
     *
     * @return List<Path> value
     * */
    public List<Path> matchedPaths() {
        return Collections.unmodifiableList(matches);
    }
}
