package SingleCirculerLinkedList;

import Shared.Node;

public class InsertAtHead {


    Node insertHeadNaive(Node head, int x) {
        Node added = new Node(x);
        if (head == null) {
            added.next = added;
            return added;
        }
        added.next = head;
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = added;

        return added;

    }

    Node insertHeadNaive(Node head, Node tail, int x) {
        Node added = new Node(x);
        if (head == null) {
            added.next = added;
            return added;
        }
        added.next = head;
        tail.next = added;
        return added;

    }


    Node insertToHeadCirculerInOneTime(Node head, int x) {
        Node added = new Node(x);
        if (head == null) {
            added.next = added;
            return added;
        } else {

            added.next = head.next;
            head.next = added;
            int temp = head.data;
            head.data = head.next.data;
            head.next.data = temp;
            return head;

        }
    }
}
