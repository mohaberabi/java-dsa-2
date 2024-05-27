public class ConvertBinaryTreeToDoubleLinkedList {


    static Node prev = null;


    static Node toDoubleLinkedList(Node root) {
        if (root == null) {
            return null;  // Return null for an empty subtree
        }

        Node leftList = toDoubleLinkedList(root.left);

        // If there is a left subtree, find the last node in the doubly linked list
        if (leftList != null) {
            Node temp = leftList;
            while (temp.right != null) {
                temp = temp.right;
            }
            // Connect the last node of the left subtree to the current root
            temp.right = root;
            root.left = temp;
        }

        Node rightList = toDoubleLinkedList(root.right);

        // If there is a right subtree, connect it to the current root
        if (rightList != null) {
            root.right = rightList;
            rightList.left = root;
        }

        // Return the head of the combined doubly linked list
        return (leftList != null) ? leftList : root;
    }

    static Node toCircularDoublyLinkedList(Node root) {
        if (root == null) {
            return null;
        }

        Node head = toDoubleLinkedList(root);

        Node tail = head;
        while (tail.right != null) {
            tail = tail.right;
        }
        tail.right = head;
        head.left = tail;

        return head;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;
//        Node dll = toDoubleLinkedList(root);
        Node cdll = toCircularDoublyLinkedList(root);
        Node curr = cdll;
        do {
            System.out.println(curr.data);
            curr = curr.right;

        } while (curr != cdll);

    }
}
