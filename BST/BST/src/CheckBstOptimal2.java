public class CheckBstOptimal2 {


    int prev = Integer.MIN_VALUE;


    boolean isBst(Node root) {
        if (root == null) {
            return true;
        }


        if (isBst(root.left) == false) {
            return false;
        }
        if (root.data <= prev) {
            return false;
        }
        prev = root.data;
        return isBst(root.right);
    }

}
