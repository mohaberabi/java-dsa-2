package SingleyLinkedList;

import Shared.Node;

import java.util.LinkedList;

public class AddToNumberOfLinkedLists {
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static Node addTwoLists(Node first, Node second) {

        first = reverse(first);
        second = reverse(second);

        Node sum = null;
        int carry = 0;

        while (first != null || second != null || carry > 0) {
            int newVal = carry;

           
            if (first != null) newVal += first.data;
            if (second != null) newVal += second.data;

            carry = newVal / 10;

            newVal = newVal % 10;

            Node newNode = new Node(newVal);

            newNode.next = sum;
            sum = newNode;

            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }

        return sum;
    }
}
