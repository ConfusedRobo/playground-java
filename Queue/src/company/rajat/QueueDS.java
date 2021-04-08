package company.rajat;

/**
 * Created by Rajat Kanti Biswas
 * Do not modify w/o dev's permission.
 * Dated: 23-07-2020
 */
public class QueueDS {
    private final int []queue;
    private int front;
    private int rear;
    private final int queueLimit;

    QueueDS(int queueLimit) {
        queue = new int[queueLimit];
        this.queueLimit = queueLimit;
        front = -1;
        rear = -1;
    }

    public void enQueue(int data) {
        if (rear == -1) {
            front = 0;
            queue[++rear] = data;
            System.out.println(data + " has been en-queued.");
        } else {
            if (rear == queueLimit - 1) {
                System.out.println("Couldn't en-queue " + data + " as queue is already full.");
            } else {
                queue[++rear] = data;
                System.out.println(data + " has been en-queued.");
            }
        }
    }

    public void deQueue() {
        if (rear == -1) {
            System.out.println("Queue is empty.");
        } else {
            if (front > rear) {
                System.out.println("Queue is empty.");
            } else {
                System.out.println(queue[front] + " is de-queued.");
                ++front;
            }
        }
    }

    @Override
    public String toString() {
        String queueElements = "";

        if (rear == -1) {
            return "Queue is empty.";
        } else if (front > rear) {
            return "All elements of the queue have been deleted.";
        } else {
            for (int i = front; i <= rear; i++) {
                queueElements = queueElements.concat(queue[i] + "\n");
            }

            return "Current queue elements are: \n" + queueElements;
        }
    }

    public boolean isEmpty() {
        return rear != -1;
    }
}
