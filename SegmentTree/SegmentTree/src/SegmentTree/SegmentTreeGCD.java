package SegmentTree;

public class SegmentTreeGCD {


    int[] arr;
    int n;
    int[] segmentTree;

    public SegmentTreeGCD(int[] arr) {
        this.arr = arr;
        n = arr.length;
        int size = 4 * n;
        segmentTree = new int[size];
        buildSegmentTree(0, n - 1, 0);
    }


    void update(int i, int newVal) {

        arr[i] = newVal;

        update(0, n - 1, 0, i, newVal);
    }

    void update(int start, int end, int index, int i, int newVal) {
        if (i < start || i > end)
            return;
        if (start == end) {
            segmentTree[index] = newVal;
            return;
        }


        int mid = start + (end - start) / 2;
        if (index <= mid)
            update(start, mid, 2 * index + 1, i, newVal);
        else
            update(mid + 1, end, 2 * i + 2, i, newVal);

        segmentTree[index] = gcd(segmentTree[index * 2 + 1], segmentTree[index * 2 + 2]);

    }

    int buildSegmentTree(int start, int end, int index) {
        if (start == end) {
            segmentTree[index] = gcd(arr[start], arr[start]);
            return arr[start];
        }
        int mid = (start + end) / 2;
        int left = buildSegmentTree(start, mid, 2 * index + 1);
        int right = buildSegmentTree(mid + 1, end, 2 * index + 2);
        segmentTree[index] = gcd(left, right);
        return segmentTree[index];
    }


    int getGcd(int queryStart, int queryEnd, int start, int end, int index) {


        if (end < queryStart || start > queryEnd) {
            return 0;
        }

        if (queryStart <= start && queryEnd >= end) {
            return segmentTree[index];
        }

        int mid = (start + end) / 2;

        int left = getGcd(queryStart, queryEnd, start, mid, 2 * index + 1);
        int right = getGcd(queryStart, queryEnd, mid + 1, end, 2 * index + 2);

        return gcd(left, right);
    }


    private int gcd(int a, int b) {
        if (a < b) {
            int temp = b;

            b = a;
            a = temp;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6, 8, 16};
        SegmentTreeGCD tree = new SegmentTreeGCD(arr);
        int q1 = tree.getGcd(0, 2, 0, arr.length - 1, 0);
        System.out.println(q1);

        tree.update(3, 8);
        int q2 = tree.gcd(2, 5);
        System.out.println(q2);
    }
}
