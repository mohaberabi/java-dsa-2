public class MaxPathSum {
    static class Result {
        int maxSum;

        public Result() {
            this.maxSum = Integer.MIN_VALUE;
        }
    }

    static public int maxPathSum(Node root) {
        Result result = new Result();
        maxPathSumHelper(root, result);
        return result.maxSum;
    }

    static private int maxPathSumHelper(Node node, Result result) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(maxPathSumHelper(node.left, result), 0);
        int rightSum = Math.max(maxPathSumHelper(node.right, result), 0);

        int currentMaxSum = leftSum + rightSum + node.data;
        result.maxSum = Math.max(result.maxSum, currentMaxSum);

        return Math.max(leftSum, rightSum) + node.data;
    }


    public static void main(String[] args) {
        Node root = new Node(10);
        Node left = new Node(2);
        left.left = new Node(20);
        left.right = new Node(1);
        Node right = new Node(-25);
        right.left = new Node(3);
        right.right = new Node(4);
        root.left = left;
        root.right = right;
        int maxPath = maxPathSum(root);
        System.out.println(maxPath);
    }
}
