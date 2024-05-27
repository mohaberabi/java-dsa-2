public class CountDistnictRows {


    static class BinaryTrieNode {

        BinaryTrieNode[] children;

        BinaryTrieNode() {
            //for only 0 or 1
            children = new BinaryTrieNode[2];
        }


    }


    static int countDistnictRows(int[][] mat) {

        BinaryTrieNode trieNode = new BinaryTrieNode();
        int res = 0;
        for (int row = 0; row < mat.length; row++) {
            if (insert(trieNode, row, mat[0].length, mat)) {
                res++;
            }
        }
        return res;
    }

    static boolean insert(BinaryTrieNode root, int row, int n, int[][] mat) {

        BinaryTrieNode curr = root;

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            int index = mat[row][i] == 0 ? 0 : 1;
            if (curr.children[index] == null) {
                curr.children[index] = new BinaryTrieNode();
                flag = true;
            }
            curr = curr.children[index];
        }
        return flag;
    }

    public static void main(String[] args) {

        int[][] mat = {{1, 0, 0}, {1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        int ans = countDistnictRows(mat);
        System.out.println(ans);
    }
}
