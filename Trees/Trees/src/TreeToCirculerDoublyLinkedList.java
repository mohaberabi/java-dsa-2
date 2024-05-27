public class TreeToCirculerDoublyLinkedList {


    Node toCDLLRec(Node leftList, Node rightList) {

        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }
        Node leftLast = leftList.left;
        Node rightLast = rightList.left;
        leftLast.right = rightLast;
        rightList.left = leftLast;
        leftList.left = rightLast;
        rightLast.right = leftList;
        return leftList;
    }


    Node toCDLL(Node root) {
        if (root == null) {
            return null;
        }
        Node left = toCDLL(root.left);
        Node right = toCDLL(root.right);
        return toCDLLRec(toCDLLRec(left, right), right);
    }
}
