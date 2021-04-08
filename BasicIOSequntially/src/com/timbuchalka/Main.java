package com.timbuchalka;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) throws IOException {

        try (FileOutputStream binFile = new FileOutputStream("binary.dat");
             FileChannel outputChannel = binFile.getChannel()) {

            ByteBuffer writeBuffer = ByteBuffer.allocate(40);

            byte[] outputBytes = "Hello World!".getBytes();
            writeBuffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            writeBuffer.putInt(245);

            long int2Pos = int1Pos + Integer.BYTES;
            writeBuffer.putInt(-98765);
            byte[] outputBytesLong = "Nice to meet you".getBytes();
            writeBuffer.put(outputBytesLong);

            long int3Pos = int2Pos + Integer.BYTES + outputBytesLong.length;
            writeBuffer.putInt(1000);
            writeBuffer.flip();

            outputChannel.write(writeBuffer);

            RandomAccessFile randomRead = new RandomAccessFile("binary.dat", "r");
            FileChannel inputChannel = randomRead.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            inputChannel.position(int3Pos);
            inputChannel.read(readBuffer);
            readBuffer.flip();

            System.out.println("Integer 3 = " + readBuffer.getInt());

            readBuffer.flip();
            inputChannel.position(int2Pos);
            inputChannel.read(readBuffer);
            readBuffer.flip();
            System.out.println("Integer 2 = " + readBuffer.getInt());

            readBuffer.flip();
            inputChannel.position(int1Pos);
            inputChannel.read(readBuffer);
            readBuffer.flip();
            System.out.println("Integer 1 = " + readBuffer.getInt());
        }
    }
}
