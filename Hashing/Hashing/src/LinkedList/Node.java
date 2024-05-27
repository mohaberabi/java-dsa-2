package LinkedList;

public class Node<T> {
    public Node next;
    public T data;

    public Node(T x) {
        this.data = x;
        next = null;
    }


}