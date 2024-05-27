import java.util.HashMap;

public class DiameterOfBinaryTreeBetterSolution {

    private final HashMap<Node, Integer> map = new HashMap<>();

    int diameter(Node root) {
        buildHeights(root);
        int diamater = diameterRec(root);
        return diamater;
    }

    private void buildHeights(Node root) {
        if (root == null) {
            return;
        }
        map.put(root, height(root));
        buildHeights(root.left);
        buildHeights(root.right);
    }


    private int diameterRec(Node root) {
        if (root == null) {
            return 0;
        }
        int d2 = diameterRec(root.left);
        int d3 = diameterRec(root.right);
        int d = 1 + map.get(root.right) + map.get(root.left);
        return Math.max(d, Math.max(d2, d3));
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
