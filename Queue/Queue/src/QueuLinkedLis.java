public class QueuLinkedLis {

    private int size;
    private Node front;
    private Node rear;

    QueuLinkedLis() {
        front = null;
        rear = null;
        size = 0;
    }


    void enqueu(int x) {
        Node added = new Node(x);
        if (front == null) {
            front = added;
            rear = added;
        } else {
            rear.next = added;
            rear = added;
        }
        size++;
    }


    Integer rear() {
        if (rear == null) {
            return null;
        }

        return rear.data;
    }

    Integer front() {
        if (front == null) {
            return null;
        }
        return front.data;
    }

    Integer deque() {
        if (front == null) {
            return null;
        }

        int data = front.data;

        front = front.next;
        size--;
        return data;

    }


    public static void main(String[] args) {


        QueuLinkedLis q = new QueuLinkedLis();
        q.enqueu(10);
        q.enqueu(20);

        q.deque();
        System.out.println(q.front());

    }

}
