package sessions.concurrency;

import java.util.Objects;
import java.util.Stack;

public class DoublyLinkedList implements Iterable<Node> {

    private Node head;
    private int size = 0;

    private Node first = null;
    private Node last = null;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Node peekFirst() {
        return first;
    }

    public Node peekLast() {
        return last;
    }

    private int peekMiddle() {
        return isEmpty() ? -1 : (int) Math.ceil(size / 2d);
    }

    public Node middleItem() {
        return get(peekMiddle());
    }

    private void updateExtremes() {
        if (isEmpty()) return;
        first = head;

        var sentinel = head;
        while (Objects.nonNull(sentinel.fetchNext())) sentinel = sentinel.fetchNext();
        last = sentinel;
    }

    public void append(int data) {
        if (isEmpty()) head = new Node(data);
        else append(head, data);

        ++size;
        updateExtremes();
    }

    private void append(Node sentinel, int data) {
        if (Objects.isNull(sentinel.fetchNext())) {
            sentinel.linkNext(new Node(data));
            sentinel.fetchNext().linkPrevious(sentinel);
        } else append(sentinel.fetchNext(), data);
    }

    public void prepend(int data) {
        if (isEmpty()) append(data);
        else {
            head.linkPrevious(new Node(data));
            head.fetchPrevious().linkNext(head);
            head = head.fetchPrevious();
            ++size;
        }

        updateExtremes();
    }

    public Node get(int index) {
        if (index < 0 || isEmpty()) return null;
        return get(head, index, 0);
    }

    private Node get(Node sentinel, int index, int count) {
        if (index == count) return sentinel;
        else return get(sentinel.fetchNext(), index, ++count);
    }

    public void reverse() {
        var stack = new Stack<Node>();
        for (var current : this) stack.push(current);

        Node sentinel = null;
        for (var ignored : this) {
            if (Objects.isNull(sentinel)) sentinel = new Node(stack.pop().data());
            else append(sentinel, stack.pop().data());
        }

        head = sentinel;
        updateExtremes();
    }

    public void delete(int position) {
        if (position >= size || position < 0) return;
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

            if (count++ == position - 1) {
                --size;
                sentinel.linkNext(get(position + 1));
                sentinel.fetchNext().linkPrevious(sentinel);
                break;
            }

            sentinel = sentinel.fetchNext();
        }
    }

    public void removeLast() {
        if (size == 1) {
            head = null;
            size = 0;
        } else if (size > 1) {
            removeLast(head);
            --size;
        }
        updateExtremes();
    }

    private void removeLast(Node sentinel) {
        if (Objects.isNull(sentinel.fetchNext().fetchNext())) sentinel.linkNext(null);
        else removeLast(sentinel.fetchNext());
    }

    public void removeFirst() {
        if (!isEmpty()) {
            head.fetchNext().linkPrevious(null);
            head = head.fetchNext();

            --size;
            updateExtremes();
        }
    }

    @Override
    public DoublyIterator iterator() {
        return new DoublyIterator() {
            Node sentinel = head;
            int count = 0;

            @Override
            public Node previous() {
                if (count-- == size) return sentinel;
                return sentinel = sentinel.fetchPrevious();
            }

            @Override
            public boolean hasPrevious() {
                return count > 0;
            }

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public Node next() {
                if (count++ == 0) return sentinel;
                return sentinel = sentinel.fetchNext();
            }
        };
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        var builder = new StringBuilder("[");
        for (var current : this) builder.append(current.data()).append(", ");

        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }
}
