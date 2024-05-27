public class ConstructBinaryTreeFromInOrderAndPreOrder {


    int preIndex = 0;

    Node construct(int[] in, int[] pre, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }
        Node root = new Node(pre[preIndex++]);


        int inIndex = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.data) {
                inIndex = i;
                break;
            }
        }

        root.left = construct(in, pre, inStart, inIndex - 1);
        root.right = construct(in, pre, inStart + 1, inEnd);
        return root;
    }
}
