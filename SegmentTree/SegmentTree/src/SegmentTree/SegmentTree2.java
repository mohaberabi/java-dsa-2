package SegmentTree;

public class SegmentTree2 {


    int[] arr;
    int n;
    int[] segmentTree;


    public SegmentTree2(int[] arr) {
        this.arr = arr;
        n = arr.length;
        int size = 4 * arr.length;
        segmentTree = new int[size];
        buildSegmentTree(0, n - 1, 0);
    }


    void update(int i, int newVal) {
        int diff = newVal - arr[i];
        update(0, n - 1, 0, i, diff);
        arr[i] = newVal;
    }

    void update(int start, int end, int index, int i, int diff) {
        if (i < start || i > end) {
            return;
        }

        segmentTree[index] += diff;
        if (start < end) {
            int mid = (start + end) / 2;
            update(start, mid, 2 * index + 1, i, diff);
            update(mid + 1, end, 2 * index + 2, i, diff);

        }

    }


    int getSum(int qs, int qe) {
        return getSum(qs, qe, 0, n - 1, 0);
    }

    int getSum(int queryStart, int queryEnd, int start, int end, int index) {

        if (end < queryStart || start > queryEnd) {
            return 0;
        }

        if (queryStart <= start && queryEnd >= end) {
            return segmentTree[index];
        }
        int mid = (start + end) / 2;
        int left = getSum(queryStart, queryEnd, start, mid, 2 * index + 1);
        int right = getSum(queryStart, queryEnd, mid + 1, end, 2 * index + 2);

        segmentTree[index] = left + right;
        return segmentTree[index];
    }

    int buildSegmentTree(int start, int end, int index) {
        if (start == end) {
            segmentTree[index] = arr[start];
            return arr[start];
        } else {
            int mid = (start + end) / 2;
            segmentTree[index] = buildSegmentTree(start, mid, 2 * index + 1) +
                    buildSegmentTree(mid + 1, end, 2 * index + 2);
            return segmentTree[index];
        }

    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree2 tree = new SegmentTree2(arr);


        int sum = tree.getSum(0, 2);
        System.out.println(sum);
        tree.update(3, 17);
        int sum2 = tree.getSum(0, 5);
        System.out.println(sum2);
    }
}

