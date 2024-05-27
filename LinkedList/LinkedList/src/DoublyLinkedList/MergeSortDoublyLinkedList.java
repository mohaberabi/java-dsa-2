package DoublyLinkedList;

import Shared.Node;

public class MergeSortDoublyLinkedList {


    Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }


        Node mid = getMid(head);
        Node nextMid = mid.next;
        mid.next = null;
        nextMid.previous = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextMid);
        Node sorted = merge(left, right);
        return sorted;
    }

    Node getMid(Node head) {
        if (head == null) {
            return head;
        }


        Node fast = head.next;
        Node slow = head;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }


        return slow;
    }


    Node merge(Node a, Node b) {
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
                a.previous = tail;
                tail = a;
                a = a.next;

            } else {
                tail.next = b;
                b.previous = tail;
                tail = b;
                b = b.next;

            }

        }
        if (a == null) {
            tail.next = b;
            b.previous = tail;
        } else {
            tail.next = a;
            a.previous = tail;
        }
        return head;
    }
}
