import java.util.TreeSet;

public class KthSmallestBst {

    static int count = 0;

    static void kthSmallestInBstNaive(Node root, int k) {


        if (root != null) {
            kthSmallestInBstNaive(root.left, k);
            count++;
            if (count == k) {
                System.out.println(root.data);
                return;
            }
            kthSmallestInBstNaive(root.right, k);
        }

    }


    static Node kthSmallestOptimalRec(Node root, int k) {
        if (root == null) {
            return null;
        }
        if (root.leftCount + 1 == k) {
            return root;
        } else if (root.leftCount + 1 > k) {
            return kthSmallestOptimalRec(root.left, k);
        } else {
            return kthSmallestOptimalRec(root.right, k - root.leftCount - 1);
        }
    }


    static Node insertAugmented(Node root, int x) {

        if (root == null) {
            return new Node(x);
        } else if (x > root.data) {
            root.right = insertAugmented(root.right, x);
        } else {

            root.leftCount++;
            root.left = insertAugmented(root.right, x);
        }
        return root;
    }

    static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    static Node kthSmallestElement(Node root, int k) {
        if (root == null) {
            return null;
        }
        Node curr = root;

        while (curr != null) {
            if (curr.leftCount + 1 == k) {
                return curr;
            }
            if (curr.leftCount + 1 > k) {
                curr = curr.left;
            } else {
                k = k - curr.leftCount - 1;
                curr = curr.right;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Node root = insertAugmented(null, 50);
        insertAugmented(root, 20);
        insertAugmented(root, 10);
        insertAugmented(root, 40);
        insertAugmented(root, 4);
        insertAugmented(root, 100);
        insertAugmented(root, 70);
        insertAugmented(root, 120);
        insertAugmented(root, 60);
        insertAugmented(root, 80);
//        preOrder(root);

        Node fifthSmallest = kthSmallestElement(root, 5);
        System.out.println(fifthSmallest.data);
    }
}
