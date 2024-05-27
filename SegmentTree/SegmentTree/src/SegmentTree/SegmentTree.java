package SegmentTree;

public class SegmentTree {
    int[] arr;
    int[] tree;


    public SegmentTree(int[] a) {
        arr = a;
        int size = 4 * a.length;
        tree = new int[size];
        buildSegmentTree(0, arr.length - 1, 0);
    }


    int getSum(int qs, int qe) {
        return getSum(qs, qe, 0, arr.length - 1, 0);
    }

    int getSum(int queryStart, int queryEnd, int start, int end, int index) {

        if (end < queryStart || start > queryEnd) {
            return 0;
        }
        if (queryStart <= start && queryEnd >= end) {
            return tree[index];
        }

        int mid = (start + end) / 2;
        int left = getSum(queryStart, queryEnd, start, mid, 2 * index + 1);
        int right = getSum(queryStart, queryEnd, mid + 1, end, 2 * index + 2);
        return left + right;
    }


    void printTree() {
        for (int x : tree) {
            System.out.print(x + " ");
        }
    }


    void update(int i, int newVal) {
        int diff = newVal - arr[i];
        arr[i] = newVal;
        update(0, arr.length - 1, i, 0, diff);
    }

    void update(int start, int end, int i, int index, int diff) {
        if (i < start || i > end) {
            return;
        }

        tree[index] += diff;
        if (start < end) {
            int mid = (start + end) / 2;
            update(start, mid, i, 2 * i + 1, diff);
            update(mid + 1, end, i, 2 * i + 2, diff);
        }
    }

    int buildSegmentTree(int start, int end, int index) {
        if (start == end) {
            tree[index] = arr[start];
            return arr[start];
        } else {
            int mid = (start + end) / 2;
            tree[index] = buildSegmentTree(start, mid, 2 * index + 1) +
                    buildSegmentTree(mid + 1, end, 2 * index + 2);
            return tree[index];
        }


    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        SegmentTree segmentTree = new SegmentTree(arr);
        int sum = segmentTree.getSum(0, 2);
        System.out.println(sum);
    }

}
