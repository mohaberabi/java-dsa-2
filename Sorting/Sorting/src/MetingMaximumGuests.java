import java.util.Arrays;

public class MetingMaximumGuests {


    static int maximumGuests(int[] arrival, int[] leaving, int n) {
        Arrays.sort(arrival);
        Arrays.sort(leaving);


        int i = 1;
        int j = 1;
        int curr = 1;
        int res = 1;


        while (i < n && j < n) {
            if (arrival[i] <= leaving[j]) {
                i++;
                curr++;
            } else {
                curr--;
                j++;
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {900, 1100, 1235};
        int[] leav = {1000, 1200, 1240};

        int res = maximumGuests(arr, leav, arr.length);
        System.out.println(res
        );
    }
}
