package session.testing;

import java.util.Locale;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CircularSinglyLinkedList<Character> list = new CircularSinglyLinkedList<>();

        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabets = (string.toUpperCase(Locale.ENGLISH)
                + string.toLowerCase(Locale.ENGLISH)).toCharArray();

        for (char letter : alphabets) {
            list.add(letter);
        }

        list.backup();
        for (Node<Character> node : list) {
            System.out.println(node.getData());
            Thread.sleep(500);
        }
    }
}
