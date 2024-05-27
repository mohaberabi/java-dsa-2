import java.util.HashMap;

public class DiameterOfBinaryTree {


    int diameterNaive(Node root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        int di = 1 + left + right;


        return Math.max(di, Math.max(diameterNaive(root.left), diameterNaive(root.right)));
    }


    int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
