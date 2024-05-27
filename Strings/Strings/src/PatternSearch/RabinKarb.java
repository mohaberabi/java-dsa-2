package PatternSearch;

public class RabinKarb {

    public static final int D = 256;
    public static final int Q = 13;


    static void rabinKarb(String text, String pat) {
        int n = text.length();
        int m = pat.length();

        int hash = 1;
        for (int i = 1; i <= m - 1; i++) {
            hash = (hash * D) % Q;
        }
        int p = 0;
        int t = 0;

        for (int i = 0; i < m; i++) {
            p = (p * D + pat.charAt(i)) % Q;
            t = (t * D + text.charAt(i)) % Q;
        }

        for (int i = 0; i <= n - m; i++) {
            // first check that two hash functions equals
            if (p == t) {
                // then check individual characters
                boolean charactersMatched = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pat.charAt(j)) {
                        charactersMatched = false;
                        break;
                    }
                }
                if (charactersMatched) {
                    System.out.println(i);
                }
            }
            if (i < n - m) {
                // recompute the hash function for next iteration using the rolling hash technique
                t = ((D * (t - text.charAt(i) * hash)) + text.charAt(i + m)) % Q;
                if (t < 0) {
                    t = t + Q;
                }
            }
        }

    }

    public static void main(String[] args) {
        String me = "mohab";
        String pat = "hab";
        rabinKarb(me, pat);
    }
}
