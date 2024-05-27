import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeFromLinkedList {


    static Node constructBinaryTreeUtil(LinkedNode head) {
        if (head == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        Node root = new Node(head.data);
        queue.add(root);

        head = head.next;

        while (head != null) {
            Node parent = queue.poll();

            Node leftChild = new Node(head.data);
            parent.left = leftChild;
            queue.add(leftChild);

            head = head.next;

            if (head != null) {
                Node rightChild = new Node(head.data);
                parent.right = rightChild;
                queue.add(rightChild);

                head = head.next;
            }
        }

        return root;
    }

    public static void main(String[] args) {


        LinkedNode node = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        node.next = node2;
        LinkedNode node3 = new LinkedNode(3);
        node2.next = node3;
        LinkedNode node4 = new LinkedNode(4);
        node3.next = node4;
        LinkedNode node5 = new LinkedNode(5);
        node4.next = node5;


        Node root = constructBinaryTreeUtil(node);

        LevelOrderTraversal.levelOrderTraversal(root);


    }
}
