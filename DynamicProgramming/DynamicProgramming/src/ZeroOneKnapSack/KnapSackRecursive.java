package ZeroOneKnapSack;

public class KnapSackRecursive {


    int knapSack(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] > W) {
            return knapSack(wt, val, W, n - 1);
        }

        int notInclude = knapSack(wt, val, W, n - 1);
        int include = val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1);
        return Math.max(notInclude, include);
    }
}
