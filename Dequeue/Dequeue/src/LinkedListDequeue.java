public class LinkedListDequeue {


    private Node front;


    private Node rear;
    private int size;


    LinkedListDequeue() {
        front = null;
        rear = null;
        size = 0;

    }


    boolean isEmpty() {
        return front == null;
    }

    int size() {
        return size;
    }


    Integer front() {
        if (front == null) {
            return null;
        }
        return front.data;
    }

    void deleteRear() {

        if (rear == null) {
            return;
        }
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
        }
        size--;
    }

    void deleteFront() {
        if (front == null) {
            return;
        }
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
        size--;

    }

    void addRear(int x) {
        Node added = new Node(x);
        if (front == null) {
            front = added;
            rear = added;
        } else {
            added.prev = rear;
            rear.next = added;
            rear = added;
        }
        size++;
    }

    void addFront(int x) {
        Node added = new Node(x);
        if (front == null) {
            front = added;
            rear = added;
        } else {

            added.next = front;
            front.prev = added;
            front = added;

        }

        size++;
    }

    Integer rear() {
        if (rear == null) {
            return null;
        }
        return rear.data;
    }

}
