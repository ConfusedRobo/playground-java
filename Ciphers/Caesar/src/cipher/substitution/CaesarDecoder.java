package cipher.substitution;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CaesarDecoder {
    private String plain;
    private String cipher;
    private int key;

    public CaesarDecoder() {
        this.plain = null;
        this.cipher = null;
        this.key = -1;
    }

    public boolean decrypt() {
        StringBuilder decoded = new StringBuilder();
        final int ACTUAL_SHIFT = key %= 26;

        for (int i = 0; i < cipher.length(); i++) {
            char CURRENT_CHAR = cipher.charAt(i);

            if (!Character.isAlphabetic(CURRENT_CHAR)) {
                decoded.append(CURRENT_CHAR);
                continue;
            }

            if (Character.isUpperCase(CURRENT_CHAR)) {
                CURRENT_CHAR -= ACTUAL_SHIFT;
                decoded.append((char) (CURRENT_CHAR < 'A' ? CURRENT_CHAR + 26 : CURRENT_CHAR));
                continue;
            }

            CURRENT_CHAR -= ACTUAL_SHIFT;
            decoded.append((char) (CURRENT_CHAR < 'a' ? CURRENT_CHAR + 26 : CURRENT_CHAR));
        }

        plain = decoded.toString();
        return true;
    }

    public boolean updateDecoder(String cipher, int key) {
        if (key > 0 && key < 26) {
            this.cipher = cipher;
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
            cipher = new String(readArray);
            this.key = key;
        }
        return true;
    }

    public boolean decryptFile(Path dest) throws IOException {
        if (!Files.exists(dest)) {
            return false;
        }

        if (plain == null) {
            return false;
        }

        try (RandomAccessFile randomWrite = new RandomAccessFile(dest.toString(), "rwd")) {
            byte[] writeArray = plain.getBytes(StandardCharsets.UTF_8);

            randomWrite.write(writeArray);
        }
        return true;
    }

    public boolean isInitialized() {
        return key != -1 && cipher != null;
    }

    public String originalMessage() {
        return cipher;
    }

    public String decryptedMessage() {
        return plain;
    }
}
