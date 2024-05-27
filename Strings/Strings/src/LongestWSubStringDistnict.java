public class LongestWSubStringDistnict {


    public static final int CHAR = 256;


    int longestSubDistnict(String s) {

        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isDistnict(s, i, j)) {
                    res = Math.max(res, (j - i + 1));
                }

            }
        }
        return res;
    }

    boolean isDistnict(String s, int i, int j) {
        boolean[] visited = new boolean[CHAR];
        for (int k = i; k < j; k++) {

            if (visited[s.charAt(k)]) {
                return false;
            }
            visited[s.charAt(k)] = true;
        }
        return true;
    }
}
