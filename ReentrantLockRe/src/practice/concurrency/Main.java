package practice.concurrency;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final int EOF = -1;

    public static void main(String[] args) {
        var arrayList = new ArrayList<Integer>();
        var reentrantLock = new ReentrantLock(true);

        var producer = new Producer(arrayList, ThreadColor.ANSI_PURPLE, reentrantLock);
        var consumerA = new Consumer(arrayList, ThreadColor.ANSI_BLUE, reentrantLock);
        var consumerB = new Consumer(arrayList, ThreadColor.ANSI_GREEN, reentrantLock);

        new Thread(producer).start();
        new Thread(consumerA).start();
        new Thread(consumerB).start();
    }
}
