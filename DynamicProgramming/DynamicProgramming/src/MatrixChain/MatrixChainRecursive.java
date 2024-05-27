package MatrixChain;

public class MatrixChainRecursive {


    int minChain(int[] arr, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }


        int res = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {

            int first = minChain(arr, i, k);

            int second = minChain(arr, k, j);
            int mul = arr[i] * arr[j] * arr[k];


            res = Math.min(res, first + second + mul);
        }
        return res;
    }


}
