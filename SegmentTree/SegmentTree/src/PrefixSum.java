import java.util.ArrayList;

public class PrefixSum {


    ArrayList<Integer> prefixSum(int[] arr) {

        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(arr[0]);


        for (int i = 1; i < n; i++) {
            al.add(al.get(i - 1) + arr[i]);
        }

        return al;
    }

    int getSum(int i, int j, int[] arr) {
        if (i == 0) {
            return prefixSum(arr).get(j);
        } else {
            return prefixSum(arr).get(j) - prefixSum(arr).get(i - 1);
        }
    }
}
