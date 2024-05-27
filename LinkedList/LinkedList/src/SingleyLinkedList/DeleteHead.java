package SingleyLinkedList;

import Shared.Node;

public class DeleteHead {


    Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        head = head.next;
        return head;
    }
}
