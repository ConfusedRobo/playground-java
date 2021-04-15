package sessions.concurrency;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var list = new DoublyLinkedList();
        list.prepend(23);
        list.prepend(24);
        list.prepend(35);
        list.prepend(44);
        list.prepend(67);
        list.prepend(12);

        out.println(list.peekLast());
        out.println(list.peekFirst());
        out.println("=========================================");

        var iterator = list.iterator();
        while (iterator.hasNext()) out.println(iterator.next());
        out.println("=========================================");

        while (iterator.hasPrevious()) out.println(iterator.previous());
        out.println("=========================================");

        out.println("4th element: " + list.get(0).data());
        out.println("4th element: " + list.get(list.size() - 1).data());
        out.println(list);
        out.println("=========================================");

        list.reverse();
        out.println(list);
        iterator = list.iterator();
        while (iterator.hasNext()) out.println(iterator.next());
        out.println("=========================================");

        while (iterator.hasPrevious()) out.println(iterator.previous());
        out.println("=========================================");
        out.println(list.middleItem());

        out.println(list);
        list.removeLast();
        out.println(list);
        list.removeFirst();
        out.println(list);

        iterator = list.iterator();
        while (iterator.hasNext()) out.println(iterator.next());
        out.println("=========================================");

        while (iterator.hasPrevious()) out.println(iterator.previous());
        out.println(list);
        list.delete(2);

        iterator = list.iterator();
        while (iterator.hasNext()) out.println(iterator.next());
        out.println(list);
    }
}
