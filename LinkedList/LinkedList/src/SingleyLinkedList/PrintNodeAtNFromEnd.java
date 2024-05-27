package SingleyLinkedList;

import Shared.Node;

public class PrintNodeAtNFromEnd {


    void printAtNFromEndOptimal(Node head, int n) {

        if (head == null) {
            return;
        }


        Node first = head;
        Node second = head;
        for (int i = 0; i < n; i++) {
            if (first == null) {
                return;
            }
            first = first.next;
        }

        while (first != null) {
            second = second.next;
            first = first.next;
        }

        if (second == null) {
            return;
        }
        System.out.println(second.data);

    }

    void printNodeAtNFromEnd(Node head, int n) {


        int len = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            len++;
        }
        if (n > len) {
            return;
        }
        Node curr = head;


        for (int i = 1; i < (len - n + 1); i++) {
            curr = curr.next;
        }
        System.out.println(curr.data);

    }

}
