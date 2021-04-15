package utilities.csvoperations;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CSVReader {
    private final File csvFile;

    public CSVReader(File csvFile) {
        this.csvFile = csvFile;
    }

    public CSVReader(String pathname) {
        this(new File(pathname));
    }

    public String readLine(int lineNumber) throws IOException {
        try (RandomAccessFile randomRead = new RandomAccessFile(csvFile, "rwd")) {
            byte[] fileData = new byte[(int) randomRead.length()];
            randomRead.readFully(fileData);

            String fileDataString = new String(fileData);
            return fileDataString.split("\n")[lineNumber];
        }
    }

    public String readFull() throws IOException {
        try (RandomAccessFile randomRead = new RandomAccessFile(csvFile, "rwd")) {
            byte[] fileData = new byte[(int) randomRead.length()];
            randomRead.readFully(fileData);

            return new String(fileData);
        }
    }

    public String[] rowHeader() throws IOException {
        String[] head = readLine(0).split(",");
        head[0] = "Serial";
        return head;
    }
}
