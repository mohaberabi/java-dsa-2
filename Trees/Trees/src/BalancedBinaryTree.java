public class BalancedBinaryTree {


    int isBalancedOptimal(Node root) {
        if (root == null) {
            return 0;
        }


        int left = isBalancedOptimal(root.left);
        if (left == -1) {
            return -1;
        }

        int right = isBalancedOptimal(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }

    }

    boolean isBalancedNaive(Node root) {
        if (root == null) {
            return true;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);

        return Math.abs(leftH - rightH) <= 1
                && isBalancedNaive(root.left)
                && isBalancedNaive(root.right);
    }

    int height(Node root) {
        if (root == null) {
            return 0;
        }


        return 1 + Math.max(height(root.left), height(root.right));

    }
}
