public class ConvertBinaryTreeToCirculerDoublyLinkedList {
    Node head = null;
    Node prev = null;

    // Function to convert binary tree to circular doubly linked list
    Node toCircularDoublyLinkedList(Node root) {
        if (root == null) {
            return root;
        }

        // Convert left subtree to circular doubly linked list
        Node leftList = toCircularDoublyLinkedList(root.left);

        // Connect the previous node in inorder traversal to the current root
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        // Update prev to the current root
        prev = root;

        // Convert right subtree to circular doubly linked list
        Node rightList = toCircularDoublyLinkedList(root.right);

        // Connect the last node of the right subtree to the head of the circular list
        if (rightList != null) {
            root.right = rightList;
            rightList.left = root;
        }

        // Return the head of the circular doubly linked list
        return (leftList != null) ? leftList : root;
    }

}
