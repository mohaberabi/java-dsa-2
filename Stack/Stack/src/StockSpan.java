import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {


    void printSpanNaive(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) {
                span++;
                System.out.println(span);
            }
        }
    }

    void stockSpan(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();


        stack.push(0);
        System.out.println(1);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int span = stack.isEmpty() ? i + 1 : i - stack.peek();
            System.out.println(span);
            stack.push(i);
        }

    }
}
