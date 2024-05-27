package QuickSort;


import Helpers.Helpers;

public class LumetoPartition {


    static int lumetoQuickSort(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                Helpers.swapArray(arr, i, j);
            }
        }
        Helpers.swapArray(arr, i + 1, high);

        return i + 1;
    }

    static int lumetoQuickSort(int[] arr, int low, int high, int p) {
        Helpers.swapArray(arr, p, high);
        return lumetoQuickSort(arr, low, high);
    }

    public static void main(String args[]) {
        int[] arr = {50, 30, 20, 10, 5, 11};

        int pWithStandard = lumetoQuickSort(arr, 0, arr.length - 1);
        int pWithCustom = lumetoQuickSort(arr, 0, arr.length - 1, 2);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
