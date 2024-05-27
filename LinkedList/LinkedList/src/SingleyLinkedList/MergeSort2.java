package SingleyLinkedList;

import Shared.Node;

public class MergeSort2 {


    Node mergeSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }


        Node mid = getMiddle(head);
        Node midNext = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(midNext);
        Node sorted = merge(left, right);
        return sorted;

    }


    Node getMiddle(Node head) {
        if (head == null) {
            return null;
        }


        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    Node merge(Node a, Node b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }


        Node head = null;
        Node tail = null;

        if (a.data <= b.data) {
            head = a;
            tail = a;
            a = a.next;
        } else {
            head = b;
            tail = b;
            b = b.next;
        }

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                tail = a;
                a = a.next;

            } else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }

        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }
        return head;
    }
}
