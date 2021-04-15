package datastructures.tree;

import java.util.Objects;

public class Node<T> {
    private final int key;
    private final T data;

    private Node<T> left;
    private Node<T> right;

    public Node(int key, T data) {
        this.key = key;
        this.data = data;
    }

    public int serial() {
        return key;
    }

    public void linkLeft(Node<T> left) {
        this.left = left;
    }

    public void linkRight(Node<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Data: " + data
                + "\nLeft link: " + (Objects.isNull(left) ? "Not linked" : "Linked")
                + "\nRight link: " + (Objects.isNull(right) ? "Not linked" : "Linked");
    }
}
