package DoublyLinkedList;

import Shared.Node;

public class ReveerseLinkedList {


    Node reverseDoubleLinkedList(Node head) {

        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }


        Node curr = head;
        Node prev = null;

        while (curr != null) {
            prev = curr.previous;
            curr.previous = curr.next;
            curr.next = prev;
            curr = curr.previous;
        }


        return prev.previous;
    }

}
