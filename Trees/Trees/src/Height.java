public class Height {


    int heightOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)) + 1;
    }
}
