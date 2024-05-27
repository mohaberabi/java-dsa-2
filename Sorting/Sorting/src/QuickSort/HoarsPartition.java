package QuickSort;

import Helpers.Helpers;

public class HoarsPartition {


    static int hoarsPartitionQuickSort(int[] arr, int low, int high) {
        int pivot = arr[low];

        int i = low - 1;
        int j = high + 1;
        while (true) {

            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }
            Helpers.swapArray(arr, i, j);
        }
    }
}
