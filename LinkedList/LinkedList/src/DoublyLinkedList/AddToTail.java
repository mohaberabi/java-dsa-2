package DoublyLinkedList;

import Shared.Node;

public class AddToTail {
    Node addToTail(Node head, int x) {
        Node added = new Node(x);
        if (head == null) {
            return added;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = added;
        added.previous = curr;
        return head;
    }
}
