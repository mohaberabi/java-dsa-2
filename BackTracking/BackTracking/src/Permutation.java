public class Permutation {


    static void permute(char[] s, int l, int r) {
        if (l == r) {
            if (!new String(s).contains("AB")) {
                System.out.println(s);
                return;
            }
        } else {
            for (int i = l; i <= r; i++) {
                swap(s, l, i);
                permute(s, l + 1, r);
                swap(s, l, i);
            }
        }
    }

    static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    public static void main(String[] args) {
        char[] s = {'A', 'B', 'C'};
        permute(s, 0, s.length - 1);
    }
}
