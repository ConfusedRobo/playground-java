package datastructures.tree;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
        integerBinaryTree.insert(12, 5);
        integerBinaryTree.insert(13, 1);
        integerBinaryTree.insert(11,5);
        integerBinaryTree.insert(12, 5);
        integerBinaryTree.insert(13, 1);
        integerBinaryTree.insert(11,5);
        integerBinaryTree.insert(12, 5);
        integerBinaryTree.insert(13, 1);
        integerBinaryTree.insert(11,5);

        integerBinaryTree.traverseInOrdered();
        integerBinaryTree.traversePreOrdered();
        integerBinaryTree.traversePostOrdered();
    }
}
