package company.rajat;

/**
 * Created by Rajat Kanti Biswas
 * Do not modify w/o dev's permission.
 * Dated: 21-07-2020
 */
public class StackDS {
    private final int MAX_STACK_VALUE;
    private final int []stack;
    private int top;

    public StackDS(int MAX_STACK_VALUE) {
        this.MAX_STACK_VALUE = MAX_STACK_VALUE;
        stack = new int[MAX_STACK_VALUE];
        top = -1;
    }

    public int getTop() {
        return top;
    }

    public void push(int data) {
        if (top == -1) {
            top = 0;
            stack[top] = data;
            System.out.println(data + " has been pushed into stack.");
        } else {
            if (top == MAX_STACK_VALUE - 1) {
                System.out.println("Stack is full!");
            } else {
                stack[++top] = data;
                System.out.println(data + " has been pushed into stack.");
            }
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println(stack[top] + " has been popped from the stack.");
            --top;
        }
    }

    public void traverse() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Elements of the stack are as follows:-");
            for (int i = 0; i <= top; i++) {
                System.out.println(stack[i]);
            }
        }
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top != -1;
    }
}
