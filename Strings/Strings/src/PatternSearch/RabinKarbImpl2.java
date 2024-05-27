package PatternSearch;

public class RabinKarbImpl2 {
    static int d = 256;

    //Function to check if the pattern is present in string or not.
    static boolean search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        //the value of h would be "pow(d, M-1)%q".
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        //calculating the hash value of pattern and first window of text.
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        //sliding the pattern over text one by one.
        for (i = 0; i <= N - M; i++) {
            //checking the hash values of current window of text and pattern.
            //If hash values match then only we check for characters on by one.
            if (p == t) {
                //checking for characters one by one.
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                //if pattern is found, we return true.
                if (j == M)
                    return true;
            }

            //calculating hash value for next window of text.
            //removing leading digit and adding trailing digit.
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                //we might get negative value of t so converting it to positive.
                if (t < 0)
                    t = (t + q);
            }
        }
        //returning false if pattern is not found.
        return false;
    }
}
