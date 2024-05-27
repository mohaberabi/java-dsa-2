import java.util.*;

public class ElectionWinner {


    public static String[] winner(String arr[], int n) {


        HashMap<String, Integer> map = new HashMap();

        for (String x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }


        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue() == 0 ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        String[] ans = new String[1];
        ans[0] = list.get(0).getKey() + " " + list.get(0).getValue();
        return ans;
    }


    public static void main(String[] args) {

        String[] arr = {"john", "johnny", "jackie", "johnny", "john",
                "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
        String[] res = winner(arr, arr.length);


        for (String s : res) {
            System.out.println(s);
        }


    }
}
