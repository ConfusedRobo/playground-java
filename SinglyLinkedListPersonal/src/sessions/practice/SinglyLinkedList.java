package sessions.practice;

import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * This is a custom implementation of Singly linked list
 * data structure
 * @see java.lang.Iterable
 * @see Objects
 * @see Iterator
 * @see Math
 * @see Node
 * */
public class SinglyLinkedList implements Iterable<Integer> {

    /**
     * Head of the node
     * */
    private Node head;
    private int size = 0;

    private Node first;
    private Node last;

    /**
     * This method returns the <b>total</b> number of elements it contains\
     * @return int i.e. the <b>size/length</b> of the list
     */
    public int size() {
        return size;
    }

    /**
     * This method determines whether the list is <b>empty</b> or not
     *
     * @return <b>true</b> if empty <b>false</b>, otherwise
     * @see Objects
     */
    public boolean isEmpty() {
        return Objects.isNull(head);
    }

    /**
     * This method <b>recalculates</b> the {@code last} field and {@code first} field<br />
     * Call this method after you've made changes to the list. For example, call this
     * method after you've added an item to list so that you can store the new
     * {@code last} field and {@code first} field values
     *
     * @see Objects
     */
    private void updateExtremes() {
        if (isEmpty()) return;      // if empty then do nothing
        first = new Node(head.data());

        var sentinel = head;
        // travel to the last node then terminate
        while (Objects.nonNull(sentinel.fetchLink())) sentinel = sentinel.fetchLink();
        last = sentinel;
    }

    /**
     * This method gets the <b>first</b> item in the list
     *
     * @return Node class <b>reference</b> i.e. the first item
     */
    public Node firstItem() {
        return first;
    }

    /**
     * This method gets the <b>last</b> item in the list
     *
     * @return Node class  <b>reference</b> i.e. the last item
     */
    public Node lastItem() {
        return last;
    }

    /**
     * This method adds an element to the <b>end</b> of the list
     *
     * @param data is the value to be inserted
     */
    public void append(int data) {
        ++size;     // increase the list size
        if (isEmpty()) head = new Node(data);
        else append(head, data);    // call the helper function
        updateExtremes();
    }

    /**
     * This is a <b>helper</b> method that travels through the list until the last element
     * is reached. Then it sets the next link as the given data value. Note that it
     * passes the reference to the head node
     *
     * @param data     is the data value to be appended
     * @param sentinel is the reference that needs to be traversed
     * @see Objects
     */
    private void append(Node sentinel, int data) {
        if (Objects.isNull(sentinel.fetchLink())) sentinel.linkNext(new Node(data));

            // recursively call this method if the next link isn't null
        else append(sentinel.fetchLink(), data);
    }

    /**
     * This method adds an element in the <b>start</b> of the list
     *
     * @param data is the value to be pushed
     */
    public void prepend(int data) {
        ++size;
        if (isEmpty()) head = new Node(data);
        else {
            var sentinel = new Node(data);      // create a new node
            sentinel.linkNext(head);            // set the new node's next link as head chain
            head = sentinel;                    // overwrite the head node with the sentinel
        }
        updateExtremes();
    }

    /**
     * This method <b>deletes</b> a list element at a <b>specific index</b> number
     *
     * @param position is the index that needs to be removed
     */
    public void delete(int position) {
        if (position >= size || position < 0) return;   // do nothing if the pos is invalid
        var count = 0;
        var sentinel = head;

        while (true) {
            if (position == 0) {
                removeFirst();
                break;
            }

            if (position == size - 1) {
                removeLast();
                break;
            }

            // increment the count if the current index is != previous element of the pos
            if (count++ == position - 1) {
                --size;     // decrease the element count
                sentinel.linkNext(get(position + 1));
                break;
            }

            // else move on to the next link
            sentinel = sentinel.fetchLink();
        }
    }

    /**
     * This method <b>removes the last element</b> in the list if the head is null
     * then do nothing
     */
    public void removeLast() {
        if (size == 1) {            // if list has only one element
            head = null;            // make head null itself
            size = 0;               // then set size to 0
        } else if (size > 1) {      // if size > 1 call the helper method
            removeLast(head);
            --size;
        }
        updateExtremes();
    }

