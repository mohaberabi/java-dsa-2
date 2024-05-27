public class Insert {


    Node insertIterative(Node root, int x) {


        Node added = new Node(x);


        if (root == null) {
            return added;
        }


        Node curr = root;
        Node parent = null;
        while (curr != null) {

            parent = curr;
            if (curr.data < x) {
                curr = curr.right;
            } else if (curr.data > x) {
                curr = curr.left;
            } else {
                return root;
            }
        }
        if (parent == null) {
            return added;
        } else if (parent.data < x) {
            parent.right = added;
        } else {
            parent.left = added;
        }

        return root;
    }

    Node insertRec(Node root, int x) {
        if (root == null) {
            return new Node(x);
        }
        if (x > root.data) {
            root.right = insertRec(root.right, x);
        } else if (x < root.data) {
            root.left = insertRec(root.left, x);

        }
        return root;
    }
}
