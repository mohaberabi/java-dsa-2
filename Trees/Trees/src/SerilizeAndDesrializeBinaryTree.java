import java.util.ArrayList;

public class SerilizeAndDesrializeBinaryTree {


    public static final ArrayList<Integer> serializedTree = new ArrayList<>();

    public static final int nil = -1;


    static void serialize(Node root) {
        if (root == null) {
            serializedTree.add(nil);
            return;
        }

        serializedTree.add(root.data);
        serialize(root.left);
        serialize(root.right);

    }

    private static int index = 0;

    static Node desrialize() {


        if (index == serializedTree.size()) {
            return null;
        }
        
        int val = serializedTree.get(index);
        index++;
        if (val == nil) {
            return null;
        }
        Node root = new Node(val);

        root.left = desrialize();
        root.right = desrialize();
        return root;

    }
}
