public class CheckBSTNaive {


    static int getMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
    }

    static int getMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.data, Math.min(getMin(root.left), getMin(root.right)));
    }


    static boolean isBSTNaive(Node root) {
        if (root == null) {
            return true;
        }
        int max = getMax(root.left);
        int min = getMin(root.right);
        boolean rootCond = root.data > max && root.data < min;
        return rootCond && isBSTNaive(root.left) &&
                isBSTNaive(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        Node rightSubTree = new Node(30);
        rightSubTree.left = new Node(29);
        rightSubTree.right = new Node(35);
        root.right = rightSubTree;
        boolean ans = isBSTNaive(root);
        System.out.println(ans);
    }
}
