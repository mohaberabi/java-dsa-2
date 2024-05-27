import java.util.Arrays;

public class LeftMostRepeatingCharacter {


    int leftMostRepeatedOptimal2(String s) {

        int res = -1;
        boolean[] visited = new boolean[CHAR];

        for (int i = s.length() - 1; i >= 0; i--) {
            if (visited[s.charAt(i)]) {
                res = i;
            } else {
                visited[s.charAt(i)] = true;
            }
        }
        return res;
    }

    public static final int CHAR = 256;

    static int leftMostRepeatedOptimal1(String s) {

        int[] firstIndex = new int[CHAR];

        Arrays.fill(firstIndex, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int fi = firstIndex[s.charAt(i)];

            if (fi == -1) {
                firstIndex[s.charAt(i)] = i;
            } else {
                res = Math.min(fi, res);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;

    }

    static int leftMostRepeatingCharacterBetter(String s) {


        int[] count = new int[CHAR];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] > 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "abbcc";
        int res = leftMostRepeatingCharacterBetter(s);
        System.out.println(res);
    }
}
