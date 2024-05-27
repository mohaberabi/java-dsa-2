public class BinaryIndexTree {
    private int[] arr;

    int n;
    private int[] biIndexTree;

    public BinaryIndexTree(int[] arr) {
        n = arr.length;
        this.arr = arr;
        biIndexTree = new int[n + 1];
        constructBiIndexTree();
    }

    void printTree() {

        for (int x : biIndexTree) {
            System.out.println(x + " ");
        }
    }

    void constructBiIndexTree() {
        for (int i = 0; i < n; i++) {
            fillTree(i, arr[i]);
        }
    }


    void fillTree(int i, int val) {
        i = i + 1;
        while (i <= n) {
            biIndexTree[i] += val;
            i = i + (i & (-i));
        }
    }

    void update(int i, int newVal) {
        int diff = newVal - arr[i];
        arr[i] = newVal;
        i = i + 1;

        while (i <= n) {
            biIndexTree[i] += diff;
            i = i + (i & (-i));
        }

    }

    int getSum(int i) {
        int res = 0;
        i = i + 1;
        while (i > 0) {
            res += biIndexTree[i];
            i = i - (i & (-i));

        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        BinaryIndexTree binaryIndexTree = new BinaryIndexTree(arr);
        binaryIndexTree.printTree();
        int sum = binaryIndexTree.getSum(4);

        System.out.println(sum);
        binaryIndexTree.update(0, 0);
        int newSum = binaryIndexTree.getSum(4);
        System.out.println(newSum);
    }
}
