package SingleyLinkedList;

import Shared.Node;

import java.util.HashMap;

public class CloneWithRandomPointer {


    Node cloneWithRandomPointerOptimal(Node head) {
        Node curr = head;


        while (curr != null) {
            Node next = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = next;
            curr = next;
        }


        for (Node node = head; node != null; node = node.next.next) {


            node.next.random = (node.random == null) ? null : node.random.next;
        }


        Node head2 = head.next;


        Node clone = head2;

        for (Node node = head; node != null; node = node.next) {
            node.next = node.next.next;
            node.next = (clone.next == null) ? null : clone.next.next;
            clone = node.next;
        }
        return head2;

    }

    Node cloneWithRandomPointerMethod1(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();


        for (Node curr = head; curr != null; curr = curr.next) {

            map.put(curr, new Node(curr.data));

        }


        for (Node curr = head; curr != null; curr = curr.next) {

            Node clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);

        }

        return map.get(head);

    }
}
