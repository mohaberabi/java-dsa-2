import java.util.HashMap;

public class Factorial {
    static final HashMap<Integer, Integer> memo = new HashMap<>();

    static int fact(int n) {
        if (!memo.containsKey(n)) {
            int res;

            if (n == 0 || n == 1) {
                res = 1;
            } else {
                res = n * fact(n - 1);
            }
            memo.put(n, res);

        }
        return memo.get(n);
    }

}
