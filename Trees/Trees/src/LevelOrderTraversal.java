import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {


    static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }


        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.println(curr.data);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }
}
