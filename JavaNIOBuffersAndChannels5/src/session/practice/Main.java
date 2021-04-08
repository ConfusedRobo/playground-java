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

/**
 * @author ConfusedRobo<p>
 * 21-12-20<p>
 * Do not modify.
 */
public class Main {

    /*
    * You may want to allocate the buffer to the largest location length even if you're not
    * planning to use it.
    * As, the JVM garbage collector de-allocates all the unused memory later so the clocking
    * of memory doesn't happen later.
    * */
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("binary.dat");

        // if the path exists already then no need to create the file
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        final int ALLOCATE_TOTAL = 40;      // Buffer capacity (bytes per write)
        try (FileOutputStream stream = new FileOutputStream(path.toString());
             FileChannel outputChannel = stream.getChannel()) {
            ByteBuffer writeBuffer = ByteBuffer.allocate(ALLOCATE_TOTAL);

            // stored in an array to utilize the length of the writes
            byte[] outputBytes = "Hello World!".getBytes(StandardCharsets.UTF_8);
            byte[] outputBytesLong = "Nice to meet you".getBytes(StandardCharsets.UTF_8);

            /*
             * Each Integer has 4 bytes hence, the Integer.BYTES
             * int1Pos -> to skip the length of outputChannel i.e. essentially the offset
             *            of where 14 starts. (relevant later)
             * int2Pos -> to skip the length of outputChannel and the integer 14 i.e.
             *            essentially the offset of where 17 starts. (relevant later)
             * int3Pos -> to skip the length of outputChannel and the integer 14, 17 i.e.
             *            essentially the offset of where 190 starts. (relevant later)
             * */
            // writing data to file
            writeBuffer.put(outputBytes);       // write length - 12
            long int1Pos = outputBytes.length;
            writeBuffer.putInt(14);             // write length - 4
            long int2Pos = int1Pos + Integer.BYTES;
            writeBuffer.putInt(17);             // write length - 4
            writeBuffer.put(outputBytesLong);   // write length - 16
            long int3Pos = int2Pos + Integer.BYTES + outputBytesLong.length;
            writeBuffer.putInt(190);            // write length - 4

            /*
             * Flips this buffer. The limit is set to the current position and then
             * the position is set to zero. If the mark is defined then it is discarded.
             *
             * After a sequence of channel-read or put operations, invoke this method
             * to prepare for a sequence of channel-write or relative get operations.
             *
             * For example:
             *        buf.put(magic);    // Prepend header
             *        in.read(buf);      // Read data into rest of buffer
             *        buf.flip();        // Flip buffer
             *        out.write(buf);    // Write header + data to channel
             * */
            writeBuffer.flip();     // w/o this you are writing from the previous position
            outputChannel.write(writeBuffer);

            // Reads only the integers in reverse order (seekable)
            RandomAccessFile randomStream = new RandomAccessFile(path.toString(), "r");
            FileChannel inputChannel = randomStream.getChannel();           // seekable
            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);     // only for reading integers

            /*
             * FileChannel.position()
             *
             * Sets this channel's file position.
             * Setting the position to a value that is greater than the file's current size is legal but
             * does not change the size of the file. A later attempt to read bytes at such a position
             * will immediately return an end-of-file indication. A later attempt to write bytes at such
             * a position will cause the file to be grown to accommodate the new bytes; the values of
             * any bytes between the previous end-of-file and the newly-written bytes are unspecified.
             * */
            inputChannel.position(int3Pos);     // places the buffer position (offset) to int3pos
                                                // i.e start of the first byte of the 190 integer
            inputChannel.read(readBuffer);      // reading 190 first
            readBuffer.flip();                  // w/o this you are reading from the previous position
            System.out.println("Integer 3: " + readBuffer.getInt());

            readBuffer.flip();                  // w/o this you are reading from the previous position
            // places the buffer position (offset) to int2pos
            // i.e start of the first byte of the 17 integer
            inputChannel.position(int2Pos);
            inputChannel.read(readBuffer);      // after 190 read 17

            readBuffer.flip();                  // w/o this you are reading from the previous position
            System.out.println("Integer 2: " + readBuffer.getInt());

            readBuffer.flip();                  // w/o this you are reading from the previous position
            // places the buffer position (offset) to int2pos
            // i.e start of the first byte of the 17 integer
            inputChannel.position(int1Pos);
            inputChannel.read(readBuffer);      // after 17 read 14
            
            readBuffer.flip();                  // w/o this you are reading from the previous position
            System.out.println("Integer 1: " + readBuffer.getInt());

            // As RandomAccessFile and FileChannel is not in try w/ resources
            // So, closing it manually.
            randomStream.close();
            inputChannel.close();
        }
    }
}
