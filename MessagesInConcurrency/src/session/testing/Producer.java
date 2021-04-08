package session.testing;

public class Producer implements Runnable {
    private final Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        var messages = new String[]{
                "Hi",
                "Hello",
                "Yo",
                "Hey",
                "Howdy",
                "Greetings",
                "Aloha"
        };

        for (var string : messages) {
            System.out.println(ThreadColor.ANSI_RED + "Added data: " + string + ThreadColor.ANSI_RESET);
            message.write(string);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) {
                System.out.println(ThreadColor.ANSI_RED + "Production has been interrupted" + ThreadColor.ANSI_RESET);
            }
        }

        message.write("Finished");
    }
}
