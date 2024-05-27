public class ArrayDequeue {


    int front;
    int cap;
    int size;
    int[] arr;


    ArrayDequeue(int n) {
        arr = new int[n];
        front = 0;
        cap = 0;
        size = 0;

    }


    boolean isFull() {
        return size == cap;
    }

    boolean isEmpty() {
        return size == 0;
    }


    void deleteRear() {
        if (isEmpty()) {
            return;
        }
        size--;
    }

    void addRear(int x) {
        if (isFull()) {
            return;
        }
        int rear = (front + size) % cap;
        arr[rear] = x;
        size++;
    }

    void deleteFront() {
        if (isEmpty()) {
            return;
        }

        front = (front + 1) % cap;
        size--;

    }

    void addFront(int x) {

        if (isFull()) {
            return;
        }

        front = (front - 1 + cap) % cap;

        arr[front] = x;
        size++;
    }

    int getRear() {
        return (front + size - 1) % cap;
    }
}
