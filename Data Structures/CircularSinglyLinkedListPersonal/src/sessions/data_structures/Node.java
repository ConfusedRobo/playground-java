package sessions.data_structures;

import java.util.Objects;

public class Node {

    private Node next;
    private final int data;

    public Node(int data) {
        this.data = data;
    }

    public int data() {
        return data;
    }

    public void linkNext(Node next) {
        this.next = next;
    }

    public Node fetchLink() {
        return next;
    }

    @Override
    public String toString() {
        return "Data: " + data + "\tLink: " + (Objects.nonNull(next) ? "Set" : "Not Set");
    }
}
