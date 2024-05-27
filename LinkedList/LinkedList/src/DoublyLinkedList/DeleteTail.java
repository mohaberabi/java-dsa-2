package DoublyLinkedList;

import Shared.Node;

public class DeleteTail {


    Node deleteTail(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.previous.next = null;
        return head;

    }
}
