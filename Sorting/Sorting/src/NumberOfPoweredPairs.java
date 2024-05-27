import java.util.Arrays;

public class NumberOfPoweredPairs {


    static int countPairs(int[] x, int[] y, int n, int m) {
   
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (y[j] > x[i]) {
                    res++;
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {

        int[] x = {2, 3, 4, 5};
        int[] y = {1, 2, 3};
        int res = countPairs(x, y, x.length, y.length);
        System.out.println(res);
    }
}
