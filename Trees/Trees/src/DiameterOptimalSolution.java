public class DiameterOptimalSolution {


    int res = 0;


    int getHeightAndComputeDiameter(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getHeightAndComputeDiameter(root.left);
        int right = getHeightAndComputeDiameter(root.right);
        res = Math.max(res, 1 + left + right);
        return 1 + Math.max(left, right);
    }
}
