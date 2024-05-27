package SegmentTree;

public class SegmentTreeForMinMax {

    static class Pair {
        int min;
        int max;


        public Pair(int mi, int ma) {

            min = mi;
            max = ma;
        }

        @Override
        public String toString() {
            return "min-> " + min + " " + "max-> " + max;
        }
    }

    int[] arr;

    int n;
    Pair[] segmentTree;


    public SegmentTreeForMinMax(int[] arr) {
        this.arr = arr;
        n = arr.length;
        int size = 4 * n;

        segmentTree = new Pair[size];
        constructMinMaxSegmentTree(0, n - 1, 0);

    }

    Pair getMinMax(int start, int end, int queryStart, int queryEnd, int index) {
        if (end < queryStart || start > queryEnd) {
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        if (queryStart <= start && queryEnd >= end) {
            return segmentTree[index];
        }

        int mid = (start + end) / 2;
        Pair left = getMinMax(start, mid, queryStart, queryEnd, 2 * index + 1);
        Pair right = getMinMax(mid + 1, end, queryStart, queryEnd, 2 * index + 2);

        int min = Math.min(left.min, right.min);
        int max = Math.max(left.max, right.max);
        return new Pair(min, max);
    }

    void printTree() {
        for (Pair p : segmentTree) {
            if (p != null) {
                System.out.println(p.toString());

            }
        }
    }

    void constructMinMaxSegmentTree(int start, int end, int index) {
        if (start == end) {
            segmentTree[index] = new Pair(arr[start], arr[start]);
            return;
        } else {
            int mid = (start + end) / 2;
            constructMinMaxSegmentTree(start, mid, 2 * index + 1);
            constructMinMaxSegmentTree(mid + 1, end, 2 * index + 2);
            int min = Math.min(segmentTree[2 * index + 1].min, segmentTree[2 * index + 2].min);
            int max = Math.max(segmentTree[2 * index + 1].max, segmentTree[2 * index + 2].max);

            segmentTree[index] = new Pair(min, max);
            return;
        }

    }

    public static void main(String[] args) {
        int[] arr = {11, 3, 7, 5, 9, 1};
        SegmentTreeForMinMax tree = new SegmentTreeForMinMax(arr);
        Pair p = tree.getMinMax(0, arr.length - 1, 0, 2, 0);

        System.out.println(p.toString());

    }
}
