package SingleCirculerLinkedList;

import Shared.Node;

public class DeleteHead {


    Node deleteHeadConstant(Node head) {
        if (head == null || head.next == head) {
            return null;
        }
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }

    Node deleteHeadNaive(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) {
            return null;
        }


        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = head.next;
        return curr.next;
    }
}
