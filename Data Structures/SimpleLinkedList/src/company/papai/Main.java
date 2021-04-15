package company.papai;

public class Main {
    Node head;

    public static void main(String[] args) {
        Main list = new Main();

        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        list.head.next = second;
        second.next = third;

//        list.head.next = second;
//        list.head.next.next = third;

//        System.out.println("Head: " + list.head.data);
//        System.out.println("Second: " + list.head.next.data);
//        System.out.println("Third: " + list.head.next.next.data);

//        System.out.println("Head: " + list.head.data);
//        System.out.println("Second: " + second.data);
//        System.out.println("Third: " + third.data);

        list.printList();
    }

    private void printList() {
        Node node = head;

        System.out.println("Elements of the linked list are as follows:-");
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
