package SingleyLinkedList;

import Shared.Node;

public class CycleFloydLoopDetection {


    boolean hasLoop(Node head) {
        Node fast = head;
        Node slow = head;


        while (fast != null & fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
