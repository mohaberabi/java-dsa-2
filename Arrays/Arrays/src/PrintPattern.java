import java.util.ArrayList;
import java.util.List;

public class PrintPattern {

    static class Hold {
        int temp;

        public Hold(int x) {
            this.temp = x;
        }
    }

    static ArrayList<Integer> pattern(int n) {
        Hold h = new Hold(n);
        ArrayList<Integer> al = new ArrayList<>();
        add(al, h);
        h.temp += 5;
        add2(al, n, h);
        return al;
    }


    static void add(ArrayList<Integer> al, Hold h) {

        if (h.temp <= 0) {
            al.add(h.temp);
            return;
        }
        al.add(h.temp);
        h.temp -= 5;
        add(al, h);
    }

    static void add2(ArrayList<Integer> al, Integer n, Hold h) {

        if (h.temp == n) {
            al.add(n);
            return;
        }
        al.add(h.temp);
        h.temp += 5;
        add2(al, n, h);

    }

    public static void main(String[] args) {

        ArrayList<Integer> al = pattern(16);
        for (int x : al) {
            System.out.print(x + " ");
        }
    }
}
