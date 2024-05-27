package SingleyLinkedList;

import Shared.Node;

public class RecursiveReverseLinkedList {


    Node recusriveReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node restHead = recusriveReverse(head.next);
        Node restTail = head.next;
        restTail.next = restHead;
        head.next = null;
        return restHead;
    }


    Node recuriveReverse(Node head, Node previous) {

        if (head == null) {
            return previous;
        }
        Node next = head.next;
        head.next = previous;
        return recuriveReverse(next, head);

    }
}
