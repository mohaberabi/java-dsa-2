package LIS;

public class MinimumDeletesToMakeSorted {


    static int ceil(int[] tail, int low, int high, int x) {


        while (low < high) {
            int mid = (low + high) / 2;
            if (tail[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }
        return high;
    }


    static int minimumDeletesToMakeArraySorted(int[] arr) {
        int n = arr.length;
        int lis = lis(arr);
        return n - lis;
    }

    static int lis(int[] arr) {
        int n = arr.length;
        int[] tail = new int[n];
        tail[0] = arr[0];

        int len = 1;


        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len - 1]) {
                tail[len] = arr[i];
                len++;
            } else {
                int c = ceil(tail, 0, len - 1, arr[i]);
                tail[c] = arr[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 3, 6, 7, 8};

        int min = minimumDeletesToMakeArraySorted(arr);
        System.out.println(min);

    }
}
