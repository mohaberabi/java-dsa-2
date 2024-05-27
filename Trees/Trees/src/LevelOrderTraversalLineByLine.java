import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {


    static void lineByLineMethod2(Node root) {
        if (root == null) {
            return;
        }


        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                Node curr = q.poll();
                System.out.println(curr.data);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }

    void lineByLineMethod1(Node root) {
        if (root == null) {
            return;
        }


        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (q.size() > 1) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                q.add(null);
                continue;
            }

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
