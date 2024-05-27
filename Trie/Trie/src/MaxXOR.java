public class MaxXOR {

    static final int bits = 32;
    static Node root = new Node();

    public static class Node {

        int value;
        Node[] children;

        public Node() {
            value = 0;

            children = new Node[2];
            children[0] = null;
            children[1] = null;
        }
    }

    static int maxXor(int[] arr, int n) {


        insert(0);

        int res = Integer.MIN_VALUE;

        int prevXor = 0;

        for (int i = 0; i < n; i++) {
            prevXor = prevXor ^ arr[i];
            insert(prevXor);
            res = Math.max(res, search(prevXor));
        }
        return res;
    }

    static void insert(int x) {


        Node curr = root;

        for (int i = bits; i >= 0; i--) {

            int val = (x & (1 << i)) >= 1 ? 1 : 0;
            if (curr.children[val] == null) {
                root.children[val] = new Node();

            }
            curr = curr.children[val];
        }
        curr.value = x;


    }

    static int search(int x) {
        Node curr = root;
        for (int i = bits; i >= 0; i--) {
            int val = (x & (1 << i)) >= 1 ? 1 : 0;

            if (curr.children[1 - val] != null)
                curr = curr.children[1 - val];

            else if (curr.children[val] != null)
                curr = curr.children[val];
        }
        return curr.value ^ x;
    }

    void maxXor(int[] arr) {

        int n = arr.length;

        int preXor = 0;
        insert(preXor);

    }

}
