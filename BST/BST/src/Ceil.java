public class Ceil {


    Node ceil(Node root, int x) {


        Node ceil = null;
        while (root != null) {
            if (root.data == x) {
                return root;
            } else if (root.data < x) {
                root = root.right;
            } else {
                ceil = root;
                root = root.left;
            }
        }
        return ceil;
    }
}
