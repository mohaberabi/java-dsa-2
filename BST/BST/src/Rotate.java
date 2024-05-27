public class Rotate {


    Node rightRotate(Node y) {
        if (y == null) {
            return null;
        }
        Node x = y.left;

        Node z = x.right;


        x.right = y;
        y.left = z;

        return x;
    }


    Node leftRotate(Node y) {
        if (y == null) {
            return null;
        }
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        return x;
    }
}
