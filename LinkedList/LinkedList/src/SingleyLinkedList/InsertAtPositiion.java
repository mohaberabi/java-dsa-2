package SingleyLinkedList;

import Shared.Node;

public class InsertAtPositiion {


    Node insertAtPositiion(Node head, int pos, int x) {
        Node added = new Node(x);
        if (head == null) {
            return added;
        }

        if (pos == 1) {
            added.next = head;
            return added;
        }
        Node curr = head;
        for (int i = 0; i < pos - 2 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            return head;
        }
        added.next = curr.next;
        curr.next = added;
        return head;
    }
}
