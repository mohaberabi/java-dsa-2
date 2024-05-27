import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfBinaryTree {


    int maxOfBinaryTreeIterative(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }


        int res = Integer.MIN_VALUE;


        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();

            res = Math.max(res, curr.data);

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }

        }
        return res;
    }

    int maxOfBinaryTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data,
                Math.max(maxOfBinaryTree(root.left),
                        maxOfBinaryTree(root.right)));

    }
}
