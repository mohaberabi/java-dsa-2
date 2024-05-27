package SegmentTree;

public class SegmentTreeLCM {


    int[] arr;
    int[] segmentTree;
    int n;

    public SegmentTreeLCM(int[] arr) {
        this.arr = arr;
        n = arr.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, n - 1, 0);
    }


    void update(int i, int newVal) {
        arr[i] = newVal;
        update(0, n - 1, 0, i, newVal);
    }

    void update(int start, int end, int index, int i, int newVal) {

        if (i < start || i > end) {
            return;
        }

        if (start == end) {
            segmentTree[index] = newVal;
        }
        int mid = (start + end) / 2;
        update(start, mid, 2 * index + 1, i, newVal);
        update(mid + 1, end, 2 * index + 2, i, newVal);

        segmentTree[index] = lcm(segmentTree[2 * index + 1], segmentTree[2 * index + 1]);
    }

    int getLCM(int qStart, int qEnd, int start, int end, int index) {

        if (end < qStart || start > qEnd) {
            return 0;
        }
        if (qStart <= start && qEnd >= end) {
            return segmentTree[index];
        }

        int mid = (start + end) / 2;
        int left = getLCM(qStart, qEnd, start, mid, 2 * index + 1);
        int right = getLCM(qStart, qEnd, mid + 1, end, 2 * index + 2);

        return lcm(left, right);

    }

    int buildSegmentTree(int start, int end, int index) {


        if (start == end) {
            segmentTree[index] = lcm(arr[start], arr[start]);
            return segmentTree[index];
        }

        int mid = (start + end) / 2;

        int left = buildSegmentTree(start, mid, 2 * index + 1);
        int right = buildSegmentTree(mid + 1, end, 2 * index + 2);
        segmentTree[index] = lcm(left, right);
        return segmentTree[index];
    }


    int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

}
