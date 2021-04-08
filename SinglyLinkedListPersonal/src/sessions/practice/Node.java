package sessions.practice;

import java.util.Objects;

/**
 * This is a custom implementation of a list node
 * @see Objects
 * */
public class Node {

    private Node next;
    private final int data;

    /**
     * Initializes the final field {@code data} with a value that
     * cannot be changed. I did this because the LinkedList implementation
     * becomes much easier
     * @param data is the value to be initialized with
     * */
    public Node(int data) {
        this.data = data;
    }

    /**
     * Getter method for {@code data} field
     * @return int that will return data stored in the node
     * */
    public int data() {
        return data;
    }

    /**
     * Setter for the {@code next} member field. It basically sets the next link
     * of the node
     * @param next is the value/node to be linked with
     * */
    public void linkNext(Node next) {
        this.next = next;
    }

    /**
     * Getter for the {@code next} link node
     * @return Node i.e. supposedly the next node connected to this node
     * */
    public Node fetchLink() {
        return next;
    }

    /**
     * This method returns the string representation of this node class
     * @return String - i.e. a formatted string representation of this
     * class
     * @see Objects
     * */
    @Override
    public String toString() {
        return "Data: " + data + "\tLink: " + (Objects.nonNull(next) ? "Set" : "Not Set");
    }
}
