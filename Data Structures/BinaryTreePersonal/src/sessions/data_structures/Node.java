package sessions.data_structures;

import java.util.Objects;

public class Node {

    private final int data;
    private Node right;
    private Node left;

    public Node(int data) {
        this.data = data;
    }

    public int data() {
        return data;
    }

    public void linkLeft(Node left) {
        this.left = left;
    }

    public void linkRight(Node right) {
        this.right = right;
    }

    public Node fetchRight() {
        return right;
    }

    public Node fetchLeft() {
        return left;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Left Link: " + (Objects.nonNull(left) ? "Set" : "Not Set")
                + ", Right Link: " + (Objects.nonNull(right) ? "Set" : "Not Set");
    }
}