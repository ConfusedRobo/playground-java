package company.rajat;

/**
 * Created by Rajat Kanti Biswas
 * Do not modify w/o dev's permission.
 * Dated: 27-07-2020
 */
public class CircularQueue {
    private int front;
    private int rear;
    private final int arrayLimit;
    private final int []queue;

    public CircularQueue(int arrayLimit) {
        this.front = -1;
        this.rear = -1;
        this.arrayLimit = arrayLimit;
        queue = new int[arrayLimit];
    }

    public void enQueue(int data) {
        if (rear == arrayLimit - 1) {
            System.out.println("Couldn't insert " + data + " Reason: Queue is full");
        } else {
            if (rear == -1) {
                front = 0;
                queue[++rear] = data;
                System.out.println("First data: " + data + " has been en-queued.");
            } else {
                queue[++rear] = data;
                System.out.println(data + " en-queued.");
            }
        }
    }

    public void deQueue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty.");
        } else {
            if (rear >= 0) {
                if (rear > 0) {
                    System.out.println(queue[front] + " de-queued.");
                } else {
                    System.out.println("Last element: " + queue[front] + " has been de-queued.");
                }
                System.arraycopy(queue, 1, queue, 0, rear);
            }

            --rear;
            if (rear == -1) {
                front = -1;
            }
        }
    }

    @Override
    public String toString() {
        String queueElements = "Elements of the queue are:-\n";

        if (isEmpty()) {
            return "Queue is empty.";
        } else {
            for (int i = front; i <= rear; i++) {
                queueElements = queueElements.concat(queue[i] + "\n");
            }

            return queueElements;
        }
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }
}