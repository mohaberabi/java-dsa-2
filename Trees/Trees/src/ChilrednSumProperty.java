public class ChilrednSumProperty {


    boolean isChildEqualParent(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null & root.right == null) {
            return true;
        }


        int sum = 0;
        if (root.right != null) {
            sum += root.right.data;
        }

        if (root.left != null) {
            sum += root.left.data;
        }

        return sum == root.data &&
                isChildEqualParent(root.left) &&
                isChildEqualParent(root.right);
    }
}
