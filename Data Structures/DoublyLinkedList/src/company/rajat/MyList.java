package company.rajat;

public interface MyList {
    void push(int data);
    void pop();
    void append(int data);
    void removeFromLast();
    boolean isEmpty();
    void next();
    void previous();
    String toString();

    class MyNode {
        MyNode next;
        MyNode previous;
        int data;

        public MyNode(int data) {
            next = null;
            previous = null;
            this.data = data;
        }
    }
}
