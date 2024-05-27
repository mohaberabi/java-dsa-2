import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByAbosulteDifference {


    static void sortABS(List<Integer> arr, int n, int k) {


        arr.sort((a, b) -> Integer.compare(Math.abs(a - k), Math.abs(b - k)));


    }


    public static void main(String[] args) {

        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        ans.add(3);
        ans.add(4);
        ans.add(5);

        sortABS(ans, ans.size(), 7);
        for (int x : ans) {
            System.out.print(x + " ");
        }

    }
}
