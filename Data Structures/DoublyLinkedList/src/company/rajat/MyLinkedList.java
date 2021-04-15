package company.rajat;

/**
 * Created by Rajat Kanti Biswas
 * Do not modify w/o dev's permission.
 * Creation date: 26-07-2020
 * Updated on: 27-07-2020
 * Added: More details to list methods eg: push(), pop(), etc,
 *        added removeFromLast(), next(),
 *        previous(), compareTo()
 */
public class MyLinkedList implements MyList {
    private MyNode head;

    public MyLinkedList() {
        head = null;
    }

    @Override
    public void push(int data) {
        if (isEmpty()) {
            head = new MyNode(data);
            System.out.println("First data: " + data + " has been pushed.");
        } else {
            MyNode node = new MyNode(data);
            if (compareTo(node)) {
                System.out.println("Denied: Duplicate data are not allowed.");
            } else {
                node.next = head;
                head.previous = node;
                head = node;
                System.out.println(data + " has been pushed.");
            }
        }
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            System.out.println("Couldn't pop data. Reason: List is empty.");
        } else {
            if (head.next == null) {
                System.out.println("Last data: " + head.data + " has been popped from the list.");
            } else {
                System.out.println(head.data + " has been popped from the list.");
            }

            head = head.next;
        }
    }

    @Override
    public void append(int data) {
        if (isEmpty()) {
            head = new MyNode(data);
            System.out.println("First data: " + data + " has been appended to the list.");
        } else {
            MyNode node = new MyNode(data);
            if (compareTo(node)) {
                System.out.println("Denied: Duplicate data are not allowed.");
            } else {
                MyNode tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }

                node.previous = tail;
                tail.next = node;
                System.out.println(data + " has been appended to the list.");
            }
        }
    }

    @Override
    public void removeFromLast() {
        if (isEmpty()) {
            System.out.println("Couldn't remove. Reason: List is empty.");
        } else {
            MyNode tail = head;
            while (tail.next.next != null) {
                tail = tail.next;
            }

            System.out.println(tail.next.data + " has been removed from the list.");
            tail.next = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void next() {
        if (isEmpty()) {
            System.out.println("Couldn't perform action. Reason: List is empty.");
        } else {
            head = head.next;
            System.out.println(toString());
            System.out.println("\nMade next node as new head.");
        }
    }

    @Override
    public void previous() {
        if (isEmpty()) {
            System.out.println("Couldn't perform action. Reason: List is empty.");
        } else {
            head = head.previous;
            System.out.println(toString());
            System.out.println("\nMade previous node as new head.");
        }
    }

    private boolean compareTo(MyNode node) {
        MyNode tempNode = head;

        while (tempNode != null) {
            if (tempNode.data == node.data) {
                return true;
            }

            tempNode = tempNode.next;
        }

        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty.";
        } else {
            String listElement = "Elements of the list are:-\n" +
                                 "Index number   Element value\n";
            MyNode node = head;

            boolean flag = false;
            int nCount = 0;
            while (node != null) {
                if (!flag) {
                    listElement = listElement.concat(nCount + "              " + node.data + " -> Head\n");
                    flag = true;
                } else {
                    listElement = listElement.concat(nCount + "              " + node.data + "\n");
                }

                node = node.next;
                ++nCount;
            }

            return listElement;
        }
    }
}
