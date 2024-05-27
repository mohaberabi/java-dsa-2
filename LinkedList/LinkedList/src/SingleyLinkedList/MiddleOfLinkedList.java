package SingleyLinkedList;

import Shared.Node;

public class MiddleOfLinkedList {


    Node middleOfLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        int count = 0;

        Node curr = head;
        for (curr = head; curr != null; curr = curr.next) {
            count++;
        }
        curr = head;
        for (int i = 0; i < count / 2; i++) {
            curr = curr.next;
        }
        return curr;

    }

    Node middleOfLinkedListOptimal(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
