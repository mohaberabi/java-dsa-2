public class PrintNodesAtDistance {


    void printAtDistance(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
        } else {
            printAtDistance(root.left, k - 1);
            printAtDistance(root.right, k - 1);
        }
    }
}
