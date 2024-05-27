package LIS;

import java.util.Arrays;

public class LongestBitonicSubSequenceUSingBinarySearch {


    static int ceil(int[] arr, int low, int high, int x) {


        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }
        return high;
    }

    static int maximumBitonicSubSequence(int[] arr) {

        int n = arr.length;
        int[] lis = lis(arr);
        int[] rev = new int[n];
        for (int i = 0; i < n; i++) {
            rev[i] = arr[n - i - 1];
        }

        int[] lds = lis(rev);

        int[] bitonic = new int[n];

        for (int i = 0; i < n; i++) {
            bitonic[i] = lis[i] + lds[n - i - 1] - 1;
        }

        int maxBitonic = bitonic[0];

        for (int i = 0; i < n; i++) {
            maxBitonic = Math.max(maxBitonic, bitonic[i]);
        }
        return maxBitonic;
    }

    static int[] lis(int[] arr) {
        int n = arr.length;
        int[] tail = new int[n];
        tail[0] = arr[0];
        int len = 1;
        int[] lisArray = new int[n];
        lisArray[0] = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len - 1]) {
                tail[len] = arr[i];
                len++;
            } else {
                int c = ceil(tail, 0, len - 1, arr[i]);
                tail[c] = arr[i];
            }
            lisArray[i] = len;
        }
        return lisArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        int max = maximumBitonicSubSequence(arr);
        System.out.println(max);
    }
}
