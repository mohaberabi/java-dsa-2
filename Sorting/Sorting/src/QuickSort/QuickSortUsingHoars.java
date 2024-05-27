package QuickSort;

public class QuickSortUsingHoars {


    static void quickSortUsingHoars(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = HoarsPartition.hoarsPartitionQuickSort(arr, low, high);
            quickSortUsingHoars(arr, low, pivot);
            quickSortUsingHoars(arr, pivot + 1, high);
        }
    }


    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 0};
        quickSortUsingHoars(arr, 0, arr.length - 1);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
