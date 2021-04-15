package session.testing;

/**
 * This class is the simplest replication of a node in Data Structures i.e.<br>
 * it contains methods that will store the next link of the node<br>
 * (i.e where it will point to) and the another to get the data stored in the<br>
 * node. Note that the data will be stored via constructor and is immutable.
 *
 * @param <T> is to generify the node class.
 * @author Consfused Robo
 */
public class Node<T> {
    private final T data;   // node data will be stored here
    private Node<T> link;   // link to the next node will be stored here

    /**
     * This constructor only assigns value to the data field i.e. final.
     *
     * @param data is immutable.
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * Returns the next node if any, otherwise it will return null
     *
     * @return Node<T> value that is stored in the link field
     */
    public Node<T> next() {
        return link;
    }

    /**
     * This method must be used for changing or, setting a new value to the Node's<br>
     * link field.
     *
     * @param link is the Node that will be set as link field
     */
    public void linkTo(Node<T> link) {
        this.link = link;
    }

    /**
     * Getter for the class field data. As, the data value may be <strong>"used"</strong> later.<br>
     * Why a getter? Because, the data is a final variable.
     *
     * @return an integer
     */
    public T getData() {
        return data;
    }
}
