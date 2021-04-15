package sessions.data_structures;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var list = new SinglyCircularLinkedList();
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);

        list.prepend(233);
        list.prepend(344);

         for (Node node : list) {
             out.println(node);
             Thread.sleep(400);
         }

        out.println(list);
        out.println(list.size());
        out.println(list.peek());
    }
}
