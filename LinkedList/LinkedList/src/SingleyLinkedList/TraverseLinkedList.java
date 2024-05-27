package SingleyLinkedList;

public class TraverseLinkedList {




    void traverseLinkedList ( Node head){
        Node curr = head ;

        while (curr!=null){
            System.out.println(curr.data);
            curr = curr .next  ;
        }
    }


    void traverseRecursive ( Node head){
        if (head == null){
            return;
        }
        System.out.println(head.data);
        traverseRecursive(head.next);

    }
}
