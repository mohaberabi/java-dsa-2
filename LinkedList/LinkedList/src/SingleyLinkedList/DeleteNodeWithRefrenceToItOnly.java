package SingleyLinkedList;

import Shared.Node;

public class DeleteNodeWithRefrenceToItOnly {


    void deleteThisNode(Node target) {
        if (target == null) {
            return;
        }
        if (target.next == null) {
            target = null;
            return;
        }
        target.data = target.next.data;
        target = target.next.next;
    }
}
