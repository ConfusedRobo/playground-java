package sessions.data_structures;

import java.util.Iterator;

public class SinglyCircularLinkedList implements Iterable<Node> {

    private Node head;
    private Node current;
    private int size = 0;

    public int size() {
        return size;
    }

    public Node peek() {
        return head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int data) {
        if (isEmpty()) {
            current = new Node(data);
            head = current;
            head.linkNext(head);
        } else {
            var dummy = new Node(data);
            dummy.linkNext(head);

            current.linkNext(dummy);
            current = current.fetchLink();
        }

        ++size;
    }

    public void prepend(int data) {
        if (isEmpty()) append(data);
        else {
            var dummy = new Node(data);
            dummy.linkNext(head);

            head = dummy;
            current.linkNext(dummy);
            ++size;
        }
    }

    public void removeLast() {
        current.linkNext(head.fetchLink());
        --size;
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<>() {
            int count = 0;
            Node sentinel = head;

            @Override
            public boolean hasNext() {
                return count > -1;
            }

            @Override
            public Node next() {
                if (count++ == 0) return sentinel;
                return sentinel = sentinel.fetchLink();
            }
        };
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        var builder = new StringBuilder("[");

        var count = 0;
        for (var current : this) {
            if (count++ == size) break;
            builder.append(current.data()).append(", ");
        }

        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }
}
