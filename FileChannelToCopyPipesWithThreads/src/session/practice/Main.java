package session.practice;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws IOException {
        var pipe = Pipe.open();

        Runnable writer = () -> {
            try {
                var sinkChannel = pipe.sink();
                var buffer = ByteBuffer.allocate(56);

                for (var index = 0; index < 10; index++) {
                    var currentTime = "The current time is: " + System.currentTimeMillis();
                    buffer.put(currentTime.getBytes(StandardCharsets.UTF_8));

                    buffer.flip();
                    while (buffer.hasRemaining()) sinkChannel.write(buffer);

                    buffer.flip();
                    Thread.sleep(100);
                }
            } catch (IOException | InterruptedException exception) {
                out.println("Message: " + exception.getMessage());
            }
        };

        Runnable reader = () -> {
            try {
                var sourceChannel = pipe.source();
                var buffer = ByteBuffer.allocate(56);

                for (var index = 0; index < 10; index++) {
                    var bytesRead = sourceChannel.read(buffer);
                    var data = new byte[bytesRead];

                    buffer.flip();
                    buffer.get(data);
                    out.println("Reader: " + new String(data));

                    buffer.flip();
                    Thread.sleep(100);
                }
            } catch (IOException | InterruptedException exception) {
                out.println("Message: " + exception.getMessage());
            }
        };

        new Thread(writer).start();
        new Thread(reader).start();
    }
}
