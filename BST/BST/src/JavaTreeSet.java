import java.util.TreeSet;

public class JavaTreeSet {


    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet();

        set.add(100);
        set.add(-1);
        set.add(1000);
        set.add(0);

        for (int x : set) {
            System.out.println(x);
        }

    }
}
