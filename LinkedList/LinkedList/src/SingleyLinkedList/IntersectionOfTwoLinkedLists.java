package SingleyLinkedList;

import Shared.Node;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {


    int intersectionOfTwoLinkedListOptimal(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return -1;
        }
        if (head1 == null || head2 == null) {
            return -1;
        }


        if (head1 == head2) {
            return head1.data;
        }
        int len1 = 0;
        int len2 = 0;


        for (Node curr = head1; curr != null; curr = curr.next) {
            len1++;
        }
        for (Node curr = head2; curr != null; curr = curr.next) {
            len2++;
        }

        int bound = Math.abs(len1 - len2);
        Node curr1 = head1;

        Node curr2 = head2;


        for (int i = 0; i < bound; i++) {
            if (len1 > len2) {
                curr1 = curr1.next;
            } else {
                curr2 = curr2.next;
            }
        }

        if (curr1 == null || curr2 == null) {
            return -1;
        }

        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1.data;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }


        return -1;
    }

    int intersectionOfTwoLinkedList(Node head1, Node head2) {

        if (head1 == null && head2 == null) {
            return -1;
        }
        if (head1 == null || head2 == null) {
            return -1;
        }

        if (head1 == head2) {
            return head1.data;
        }
        HashSet<Node> set = new HashSet<>();

        for (Node curr = head1; curr != null; curr = curr.next) {

            set.add(curr);
        }

        for (Node curr = head2; curr != null; curr = curr.next) {
            if (set.contains(curr)) {
                return curr.data;
            }
        }
        return -1;
    }
}
