package sessions.data_structures;

import java.util.Iterator;

public interface DoublyIterator extends Iterator<Node> {
    Node previous();
    boolean hasPrevious();
}
