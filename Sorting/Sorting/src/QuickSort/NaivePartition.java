package QuickSort;

public class NaivePartition {


    void quickSortNaivePartition(int[] arr, int low, int high, int pivot) {
        int index = 0;


        int[] temp = new int[high - low + 1];


        for (int i = low; i <= high; i++) {
            if (arr[i] <= arr[pivot]) {
                temp[index] = arr[i];
                index++;
            }
        }

        for (int i = low; i <= high; i++) {
            if (arr[i] > arr[pivot]) {
                temp[index] = arr[i];
                index++;
            }
        }


        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}