    /**
     * This is a helper method that will travel through the last element
     * of the list
     *
     * @param sentinel i.e. the node to be traversed
     * @see Objects
     */
    private void removeLast(Node sentinel) {
        if (Objects.isNull(sentinel.fetchLink().fetchLink())) sentinel.linkNext(null);

            // recursively call this method is the next link's next link is not null
        else removeLast(sentinel.fetchLink());
    }

    /**
     * This method <b>removes the first element</b> in the list
     * Note that this method only overwrites the head node with it's
     * immediate next link
     */
    public void removeFirst() {
        if (!isEmpty()) {
            head = head.fetchLink();
            --size;
            updateExtremes();
        }
    }

    /**
     * This method returns the <b>mid point </b> of an array
     *
     * @return int i.e. supposedly the mid point of the list, returns -1 if the list is empty
     */
    private int middleIndex() {
        return isEmpty() ? -1 : (int) Math.ceil(size / 2d);
    }

    /**
     * Returns the <b>middle item</b> in a list if it exists (obviously)
     *
     * @return Node class reference i.e. the middle node within the list
     */
    public Node middleItem() {
        return get(middleIndex());
    }

    /**
     * This method is an efficient implementation of reversing a linked list
     * Note that this method uses a stack to reverse the list
     *
     * @see Objects
     */
    public void reverse() {
        var stack = new Stack<Integer>();
        for (var current : this) stack.push(current);

        Node sentinel = null;
        for (var ignored : this) {
            if (Objects.isNull(sentinel)) sentinel = new Node(stack.pop());
            else append(sentinel, stack.pop());
        }
        head = sentinel;
        updateExtremes();
    }

    /**
     * This method also reverses the list but the implementation is not very
     * performant as it uses the {@code get()} and {@code append()} api
     *
     * @see Objects
     * @deprecated - as there is a better alternative
     */
    @SuppressWarnings("DeprecatedIsStillUsed")
    public void reverseDeprecated() {
        if (isEmpty()) return;

        Node sentinel = null;
        // traverse the list in reverse order and store them one by one in a sentinel node
        for (int index = size - 1; index > -1; index--) {
            if (Objects.isNull(sentinel)) sentinel = new Node(get(index).data());
            else append(sentinel, get(index).data());
        }
        head = sentinel;
    }

    /**
     * This method returns a specific node i.e. mentioned by the index
     * @param index is the index whose value needs to be returned
     * @return Node class which IS the item that is placed at the {@code index} pos
     */
    public Node get(int index) {
        if (index < 0 || isEmpty()) return null;    // if the index is invalid then return null

        // else pass it on to the helper method for traversal
        return get(head, index, 0);
    }

    /**
     * This method is a helper method that will travel through the list upto
     * {@code index} point recursively
     * @param index is the position where the recursive calls will stop
     * @param sentinel is the reference to be traversed
     * @param count is the decreasing part of the recursive call. It basically, signifies
     *              the current item
     * @return Node class reference
     * */
    private Node get(Node sentinel, int index, int count) {
        if (index == count) return sentinel;
        else return get(sentinel.fetchLink(), index, ++count);
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (var current : this) action.accept(current);
    }

    /**
     * A convenient method that can be quickly be used with enhanced for
     * and while loops directly
     * @return Iterator<Integer> object
     * @see Iterable
     * */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int count = size;
            Node sentinel = head;

            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Integer next() {
                if (count-- == size) return sentinel.data();
                return (sentinel = sentinel.fetchLink()).data();
            }
        };
    }

    /**
     * Overrides the {@code toString()} from the {@code Object} superclass and returns
     * all the elements inside the list separated by commas and enclosed by square
     * brackets
     * @return String - i.e. the string representation of this list
     * */
    @Override
    public String toString() {
        if (size == 0) return "[]";
        var builder = new StringBuilder("[");
        for (var current : this) builder.append(current).append(", ");

        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }
}
