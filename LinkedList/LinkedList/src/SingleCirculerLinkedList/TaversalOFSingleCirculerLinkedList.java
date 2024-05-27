package SingleCirculerLinkedList;

import Shared.Node;

public class TaversalOFSingleCirculerLinkedList {


    void traversalMethod1(Node head) {


        if (head == null) {
            return;
        }


        System.out.println(head.data);


        for (Node n = head.next; n != head; n = n.next) {
            System.out.println(n.data);

        }
    }


    void traversalMethod2(Node head) {
        if (head == null) {
            return;
        }
        Node n = head;
        do {
            System.out.println(n.data);
        } while (n != head);
    }
}
