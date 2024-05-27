package AllocateMinimumPages;

public class AlloocateMinPagesRecursive {


    int minPages(int[] arr, int n, int k) {
        if (k == 1) {
            return sum(arr, 0, n - 1);
        }
        if (n == 1) {
            return arr[0];
        }


        int res = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {

            int sum = sum(arr, i, n - 1);
            int pages = minPages(arr, i, k - 1);

            res = Math.min(res, Math.max(sum, pages));
        }
        return res;
    }


    int sum(int[] arr, int s, int e) {

        int total = 0;
        for (int i = s; i <= e; i++) {
            total += arr[i];
        }
        return total;
    }
}
