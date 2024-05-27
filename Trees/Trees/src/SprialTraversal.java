import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SprialTraversal {


    void spiralTraversalOptimal(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {

            while (!s1.isEmpty()) {
                Node curr = s1.pop();
                System.out.println(curr.data);
                if (curr.left != null) {
                    s2.push(curr.left);
                }
                if (curr.right != null) {
                    s2.push(curr.right);
                }
            }

            while (!s2.isEmpty()) {
                Node curr = s2.pop();
                System.out.println(curr.data);

                if (curr.right != null) {
                    s1.push(curr.right);
                }
                if (curr.left != null) {
                    s1.push(curr.left);
                }
            }
        }
    }

    void sprialTraversal(Node root) {


        if (root == null) {
            return;
        }


        Queue<Node> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.add(root);
        boolean reverse = false;
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node curr = q.poll();

                if (reverse) {
                    s.push(curr.data);
                } else {
                    System.out.println(curr.data);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (reverse) {
                while (!s.isEmpty()) {
                    int pop = s.pop();
                    System.out.println(pop);
                }
            }
            reverse = !reverse;

        }


    }
}
