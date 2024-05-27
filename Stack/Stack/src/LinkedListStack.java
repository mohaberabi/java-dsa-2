import java.util.NoSuchElementException;

public class LinkedListStack<T> {


    private Node<T> head;

    private int size;

    public LinkedListStack() {
        head = null;
        size = 0;

    }


    public boolean isEmpty() {
        return head == null;
    }


    public void Push(T t) {
        Node<T> added = new Node<>(t);
        added.next = head;
        head = added;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node<T> node = head;
            head = head.next;
            size--;
            return node.data;
        }
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();

        } else {
            return head.data;
        }
    }
}
