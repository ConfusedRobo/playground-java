package sessions.concurrency;

import java.util.Iterator;

public interface DoublyIterator extends Iterator<Node> {
    Node previous();
    boolean hasPrevious();
}
