package sessions.data_structures;

import java.util.Objects;

public class BinaryTreeEasy {

    private Node root;

    public boolean isEmpty() {
        return Objects.isNull(root);
    }

    public void insert(int data) {
        if (isEmpty()) root = new Node(data);
        else root = insert(root, data);
    }

    private Node insert(Node sentinel, int data) {
        if (Objects.isNull(sentinel)) sentinel = new Node(data);
        else if (data <= sentinel.data()) sentinel.linkLeft(insert(sentinel.fetchLeft(), data));
        else sentinel.linkRight(insert(sentinel.fetchRight(), data));

        return sentinel;
    }

    public void preorder() {
        if (isEmpty()) System.out.println("List is empty!");
        else preorder(root);
    }

    private void preorder(Node sentinel) {
        if (Objects.nonNull(sentinel)) {
            System.out.print(sentinel.data() + " ");
            preorder(sentinel.fetchLeft());
            preorder(sentinel.fetchRight());
        }
    }

    public void inorder() {
        if (isEmpty()) System.out.println("List is empty!");
        else inorder(root);
    }

    private void inorder(Node sentinel) {
        if (Objects.nonNull(sentinel)) {
            inorder(sentinel.fetchLeft());
            inorder(sentinel.fetchRight());
            System.out.print(sentinel.data() + " ");
        }
    }

    public void postorder() {
        if (isEmpty()) System.out.println("List is empty!");
        else postorder(root);
    }

    private void postorder(Node sentinel) {
        if (Objects.nonNull(sentinel)) {
            System.out.print(sentinel.data() + " ");
            postorder(sentinel.fetchLeft());
            postorder(sentinel.fetchRight());
        }
    }
}
