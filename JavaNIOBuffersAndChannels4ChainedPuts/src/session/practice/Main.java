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
//    read(ByteBuffer)  -   reads bytes beginning at the channel's current position, and after the read,
//                          updates the position accordingly.
//                          Note that now we're talking about the channel's position, not the byte buffer's position.
//                          Of course, the bytes will be placed into the buffer starting at its current position.
//    write(ByteBuffer) -   the same as read, except it writes. There's one exception.
//                          If a datasource is opened in APPEND mode, then the first write will take place starting
//                          at the end of the datasource, rather than at position 0. After the write, the position
//                          will be updated accordingly.
//    position()        -   returns the channel's position.
//    position(long)    -   sets the channel's position to the passed value.
//    truncate(long)    -   truncates the size of the attached datasource to the passed value.
//    size()            -   returns the size of the attached datasource
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("binary.dat");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        try (FileOutputStream stream = new FileOutputStream(path.toString());
             FileChannel outputChannel = stream.getChannel()) {
            ByteBuffer writeBuffer = ByteBuffer.allocate(100);

            byte[] outputBytesLong = "Nice to meet you".getBytes(StandardCharsets.UTF_8);
            byte[] outputBytes = "Hello World!".getBytes(StandardCharsets.UTF_8);

            // chained puts
            writeBuffer.put(outputBytes).putInt(14).putInt(17).put(outputBytesLong).putInt(190);
            writeBuffer.flip();     // w/o this you are writing from the previous position
            outputChannel.write(writeBuffer);

            RandomAccessFile randomStream = new RandomAccessFile(path.toString(), "r");
            FileChannel inputChannel = randomStream.getChannel();       // seekable byte channel
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
