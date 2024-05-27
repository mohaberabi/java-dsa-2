package SingleyLinkedList;

import Shared.Node;

public class InsertIntoSorted {


    Node insertToSorted(Node head, int x) {

        Node added = new Node(x);


        if (head == null) {
            return added;
        }
        if (head.data < x) {
            added.next = head;
            return added;
        }

        Node curr = head;
        while (curr.next != null && curr.next.data < x) {
            curr = curr.next;
        }
        added.next = curr.next;
        curr.next = added;

        return head;
    }
}
