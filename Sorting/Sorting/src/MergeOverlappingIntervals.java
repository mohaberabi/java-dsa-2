import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {


    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }


        @Override
        public String toString() {
            return "start->" + start + " " + "end-> " + end;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }
    }


    static void mergeOverLappingIntervals(Interval[] intervals) {
        Arrays.sort(intervals);
        int n = intervals.length;
        int res = 0;
        for (int i = 1; i < n; i++) {

            if (intervals[res].end >= intervals[i].start) {
                intervals[res].end = Math.max(intervals[res].end, intervals[i].end);
                intervals[res].start = Math.min(intervals[res].start, intervals[i].start);
            } else {
                res++;
                intervals[res] = intervals[i];
            }
        }


    }


    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(5, 10),
                new Interval(3, 15),
                new Interval(18, 30),
                new Interval(2, 7),

        };
        mergeOverLappingIntervals(intervals);
        for (Interval i : intervals) {
            System.out.println(i.toString());
        }
    }
}
