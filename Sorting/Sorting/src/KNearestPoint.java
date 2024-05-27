import java.util.ArrayList;
import java.util.Collections;

public class KNearestPoint {


    static class Pair {
        int first;
        int second;


        public Pair(int f, int s) {
            first = f;
            second = s;
        }

        @Override
        public String toString() {
            return "(" + first + " " + second + ")";
        }

    }

    public static ArrayList<Pair> kNeighbourPoints(ArrayList<Pair> points, Pair P, int K) {

        Collections.sort(points, (a, b) -> Integer.compare(a.first - P.first, b.second - P.second));

        ArrayList<Pair> ans = new ArrayList();
        for (int i = 0; i < K; i++) {
            ans.add(points.get(i));
        }

        return ans;
    }


    public static void main(String[] args) {


        ArrayList<Pair> points = new ArrayList<>();

        points.add(new Pair(-2, 1));
        points.add(new Pair(0, 0));
        points.add(new Pair(1, 4));
        points.add(new Pair(-1, 0));
        points.add(new Pair(1, 1));

        ArrayList<Pair> list = kNeighbourPoints(points, new Pair(0, 0), 3);

        for (Pair pair : list) {
            System.out.println(pair.toString());
        }
    }
}
