import java.util.HashMap;

public class CatalanNo {


    static double catalan(int n) {


        double firstTerm = 1.0 / (n + 1);

        int factNum = fact(n * 2);
        int factDun = fact(n);

        double secondTerm = (double) factNum / (factDun * factDun);

        double res = firstTerm * secondTerm;
        return res;

    }

    static int fact(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        int res = 1;


        while (n != 0) {
            res *= n;
            n--;

        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        double f = catalan(5);
        System.out.println(f);
    }
}
