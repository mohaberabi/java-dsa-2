package QuickSort;

import java.util.Random;

public class QuickSortOptimized {
    static void quickSortOptmizedUsingHoars(int[] arr, int low, int high) {
        if (low < high) {
            randomizePivot(arr, low, high);
            int pivot = HoarsPartition.hoarsPartitionQuickSort(arr, low, high);
            quickSortOptmizedUsingHoars(arr, low, pivot);
            quickSortOptmizedUsingHoars(arr, pivot + 1, high);
        }

    }

    static void quickSortOptimizedUsingLumeto(int[] arr, int low, int high) {
        if (low < high) {
            randomizePivot(arr, low, high);
            int pivot = LumetoPartition.lumetoQuickSort(arr, low, high);
            quickSortOptimizedUsingLumeto(arr, low, pivot - 1);
            quickSortOptimizedUsingLumeto(arr, pivot + 1, high);
        }
    }


    static void randomizePivot(int[] arr, int low, int high) {
        Random random = new Random();
        int randomIndex = random.nextInt(high - low + 1) + low;
        swap(arr, high, randomIndex);
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 0};
        quickSortOptimizedUsingLumeto(arr, 0, arr.length - 1);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

}
