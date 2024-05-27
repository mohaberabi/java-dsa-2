package SingleCirculerLinkedList;

import Shared.Node;

public class DeleteAtK {


    Node deleteAtK(Node head, int k) {


        if (head == null) {
            return null;
        }

        if (k == 1) {

            head.data = head.next.data;
            head.next = head.next.next;
            return head;
        }

        Node curr = head;
        for (int i = 0; i < k - 2; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
