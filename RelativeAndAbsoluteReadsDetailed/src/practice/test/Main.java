package practice.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        try (FileOutputStream stream = new FileOutputStream("binary.dat");
             FileChannel channel = stream.getChannel()) {

            byte[] outputBytes = "Hello World!".getBytes(StandardCharsets.UTF_8);
            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            buffer.put(outputBytes);
            buffer.flip();
            System.out.println("Bytes written: " + channel.write(buffer));

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(25);

            intBuffer.flip();
            System.out.println("Bytes written: " + channel.write(intBuffer));

            intBuffer.flip();
            intBuffer.putInt(200);

            intBuffer.flip();
            System.out.println("Bytes written: " + channel.write(intBuffer));

            RandomAccessFile randomRead = new RandomAccessFile("binary.dat", "r");
            FileChannel channelDemo = randomRead.getChannel();

            outputBytes[0] = 'Z';
            outputBytes[1] = 'A';       // buffer variable is currently in writing mode

            buffer.flip();              // buffer variable has been changed to reading mode
            System.out.println("Bytes read: " + channelDemo.read(buffer));
            if (buffer.hasArray()) {
                System.out.println("Byte buffer: " + new String(buffer.array()));
            }

            intBuffer.flip();
            channelDemo.read(intBuffer);
            System.out.println("Data: " + intBuffer.getInt(0));

            intBuffer.flip();
            channelDemo.read(intBuffer);

            intBuffer.flip();
            // System.out.println(intBuffer.position());
            System.out.println("Data: " + intBuffer.getInt(0));
            // System.out.println(intBuffer.position());
            System.out.println("Data: " + intBuffer.getInt());

            channelDemo.close();
            randomRead.close();
        }
    }
}
