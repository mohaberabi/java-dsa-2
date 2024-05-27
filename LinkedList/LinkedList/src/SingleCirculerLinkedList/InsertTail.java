package SingleCirculerLinkedList;

import Shared.Node;

public class InsertTail {


    Node insertTail(Node head, int x) {


        Node added = new Node(x);
        if (head == null) {
            added.next = added;
            return added;
        } else {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            added.next = head;
            curr.next = added;
            return head;
        }
    }

    Node insertTail(Node head, Node tail, int x) {


        Node added = new Node(x);
        if (head == null) {
            added.next = added;
            return added;
        } else {
            tail.next = added;
            added.next = head;
            return head;
        }
    }

    Node insertTailConstantTime(Node head, int x) {
        Node added = new Node(x);
        if (head == null) {
            added.next = added;
            return added;
        } else {
            added.next = head.next;
            head.next = added;
            int temp = head.data;
            head.data = added.data;
            added.data = temp;
            return added;
        }
    }
}
