package DoublyLinkedList;

import Shared.Node;

public class DeleteHead {


    Node deleteHead(Node head) {


        if (head == null) {
            return head;
        }
        head = head.next;
        head.previous = null;
        return head;
    }
}
