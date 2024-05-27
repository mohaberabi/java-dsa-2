import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {


    int maxWidth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            res = Math.max(res, size);
            for (int i = 0; i < size; i++) {


                Node curr = q.poll();

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }

            }
        }
        return res;
    }
}
