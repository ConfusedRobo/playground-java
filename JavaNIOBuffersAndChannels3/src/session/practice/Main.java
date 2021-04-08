package session.practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    /*
    * Multiple buffers are being used here to ensure that the file is actually being read in
    * this case - if we ar reusing the write buffer then the buffer has already pre-stored the
    * data and you cannot differentiate whether data has been actually read or, not. Since, the
    * buffer has previous data in it.
    * */
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("binary.dat");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        try (FileOutputStream stream = new FileOutputStream(path.toString());
             FileChannel outputChannel = stream.getChannel()) {
            ByteBuffer writeBuffer = ByteBuffer.allocate(100);

            byte[] outputBytes = "Hello World!".getBytes(StandardCharsets.UTF_8);
            writeBuffer.put(outputBytes);
            writeBuffer.putInt(14);
            writeBuffer.putInt(17);

            byte[] outputBytesLong = "Nice to meet you".getBytes(StandardCharsets.UTF_8);
            writeBuffer.put(outputBytesLong);
            writeBuffer.putInt(190);

            writeBuffer.flip();     // w/o this you are writing from the previous position
            outputChannel.write(writeBuffer);

            RandomAccessFile randomStream = new RandomAccessFile(path.toString(), "r");
            FileChannel inputChannel = randomStream.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            inputChannel.read(readBuffer);

            readBuffer.flip();      // w/o this you are reading from the previous position
            byte[] inputBytes = new byte[outputBytes.length];
            readBuffer.get(inputBytes);
            System.out.println("Input bytes: " + new String(inputBytes));

            System.out.println("First integer: " + readBuffer.getInt());
            System.out.println("Second integer: " + readBuffer.getInt());

            byte[] inputBytesLong = new byte[outputBytesLong.length];
            readBuffer.get(inputBytesLong);
            System.out.println("Input bytes long: " + new String(inputBytesLong));

            System.out.println("First integer: " + readBuffer.getInt());
        }
    }
}
