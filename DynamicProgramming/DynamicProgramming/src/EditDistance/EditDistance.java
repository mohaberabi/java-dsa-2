package EditDistance;

public class EditDistance {


    static int editDistance(String a, String b, int n, int m) {
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            return editDistance(a, b, n - 1, m - 1);
        } else {
            int add = editDistance(a, b, n, m - 1);
            int deleted = editDistance(a, b, n - 1, m);
            int replace = editDistance(a, b, n - 1, m - 1);
            return 1 + Math.min(Math.min(add, deleted), replace);
        }
    }


    public static void main(String[] args) {

        String a = "SATURDAY";
        String b = "SUNDAY";
        int ed = editDistance(a, b, a.length(), b.length());
        System.out.println(ed);
    }
}
