public class Search {


    boolean searchIterative(Node root, int x) {

        if (root == null) {
            return false;
        }


        Node curr = root;


        while (curr != null) {
            if (curr.data == x) {
                return true;
            } else if (x > curr.data) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }


        return false;
    }

    boolean searchRec(Node root, int x) {
        if (root == null) {
            return false;
        } else if (root.data == x) {
            return true;
        } else if (x > root.data) {
            return searchRec(root.right, x);
        } else {
            return searchRec(root.left, x);

        }
    }
}
