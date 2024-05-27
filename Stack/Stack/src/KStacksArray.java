import java.util.Arrays;

public class KStacksArray {


    private int[] arr;
    private int[] top;

    private int[] next;
    private int freeTop;
    private int cap;
    private int k;


    public KStacksArray(int k, int n) {
        this.k = k;
        this.cap = n;
        arr = new int[n];
        top = new int[k];
        next = new int[n];
        freeTop = 0;

        Arrays.fill(top, -1);

        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }

        next[n - 1] = -1;

    }


    int pop(int sn) {
        int i = top[sn];
        top[sn] = next[i];
        next[i] = freeTop;
        freeTop = i;
        return arr[i];
    }

    void push(int sn, int x) {
        int i = freeTop;
        freeTop = next[i];
        next[i] = top[sn];
        top[sn] = i;
        arr[i] = x;
    }

    boolean isEmpty(int sn) {
        return top[sn] == -1;
    }

}
