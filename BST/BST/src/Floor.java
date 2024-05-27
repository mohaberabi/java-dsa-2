public class Floor {

    Node floor(Node root, int x) {


        Node floor = null;

        while (root != null) {

            if (root.data == x) {
                return root;
            } else if (root.data > x) {
                root = root.left;
            } else {
                floor = root;
                root = root.right;
            }
        }
        return floor;
    }
}
