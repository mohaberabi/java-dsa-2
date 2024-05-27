public class ArrayQueue {

    int size;
    int[] arr;
    int cap;


    ArrayQueue(int n) {
        size = 0;
        arr = new int[n];
        cap = n;
    }


    void deque() {
        if (isEmpty()) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }


    }


    Integer front() {
        return isEmpty() ? null : arr[0];
    }

    Integer rear() {
        return isEmpty() ? null : arr[size - 1];
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == cap;
    }

    void enque(int x) {
        if (isFull()) {
            return;
        }

        arr[size] = x;
        size++;

    }
}
