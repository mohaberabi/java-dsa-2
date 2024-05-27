public class MaxSumOfNonAdjacent {


    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static Pair maxSumHelper(Node root) {
        if (root == null) {
            Pair sum = new Pair(0, 0);
            return sum;
        }

        Pair sum1 = maxSumHelper(root.left);
        Pair sum2 = maxSumHelper(root.right);
        Pair sum = new Pair(0, 0);

        sum.first = sum1.second + sum2.second + root.data;

        sum.second = Math.max(sum1.first, sum1.second) +
                Math.max(sum2.first, sum2.second);

        return sum;
    }

}
