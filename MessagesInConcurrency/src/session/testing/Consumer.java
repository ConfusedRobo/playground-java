package session.testing;

public class Consumer implements Runnable {
    private final Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (var latestMessage = message.read(); !latestMessage.equals("Finished");
             latestMessage = message.read()) {
            System.out.println(ThreadColor.ANSI_BLUE + "Consumed: " + latestMessage + ThreadColor.ANSI_RESET);
        }
    }
}
