public class MedianOfTwoSortedArray {

    static double medianOfTwoSrotedArray(int[] a, int[] b, int n, int m) {
        int begin1 = 0;
        int end1 = n;
        int i1 = (begin1 + end1) / 2;
        int i2 = (n + m + 1) / 2 - i1;

        while (begin1 <= end1) {
            int min1 = (i1 == n) ? Integer.MAX_VALUE : a[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : a[i1 - 1];

            int min2 = (i2 == m) ? Integer.MAX_VALUE : b[i2];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : b[i2 - 1];

            if (max1 <= min2 && max2 <= min1) {
                if ((n + m) % 2 == 0) {
                    return (double) (Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                } else {
                    return Math.max(max1, max2);
                }
            } else if (max1 > min2) {
                end1 = i1 - 1;
            } else {
                begin1 = i1 + 1;
            }
            i1 = (begin1 + end1) / 2;
            i2 = (n + m + 1) / 2 - i1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {10, 20, 30, 50, 100};
        double med = medianOfTwoSrotedArray(a, b, a.length, b.length);
        System.out.println(med);
    }
}
