package sessions.practice;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var list = new SinglyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        out.println("Current list size: " + list.size());
        for (var current : list) out.println(current);

        out.println(list.firstItem().data());
        out.println(list.lastItem().data());

        list.removeLast();
        list.removeLast();

        out.println("==");
        out.println(list);

        list.append(31);
        list.append(22);
        list.append(45);
        list.append(88);

        out.println("==");
        list.removeFirst();
        out.println(list);

        out.println("Size: " + list.size());
        out.println("First: " + list.firstItem().data() + "\tLast: " + list.lastItem().data());

        list.prepend(234);
        out.println(list);

        out.println("Size: " + list.size());
        out.println("First: " + list.firstItem().data() + "\tLast: " + list.lastItem().data());

        list.prepend(345);
        list.prepend(400);
        list.prepend(78);
        out.println("Size: " + list.size());
        out.println(list);

        out.println("Middle element: " + list.middleItem().data());
        out.println("Last element: " + list.get(list.size() - 1).data());

        out.println("==");
        out.println("Before: " + list);

        list.reverse();
        out.println("After: " + list);

        list.reverseDeprecated();
        out.println(list);

        out.println(list.middleItem());

        list.delete(3);
        list.delete(3);
        list.delete(3);
        out.println(list);
        
        list.forEach(out::println);
    }
}
