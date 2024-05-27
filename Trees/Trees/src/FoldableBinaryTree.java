public class FoldableBinaryTree {


    boolean foldable(Node root) {
        if (root == null) {
            return true;
        }

        return foldableUtil(root.left, root.right);
    }

    boolean foldableUtil(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }


        return foldableUtil(left.left, right.right) &&
                foldableUtil(left.right, right.left);
    }
}
