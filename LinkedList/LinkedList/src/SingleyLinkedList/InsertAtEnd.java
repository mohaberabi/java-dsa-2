package SingleyLinkedList;

import Shared.Node;

public class InsertAtEnd {




    Node insertToEnd (Node head, int x){
        Node added  = new Node(x);
        if (head==null){
            return added;
        }

        Node curr = head;
        while (curr.next!=null){
            curr=curr.next;
        }
        curr.next=added;
        return head;
    }
}
