public class BurnTreeFromLeaft {


    private class Distance {
        int val;

        public Distance(int v) {
            val = v;
        }
    }


    int res = 0;


    int burnTime(Node root, int leaf, Distance dist) {
        if (root == null) {
            return 0;
        }

        if (root.data == leaf) {
            dist.val = 0;
            return 1;
        }
        Distance leftDistance = new Distance(-1);
        Distance rightDistance = new Distance(-1);
        int leftHeight = burnTime(root.left, leaf, dist);
        int rightHeight = burnTime(root.right, leaf, dist);
        if (leftDistance.val != -1) {
            dist.val = leftDistance.val + 1;
            res = Math.max(res, rightHeight + dist.val);
        } else if (rightDistance.val != -1) {
            dist.val = rightDistance.val + 1;
            res = Math.max(res, leftHeight + dist.val);
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
