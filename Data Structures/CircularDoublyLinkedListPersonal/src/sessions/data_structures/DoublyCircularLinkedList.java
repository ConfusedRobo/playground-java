package sessions.data_structures;

public class DoublyCircularLinkedList implements Iterable<Node>, Comparable<Integer> {

    private Node head;
    private Node current;

    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node peek() {
        return head;
    }

    public void append(int data) {
        if (isEmpty()) {
            current = new Node(data);
            head = current;

            head.linkNext(head);
            head.linkPrevious(head);
        } else {
            var dummy = new Node(data);
            dummy.linkNext(head);
            dummy.linkPrevious(current);

            current.linkNext(dummy);
            head.linkPrevious(dummy);

            current = current.fetchNext();
        }
        ++size;
    }

    public void prepend(int data) {
        if (isEmpty()) append(data);
        else {
            var dummy = new Node(data);
            dummy.linkNext(head);
            dummy.linkPrevious(current);

            current.linkNext(dummy);
            head.linkPrevious(dummy);

            head = head.fetchPrevious();
            ++size;
        }
    }

    public void merge(DoublyCircularLinkedList list) {
        list.head.linkPrevious(current);
        list.current.linkNext(head);

        head.linkPrevious(list.current);
        current.linkNext(list.head);
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }

    @Override
    public DoublyIterator iterator() {
        return new DoublyIterator() {
            Node sentinel = head;

            @Override
            public Node previous() {
                return sentinel = sentinel.fetchPrevious();
            }

            @Override
            public boolean hasPrevious() {
                return true;
            }

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Node next() {
                return sentinel = sentinel.fetchNext();
            }
        };
    }
}
