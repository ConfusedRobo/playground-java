package company.rajat;

/**
 * Created by Rajat Kanti Biswas
 * Do not modify w/o dev's permission.
 * Dated: 25-07-2020
 */
public class QueueLinked {
    private MyNode front;
    private MyNode rear;

    public QueueLinked() {
        front = null;
        rear = null;
    }

    public MyNode getFront() {
        return front;
    }

    public MyNode getRear() {
        return rear;
    }

    static class MyNode {
        int data;
        MyNode next;

        public MyNode(int data) {
            this.data = data;
            next = null;
        }
    }

    public void enQueue(int data) {
        MyNode node = new MyNode(data);

        if (rear == null) {
            front = node; //also can be written as front = rear = node
            rear = node;
            System.out.println("First data " + data + " has been en-queued.");
        } else {
            rear.next = node;
            rear = node;
            System.out.println("Data " + data + " has been entered.");
        }
    }

    public void deQueue() {
        if (front == null) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Data " + front.data + " has been de-queued.");
            front = front.next;

            if (front == null) {
                rear = null;
            }
        }
    }

    @Override
    public String toString() {
        String queue = "";

        if (front == null && rear == null) {
            return "Unable to traverse. Reason: Queue has no data.";
        } else {
            MyNode nodeIterator = front;

            System.out.println("Elements of the queue is/are:-");
            while (nodeIterator != null) {
                queue = queue.concat(nodeIterator.data + "\n");
                nodeIterator = nodeIterator.next;
            }

            return queue;
        }
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }
}
