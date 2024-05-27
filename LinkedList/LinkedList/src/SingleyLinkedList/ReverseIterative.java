package SingleyLinkedList;

import Shared.Node;

public class ReverseIterative {


    Node reverseLinkedListIterative(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
