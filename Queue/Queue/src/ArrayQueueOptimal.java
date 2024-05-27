public class ArrayQueueOptimal {


    int front;
    int cap;
    int size;
    int[] arr;


    ArrayQueueOptimal(int n) {
        front = 0;
        size = 0;
        cap = n;
        arr = new int[n];
    }


    void dequeu() {
        if (isEmpty()) {
            return;
        }

        front = (front + 1) % cap;
        size--;

    }

    void enqueue(int x) {
        if (isFull()) {
            return;
        }


        int rear = getRear();
        rear = (rear + 1) % cap;
        arr[rear] = x;
        size++;
    }

    boolean isEmpty() {
        return size == 0;
    }


    boolean isFull() {
        return cap == size;
    }


    int peak() {
        return arr[front];
    }

    int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return (front + size - 1) % cap;
    }


}
