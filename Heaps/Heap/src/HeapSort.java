public class HeapSort {
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n) {

        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Your code here
    }

    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }

        // Your code here
    }

    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n) {
        buildHeap(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
        //code here
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
