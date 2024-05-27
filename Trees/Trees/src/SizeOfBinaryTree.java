import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree {


    int sizeIterative(Node root) {

        if (root == null) {
            return 0;
        }
        int count = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            Node curr = q.poll();

            count++;

            if (curr.left != null) {

                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }

        }


        return count;
    }

    int size(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
    }
}
