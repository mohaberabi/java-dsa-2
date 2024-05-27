package SingleyLinkedList;

import Shared.Node;

public class DetectRemoveLoop {


    void detectRemoveLoop(Node head) {
        Node fast = head.next;
        Node slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null)
                return;

            fast = fast.next.next;
            slow = slow.next;
        }

        int size = 1;
        fast = fast.next;

        while (fast != slow) {
            fast = fast.next;
            size += 1;
        }

        slow = head;
        fast = head;

        for (int i = 0; i < size - 1; i++)
            fast = fast.next;


        while (fast.next != slow) {
            
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = null;
    }


}
