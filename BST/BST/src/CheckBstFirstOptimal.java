public class CheckBstFirstOptimal {


    static boolean isBstOptimal(Node root) {


        return isBstOptimalUtl(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    static boolean isBstOptimalUtl(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }

        return isBstOptimalUtl(root.left, min, root.data) &&
                isBstOptimalUtl(root.right, root.data, max);

    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        Node rightSubTree = new Node(30);
        rightSubTree.left = new Node(29);
        rightSubTree.right = new Node(35);
        root.right = rightSubTree;
        boolean ans = isBstOptimal(root);
        System.out.println(ans);
    }
}
