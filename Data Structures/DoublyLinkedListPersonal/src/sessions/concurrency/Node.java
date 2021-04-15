package sessions.concurrency;

import java.util.Objects;

public class Node {

    private final int data;
    private Node next;
    private Node previous;

    public Node(int data) {
        this.data = data;
    }

    public Node fetchNext() {
        return next;
    }

    public void linkNext(Node next) {
        this.next = next;
    }

    public Node fetchPrevious() {
        return previous;
    }

    public void linkPrevious(Node previous) {
        this.previous = previous;
    }

    public int data() {
        return data;
    }

    @Override
    public String toString() {
        return String.format("Data: %s, Next: %s, Previous: %s", data,
                Objects.nonNull(next) ? "Set" : "Not Set",
                Objects.nonNull(previous) ? "Set" : "Not Set");
    }
}
