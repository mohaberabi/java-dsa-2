package SingleyLinkedList;

import Shared.Node;

public class DeleteTail {


    Node deleteTail(Node head) {
        if (head == null) {
            return null;
        }


        if (head.next == null) {
            return null;
        }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;

        return head;

    }
}
