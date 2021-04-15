package datastructures.tree;

import java.util.Objects;

public class BinaryTree<T> {
    private Node<T> root;

    public boolean isEmpty() {
        return Objects.isNull(root);
    }

    public void insert(T data, int serial) {
        root = insert(root, serial, data);
    }

    private Node<T> insert(Node<T> sentinel, int newSerial, T data) {
        if (Objects.isNull(sentinel)) {
            sentinel = new Node<>(newSerial, data);
            return sentinel;
        }

        if (newSerial <= sentinel.serial()) {
            sentinel.linkLeft(insert(sentinel.getLeft(), newSerial, data));
            return sentinel;
        }

        sentinel.linkRight(insert(sentinel.getRight(), newSerial, data));
        return sentinel;
    }

    public void traverseInOrdered() {
        traverseInOrdered(root);
        System.out.println("== Inorder");
    }

    private void traverseInOrdered(Node<T> subtree) {
        if (!Objects.isNull(subtree)) {
            traverseInOrdered(subtree.getLeft());
            System.out.print(subtree.getData() + " ");
            traverseInOrdered(subtree.getRight());
        }
    }

    public void traversePreOrdered() {
        traversePreOrdered(root);
        System.out.println("== Preorder");
    }

    private void traversePreOrdered(Node<T> subtree) {
        if (Objects.nonNull(subtree)) {
            System.out.print(subtree.getData() + " ");
            traversePreOrdered(subtree.getLeft());
            traversePreOrdered(subtree.getRight());
        }
    }

    public void traversePostOrdered() {
        traversePostOrdered(root);
        System.out.println("== Postorder");
    }

    private void traversePostOrdered(Node<T> subtree) {
        if (Objects.nonNull(subtree)) {
            traversePostOrdered(subtree.getLeft());
            traversePostOrdered(subtree.getRight());
            System.out.print(subtree.getData() + " ");
        }
    }
}
