package QuickSort;

public class QuickSortUsingLumeto {


    static void quickSortUsingLumito(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = LumetoPartition.lumetoQuickSort(arr, low, high);
            quickSortUsingLumito(arr, low, pivot - 1);
            quickSortUsingLumito(arr, pivot, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 0};
        quickSortUsingLumito(arr, 0, arr.length - 1);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
