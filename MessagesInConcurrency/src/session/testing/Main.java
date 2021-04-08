package session.testing;

public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        Producer producer = new Producer(message);
        Consumer consumer = new Consumer(message);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}