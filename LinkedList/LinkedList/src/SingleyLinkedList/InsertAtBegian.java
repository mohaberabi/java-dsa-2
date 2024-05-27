package SingleyLinkedList;
import Shared.Node ;
public class InsertAtBegian {


    Node insertToHead (Node head , int x){
        Node added = new Node(x);


        added.next=head ;
        return added;
    }
}
