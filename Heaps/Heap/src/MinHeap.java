public class MinHeap {

    int capacity;
    int size;
    int[] arr;

    public MinHeap(int c) {
        capacity = c;
        arr = new int[c];
        size = 0;
    }

    void decreaseKey(int i, int x) {
        arr[i] = x;
        while (i != 0 && arr[i] < arr[parent(i)]) {
            swap(arr, i, parent(i));
            i = parent(i);
        }
    }

    void buildHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;

        if (left < size && arr[left] < arr[i]) {
            smallest = left;
        }

        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(arr, i, smallest);
            minHeapify(smallest);
        }
    }

    int extractMin() {
        if (size == 0) {
            return -1;
        }

        if (size == 1) {
            size--;
            return arr[0];
        }

        swap(arr, 0, size - 1);
        size--;
        minHeapify(0);
        return arr[size];
    }

    int getMin() {
        if (size == 0) {
            return -1;
        }
        return arr[0];
    }

    void insert(int x) {
        if (size == capacity) {
            return;
        }
        size++;
        arr[size - 1] = x;

        for (int i = size - 1; i != 0 && arr[i] < arr[parent(i)]; i = parent(i)) {
            swap(arr, i, parent(i));
        }
    }

    void deleteKey(int i) {
        if (size == 0 || i >= size) {
            return;
        }

        decreaseKey(i, Integer.MIN_VALUE);
        size--;
        extractMin();
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }
}
