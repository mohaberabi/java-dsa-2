import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ActivitySelection {


    static class Activity implements Comparable<Activity> {
        int start;
        int end;

        public Activity(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Activity o) {
            return end - o.end;
        }
    }


    static int maximumAcitivities(ArrayList<Activity> activities) {

        Collections.sort(activities);

        int ans = 1;
        int prev = 0;

        for (int i = 1; i < activities.size(); i++) {

            Activity curr = activities.get(i);
            if (curr.start > activities.get(prev).end) {
                ans++;
                prev = i;
            }

        }
        return ans;
    }


    public static void main(String[] args) {


        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity(10, 20));
        activities.add(new Activity(20, 30));


        int res = maximumAcitivities(activities);
        System.out.println(res);
    }

}
