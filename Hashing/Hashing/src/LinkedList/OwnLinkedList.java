package LinkedList;

public class OwnLinkedList<T> {


    private Node<T> head;

    public OwnLinkedList() {
        head = null;
    }


    public Node<T> getHead() {
        return this.head;
    }

    public void addLast(T x) {
        Node<T> insert = new Node<>(x);
        if (head == null) {
            head = insert;
        } else {
            head.next = insert;
        }
    }


    public boolean search(Object key) {
        if (head.data instanceof Entry && ((Entry) head.data).getKey().equals(key)) {
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data instanceof Entry && ((Entry) current.next.data).getKey().equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(T t) {

        if (head == null) {
            return;
        }

        if (head.data.equals(t)) {

            head = head.next;
            return;
        }
        Node curr = head;

        while (curr.next != null) {
            if (curr.next.data.equals(t)) {
                curr.next = curr.next.next;
                return;
            }
        }

    }

    public void removeByKey(Object key) {
        if (head == null) {
            return;
        }

        if (head.data instanceof Entry && ((Entry) head.data).getKey().equals(key)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data instanceof Entry && ((Entry) current.next.data).getKey().equals(key)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }


}
