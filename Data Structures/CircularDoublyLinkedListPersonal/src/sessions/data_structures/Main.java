package sessions.data_structures;

import static java.lang.System.out;

public class Main {

    @SuppressWarnings("BusyWait")
    public static void main(String[] args) throws InterruptedException {
        var listA = new DoublyCircularLinkedList();
        listA.append(2);
        listA.prepend(3);
        listA.prepend(4);
        listA.append(2);
        listA.prepend(3);
        listA.prepend(4);
        listA.append(2);
        listA.prepend(3);

        var listB = new DoublyCircularLinkedList();
        listB.append(21);
        listB.prepend(32);
        listB.prepend(43);
        listB.append(22);
        listB.prepend(30);
        listB.prepend(422);
        listB.append(245);
        listB.prepend(36);

        listA.merge(listB);
        var iterator = listA.iterator();
        while (iterator.hasPrevious()) {
            Thread.sleep(500);
            out.println(iterator.previous());
        }
    }
}
