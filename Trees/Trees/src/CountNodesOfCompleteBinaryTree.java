public class CountNodesOfCompleteBinaryTree {


    int nodesNaive(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + nodesNaive(root.left) + nodesNaive(root.right);
    }


    int nodesInCompleteBinaryTreeOptimal(Node root) {


        int leftHeight = 0;
        int rightHegiht = 0;


        Node curr = root;
        while (curr != null) {
            leftHeight++;
            curr = curr.left;
        }
        curr = root;

        while (curr != null) {
            rightHegiht++;
            curr = curr.right;
        }

        if (leftHeight == rightHegiht) {
            return (int) Math.pow(2, leftHeight) - 1;
        } else {
            return 1 + nodesInCompleteBinaryTreeOptimal(root.left) +
                    nodesInCompleteBinaryTreeOptimal(root.right);
            // or just call the above method count naive ;
        }
    }
}
