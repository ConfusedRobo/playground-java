package company.rajat;

/**
 * Created by Rajat Kanti Biswas
 * Do not modify w/o dev's permission.
 * Dated: 22-07-2020
 */
public class Stack {
    private MyNode top;

    Stack() {
        top = null;
    }

    public static class MyNode {
        final int data;
        MyNode next;

        public MyNode(int data) {
            this.data = data;
            next = null;
        }
    }

    public void push(int data) {
        if (top == null) {
            top = new MyNode(data);
        } else {
            MyNode node = new MyNode(data);

            node.next = top;
            top = node;
        }

        System.out.println(data + " pushed into stack.");
    }

    public void pop() {
        if (top == null) {
            System.out.println("Unable to pop. Stack is empty.");
        } else {
            System.out.println(top.data + " popped from stack.");
            top = top.next;
        }
    }

    public void traverse() {
        MyNode node = top;
        boolean flag = false;

        System.out.println("Stack elements:-");
        while (node != null) {
            if (!flag) {
                System.out.println(node.data + " - Top");
                flag = true;
            } else {
                System.out.println(node.data);
            }

            node = node.next;
        }
    }

    public int peek() {
        return top.data;
    }

    public boolean isEmpty() {
        return top != null;
    }
}
