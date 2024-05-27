import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class JobSequenceProblem {


    static class Pair implements Comparable<Pair> {
        int deadline;
        int profit;

        public Pair(int d, int p) {
            deadline = d;
            profit = p;
        }

        @Override
        public int compareTo(Pair other) {
            return other.profit - this.profit;
        }
    }


    public void maxProfit(ArrayList<Pair> jobs) {

        Collections.sort(jobs);
        int total = 0;
        int done = 0;
        int n = jobs.size();
        boolean[] slot = new boolean[n];


        for (int i = 1; i < jobs.size(); i++) {

            int k = Math.min(n, jobs.get(i).deadline - 1);

            for (int j = k; j >= 0; j--) {
                if (!slot[j]) {
                    total += jobs.get(i).profit;
                    done++;
                    slot[j] = true;
                    break;
                }
            }

        }

        System.out.println("total profit :" + total + " and total done is :" + done);

    }
}
