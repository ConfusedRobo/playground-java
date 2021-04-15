package session.testing;

import java.util.Iterator;
import java.util.Objects;

/**
 * <strong>Algorithm</strong><br>
 * Define a Node class which represents a node in the list. It has two<br>
 * properties data and next which will point to the next node.
 * <p>
 * Define another class for creating the circular linked list and it has two nodes:<br>
 * head and tail.<br>
 * <p>
 * It has two methods:<br>
 * add() and display().<br>
 * add() will add the node to the list:
 * <p>
 * It first checks whether the head is null, then it will insert the node as the head.
 * Both head and tail will point to the newly added node.<br>
 * <p>
 * If the head is not null, the new node will be the new tail,
 * and the new tail will point to the head as it is a circular linked list.
 *
 * @param <E> is to generify the CircularSinglyLinkedList class.
 * @author Confused Robo
 * @see java.lang.Iterable
 */
public class CircularSinglyLinkedList<E> implements Iterable<Node<E>> {
    private Node<E> head;      // head of the List
    private Node<E> tail;      // tail of the List
    private Node<E> current;   // ongoing Node<T>

    private boolean isFirst = false;    // a counter to include the first iteration

    /**
     * This method adds a node to the circular linked list.
     * @param data sets the Node<T> data value
     * */
    public void add(E data) {
        // created a new Node<E> and stored the given data E data
        Node<E> newNode = new Node<>(data);

        /*
         * Objects.nonNull docs
         * This class consists of static utility methods for operating on objects,
         * or checking certain conditions before operation. These utilities include
         * null-safe or null-tolerant methods for computing the hash code of an object,
         * returning a string for an object, comparing two objects, and checking if
         * indexes or sub-range values are out of bounds.
         * */
        if (!Objects.nonNull(head)) {   // if the list is empty
            // head is backed by tail and tail is backed by newNode
            tail = newNode; // assign newNode as tail
            head = tail;    // assign the tail as head
            // Alternative: head = tail = newNode

            /*
             * set the next link of new Node<E> as head Node<E>
             * because the head is now backed by newNode then if we
             * change the state of newNode i.e. updating its link
             * then the head and tail will also be updated
             * */
            newNode.linkTo(head);
            return;
        }

        // the newNode doesn't have any link so, the tail node only contains itself and newNode
        // as the newNode doesn't have any link set so, i.e. why tail has 2 elements
        // lastly, tail.linkTo(newNode) actually, indirectly add to the head chain
        tail.linkTo(newNode);

        // tail is overwritten (everytime) but it doesn't affect the head chain
        // i.e. tail will keep on "changing" itself but the head's links will be traversed
        // i.e. tail acts as the current node for head so, that we can keep on adding values
        // to head node via tail.

        // AGAIN HEAD WILL NOT CHANGE AND CHANGING TAIL WON'T OVERWRITE HEAD IT'S LIKE
        // charAt(LENGTH - 1) I.E. JUST MOVES TO THE LAST ELEMENT OF HEAD THAT JUST HAPPENS TO
        // HAVE A NULL LINK.
        tail = newNode;

        // lastly, this line will connect the tail node with the head
        tail.linkTo(head);
    }

    /**
     * Call this method before iterating through the list. That is, essentially,<br>
     * <ul>
     *     <li>Calling this the first time is known as backup</li>
     *     <li>Calling this after the first time is referred to as updating</li>
     *     <li>If an element is added then you need to update the current Node<T> to view<br>
     *         the elements (updated) properly
     *     </li>
     * </ul>
     */
    public void backup() {
        current = head;    // updates current Node<T> with head Node<T>
    }

    /**
     * Returns the current Node<T> value i.e. basically a getter for current Node<T>
     *
     * @return Node<T> value
     */
    public Node<E> currentNode() {
        return current;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Node<E>> iterator() {
        return new Iterator<>() {
            /**
             * Returns {@code true} if the iteration has more elements.
             * (In other words, returns {@code true} if {@link #next} would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return current.next() != null;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             */
            @Override
            public Node<E> next() {
                if (!isFirst) {     // the first current element is now not ignored
                    isFirst = true;
                    return current;
                }

                // will return the next link if the list isn't empty
                return current = current.next();
            }
        };
    }
}
