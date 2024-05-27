public class IsBstOptimal {


    int prev = Integer.MIN_VALUE;

    boolean isBstOptimal(Node root) {
        if (root == null) {
            return true;
        }
        boolean left = isBstOptimal(root.left);
        if (!left) {
            return false;
        }
        if (root.data <= prev) {

            return false;
        }
        prev = root.data;

        return isBstOptimal(root.right);
    }
}
