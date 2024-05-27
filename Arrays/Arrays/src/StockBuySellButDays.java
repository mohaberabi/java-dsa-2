import java.util.ArrayList;
import java.util.Arrays;

public class StockBuySellButDays {
    static ArrayList<ArrayList<Integer>> stockBuySell(int arr[], int n) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (n < 2) {
            return ans; // There are not enough elements to buy and sell stocks.
        }

        int buyDay = 0;
        for (int sellDay = 1; sellDay < n; sellDay++) {
            if (arr[sellDay] > arr[buyDay]) {
                ArrayList<Integer> transaction = new ArrayList<>();
                transaction.add(buyDay);
                transaction.add(sellDay);
                ans.add(transaction);
            }
            buyDay = sellDay; // Update the buy day to the current day for the next iteration.
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        ArrayList<ArrayList<Integer>> ans = stockBuySell(arr, arr.length);
        for (ArrayList<Integer> al : ans) {
            for (int x : al) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
