package LIS;

import java.util.Arrays;

public class MaximumLengthOfBitonicSubSequence {

    public static int longestBitonicSubsequence(int[] arr) {
        int n = arr.length;

        int[] lis = new int[n];
        int[] lds = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            lds[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }


        int maxBitonicLength = 1;
        for (int i = 0; i < n; i++) {
            int currentBitonicLength = lis[i] + lds[i] - 1;
            maxBitonicLength = Math.max(maxBitonicLength, currentBitonicLength);
        }

        return maxBitonicLength;
    }


    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        int res = longestBitonicSubsequence(arr);
        System.out.println(res);
    }
}
