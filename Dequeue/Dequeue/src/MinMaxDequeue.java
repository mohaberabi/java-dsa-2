public class MinMaxDequeue {


    private Node front;
    private Node rear;
    private int size;


    MinMaxDequeue() {
        size = 0;
        front = null;
        rear = null;
    }


    void insertMin(int x) {
        Node added = new Node(x);
        if (front == null) {
            front = added;
            rear = added;
        } else if (front.data <= x) {
            if (front.next != null) {
                added.next = front.next;
                added.prev = front;
                front.next.prev = added;
                front.next = added;
            } else {
                front.next = added;
                added.prev = front;
            }
        } else {
            added.next = front;
            front.prev = added;
            front = added;
        }
        size++;
    }


    Integer getMax() {
        if (rear == null) {
            return null;
        } else {
            return rear.data;
        }
    }

    Integer getMin() {
        if (front == null) {
            return null;
        } else {
            return front.data;
        }
    }


    Integer extractMax() {
        if (rear == null) {
            return null;
        } else {
            int max = rear.data;
            if (rear.prev != null) {
                rear = rear.prev;
                rear.next = null;
            } else {
                rear = null;
                front = null;
            }
            size--;
            return max;
        }
    }

    Integer extractMin() {
        if (front == null) {
            return null;
        } else {
            int data = front.data;

            if (front.next != null) {
                front = front.next;
                front.prev = null;
            } else {
                front = null;
                rear = null;
            }
            size--;
            return data;
        }

    }

    void insertMax(int x) {
        Node added = new Node(x);

        if (rear == null) {
            front = added;
            rear = added;
        } else if (rear.data >= x) {
            if (rear.prev != null) {
                Node prev = rear.prev;
                added.prev = prev;
                added.next = rear;
                rear.prev.next = added;
                rear.prev = added;
            } else {
                rear.prev = added;
                added.next = rear;
            }
        } else {
            added.prev = rear;
            rear.next = added;
            rear = added;
        }
        size++;
    }


    public static void main(String[] args) {
        MinMaxDequeue minMaxDequeue = new MinMaxDequeue();
        minMaxDequeue.insertMin(5);
        minMaxDequeue.insertMin(10);

        int min = minMaxDequeue.extractMin();
        System.out.println(min);
        int min2 = minMaxDequeue.getMin();
        System.out.println(min2);

    }
}
