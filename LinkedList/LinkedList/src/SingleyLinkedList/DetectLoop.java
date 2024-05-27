package SingleyLinkedList;

import Shared.Node;

import java.util.HashSet;

public class DetectLoop {


    boolean hasLoopMethod4(Node head) {

        HashSet<Node> set = new HashSet<>();


        Node curr = head;
        while (curr != null) {
            if (set.contains(curr.next)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }


    // this detroys the whole list
    boolean hasLoopMethod3(Node head) {
        Node dummy = new Node(0);

        Node curr = head;


        while (curr != null) {

            if (curr.next == null) {
                return false;
            }
            if (curr.next == dummy) {
                return true;
            }
            Node next = curr.next;
            curr.next = dummy;
            curr = next;
        }
        return false;
    }

    boolean hasLoopMethod2(Node head) {
        Node curr = head;


        while (curr != null) {
            if (curr.visited) {
                return true;
            }
            curr.visited = true;
            curr = curr.next;

        }
        return false;
    }

    boolean hasLoopNaive(Node head) {
        if (head == null) {
            return false;
        }
        Node outer = head;
        while (outer != null) {
            Node inner = head;
            while (outer != inner) {
                if (inner == outer.next) {
                    return true;
                }
                inner = inner.next;
            }
            outer = outer.next;
        }
        return false;

    }
}
