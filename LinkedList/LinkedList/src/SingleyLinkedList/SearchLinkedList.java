package SingleyLinkedList;

import Shared.Node;

public class SearchLinkedList {


    int srearchLinkedList(Node head, int x) {

        if (head == null) {
            return -1;
        }

        if (head.data == x) {
            return 1;
        }

        Node curr = head;
        int res = 1;
        while (curr != null) {
            if (curr.data == x) {
                return res;
            }
            curr = curr.next;
            res++;
        }

        return -1;
    }

    int searchLinkedListRecursive(Node head, int x) {
        if (head == null) {
            return -1;
        }
        if (head.data == x) {
            return 1;
        } else {
            int res = searchLinkedListRecursive(head.next, x);
            if (res == -1) {
                return -1;
            } else {
                return res + 1;
            }
        }

    }
}
