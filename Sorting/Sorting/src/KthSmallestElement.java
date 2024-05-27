import Helpers.Helpers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {


    static int kthSmallestElementUSingLumito(int[] arr, int n, int k) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int pivot = lumitoPartition(arr, low, high);
            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot > k - 1) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return -1;
    }

    static int lumitoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high; j++) {
            if (arr[j] < pivot) {
                i++;
                Helpers.swapArray(arr, i, j);
            }
        }
        Helpers.swapArray(arr, i + 1, high);

        return i + 1;
    }


    static int kthSmallestElementUsingSorting(int[] arr, int n, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }


    static int kthSmallestElementUsingHeap(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        int res = 0;

        for (int i = 0; i < k; i++) {

            int poll = pq.poll();
            res = poll;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {10, 3, 5, 20};
        int res = kthSmallestElementUSingLumito(arr, arr.length, 2);
        System.out.println(res);
    }
}
