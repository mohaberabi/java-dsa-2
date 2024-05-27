import java.util.Stack;

public class IterativeTraversals {


    void iterativePreOrderSpaceOptimized(Node root) {

        if (root == null) {
            return;
        }


        Stack<Node> s = new Stack<>();

        s.push(root);
        Node curr = root;
        while (!s.isEmpty() || s.isEmpty() == false) {

            while (curr != null) {

                System.out.println(curr.data);
                if (curr.right != null) {
                    s.push(curr.right);
                }
                curr = curr.left;
            }
            if (!s.isEmpty()) {
                curr = s.pop();

            }
        }
    }

    void iterativePreOrder(Node root) {

        if (root == null) {
            return;
        }

        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node curr = s.pop();
            System.out.println(curr.data);

            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
        }
    }

    void iterativeInOrder(Node root) {
        if (root == null) {
            return;
        }


        Stack<Node> s = new Stack<>();
        Node curr = root;
        while (!s.isEmpty() || curr != null) {

            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            System.out.println(curr.data);
            curr = curr.right;
        }
    }

}
