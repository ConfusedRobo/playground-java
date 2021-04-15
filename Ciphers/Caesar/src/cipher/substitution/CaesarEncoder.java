package cipher.substitution;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CaesarEncoder {
    private String plain;
    private String cipher;
    private int key;

    public CaesarEncoder() {
        this.plain = null;
        this.cipher = null;
        this.key = -1;
    }

    public boolean encrypt() {
        if (!isInitialized()) {
            return false;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {

            final char CURRENT_CHAR = plain.charAt(i);
            if (!Character.isAlphabetic(CURRENT_CHAR)) {
                builder.append(CURRENT_CHAR);
                continue;
            }

            char SHIFTED_CHAR = (char) (Character.isLowerCase(CURRENT_CHAR)
                    ? (CURRENT_CHAR + key - 'a') % 26 + 'a'
                    : (CURRENT_CHAR + key - 'A') % 26 + 'A');
            builder.append(SHIFTED_CHAR);
        }

        cipher = builder.toString();
        return true;
    }

    public boolean updateEncoder(String plain, int key) {
        if (key > 0 && key < 26) {
            this.plain = plain;
            this.key = key;
            return true;
        }

        return false;
    }

    public boolean parseFile(Path src, int key) throws IOException {
        if (!Files.exists(src)) {
            return false;
        }

        try (RandomAccessFile randomRead = new RandomAccessFile(src.toString(), "rwd")) {
            byte[] readArray = new byte[(int) randomRead.length()];

            randomRead.readFully(readArray);
            plain = new String(readArray);
            this.key = key;
        }
        return true;
    }

    public boolean encryptFile(Path dest) throws IOException {
        if (!Files.exists(dest)) {
            return false;
        }

        if (cipher == null) {
            return false;
        }

        try (RandomAccessFile randomWrite = new RandomAccessFile(dest.toString(), "rwd")) {
            byte[] writeArray = cipher.getBytes(StandardCharsets.UTF_8);

            randomWrite.write(writeArray);
        }
        return true;
    }

    public boolean isInitialized() {
        return key != -1 && plain != null;
    }

    public String originalMessage() {
        return plain;
    }

    public String encryptedMessage() {
        return cipher;
    }
}
