public class Delete {


    Node inOrderSusccuser(Node root) {

        /// get the closest  greater value .
        // to get the closest greater intitalliy anyway go to right
        // we are sue it is not null
        // then to get the closestht to to left unitl not null
        // return this to the delete
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    Node delete(Node root, int x) {
        if (root == null) {
            return null;
        }


        // go to left
        if (root.data > x) {
            root.left = delete(root.left, x);
        } else if (root.data < x) {

            // go to right
            root.right = delete(root.right, x);
        } else {
// now x= root .data;
            if (root.left == null) {
                // if it has only one child at right
                // simply return this child
                return root.right;
            } else if (root.right == null) {
                // vise versa
                return root.left;
            } else {
                // now it has both not null
                // get the succssor
                Node succ = inOrderSusccuser(root);
                //swap root with succuuser .data
                root.data = succ.data;
                // now since it is succsoor so it's greater means
                // it's in right //
                //recall the function again on right subtree
                root.right = delete(root.right, succ.data);
            }
        }
        return root;
    }


}
