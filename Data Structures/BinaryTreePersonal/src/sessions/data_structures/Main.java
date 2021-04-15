package sessions.data_structures;

public class Main {

    public static void main(String[] args) {
        var tree = new BinaryTreeEasy();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        tree.preorder();
        System.out.println("== Preorder");
        tree.inorder();
        System.out.println("== Inorder");
        tree.postorder();
        System.out.println("== Postorder");
    }
}
