public class StringPermutations {


    static boolean isSafe(String s, int l, int r, int i) {


        char[] arr = s.toCharArray();
        if (l != 0 && arr[l - 1] == 'A' && arr[i] == 'B') {
            return false;
        }
        if (r == l + 1 && (arr[i] == 'A' && arr[i] == 'B') || (arr[i] == 'A' && arr[r] == 'B')) {
            return false;
        }
        return true;
    }

    static void permute(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
            return;
        } else {

            for (int i = l; i <= r; i++) {

                if (isSafe(s, l, r, i)) {
                    swap(s.toCharArray(), l, r);
                    permute(s, l + 1, r);
                    swap(s.toCharArray(), l, i);
                }
            }
        }
    }

    static void swap(char[] s, int i, int j) {
        char temp = s[i];

        s[i] = s[j];
        s[j] = temp;
    }
}
