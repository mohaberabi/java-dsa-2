package DoublyLinkedList;

import Shared.Node;

public class AddToHead {


    Node addHead(Node head, int x) {

        Node added = new Node(x);

        added.next = head;
        head.previous = added;

        return added;


    }
}
