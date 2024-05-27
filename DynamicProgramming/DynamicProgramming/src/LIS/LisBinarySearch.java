package LIS;

import java.util.ArrayList;
import java.util.Collections;

public class LisBinarySearch {


    int listBinarySearchImpl2(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > ans.get(ans.size() - 1)) {
                ans.add(arr[i]);
            } else {
                int low = Collections.binarySearch(ans, arr[i]);
                if (low < 0) {
                    low = -(low + 1);
                }
                ans.set(low, arr[i]);
            }
        }
        return ans.size();
    }

    static int ceilIndex(int[] tail, int low, int high, int x) {


        while (high > low) {
            int mid = low + (high - low) / 2;

            if (tail[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
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
                int c = ceilIndex(tail, 0, len - 1, arr[i]);
                tail[c] = arr[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 20, 4, 6, 7};


        int lis = lis(arr);
        System.out.println(lis);
    }
}
