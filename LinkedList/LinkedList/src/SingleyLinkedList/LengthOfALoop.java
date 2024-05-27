package SingleyLinkedList;

import Shared.Node;

public class LengthOfALoop {


    int lengthOfLoop(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                int len = 1;
                fast = fast.next;
                while (fast != slow) {
                    fast = fast.next;
                    len++;
                }
                return len;
            }
        }
        return 0;
    }
}
