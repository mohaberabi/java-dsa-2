public class FromPostAndin {


    static int postIndex = 0;

    static Node fromPostAndInOrder(int[] in, int[] post, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        if (postIndex < 0) {
            return null;
        }
        Node root = new Node(post[postIndex--]);

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.data) {
                inIndex = i;
                break;
            }
        }
        root.right = fromPostAndInOrder(in, post, inIndex + 1, inEnd);
        root.left = fromPostAndInOrder(in, post, inStart, inIndex - 1);

        return root;

    }

    public static void main(String[] args) {

        int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
        postIndex = post.length - 1;

        Node tree = fromPostAndInOrder(in, post, 0, in.length - 1);


        LevelOrderTraversal.levelOrderTraversal(tree);
    }
}
