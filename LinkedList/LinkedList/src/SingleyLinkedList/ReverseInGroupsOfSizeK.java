package SingleyLinkedList;

import Shared.Node;

public class ReverseInGroupsOfSizeK {


    Node reversInGroupKIterative(Node head, int k) {


        Node curr = head;
        int count = 0;
        Node prevFirst = null;
        boolean isFirstPass = true;
        while (curr != null) {
            Node prev = null;
            Node first = null;
            while (curr != null && count < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            } else {
                prevFirst.next = prev;
                prevFirst = first;
            }
        }
        return head;
    }

    Node reverseInGroupK(Node head, int k) {

        int count = 0;
        Node next = null;
        Node prev = null;
        Node curr = head;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;

        }

        if (next != null) {
            Node restHead = reverseInGroupK(next, k);
            head.next = restHead;
        }
        return prev;

    }

}
