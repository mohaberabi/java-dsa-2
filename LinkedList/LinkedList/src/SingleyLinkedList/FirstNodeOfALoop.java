package SingleyLinkedList;

import Shared.Node;

public class FirstNodeOfALoop {


    Node firstNodeOfLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }
}
