public class FixBstWithTwoNodesSwappedBstExample {


    public class FixBstWithTwoSwappedNodes {


        // given an array with all sorted except of two only , fix it


        Node prev = null;
        Node first = null;
        Node second = null;


        void fixBst(Node root) {
            findTwoSwappedNodes(root);
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }

        void findTwoSwappedNodes(Node root) {

            if (root == null) {
                return;
            }
            findTwoSwappedNodes(root.left);
            if (prev != null && root.data < prev.data) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            findTwoSwappedNodes(root.right);
        }


    }

}
