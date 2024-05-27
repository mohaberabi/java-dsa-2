public class SubSequence {


    boolean isSubsequenceRecursive(String a, String b, int n, int m) {
        if (n == 0) {
            return false;
        }
        if (m == 0) {
            return true;
        }

        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            return isSubsequenceRecursive(a, b, n - 1, m - 1);


        } else {
            return isSubsequenceRecursive(a, b, n - 1, m);

        }

    }

    boolean isSubsequence(String a, String b) {


        int i = 0;
        int j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == b.length();
    }
}
