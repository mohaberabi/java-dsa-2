import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

public class ConstructBinaryTreeFromParentArray {


    static Node fromArray(int[] arr, int n) {


        if (n == 0) {
            return null;
        }

        if (n == 1) {
            return new Node(0);
        }
        int index = 0;
        Node root = new Node(index);

        Queue<Node> q = new LinkedList<>();

        index++;
        q.add(root);
        while (index <= n - 1) {
            Node parent = q.poll();

            Node left = new Node(index);

            parent.left = left;
            q.add(left);
            index++;

            Node right = new Node(index);
            parent.right = right;
            q.add(right);
            index++;

        }
        return root;
    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 3,};

        Node root = fromArray(parent, parent.length);


        LevelOrderTraversal.levelOrderTraversal(root);
    }

}
