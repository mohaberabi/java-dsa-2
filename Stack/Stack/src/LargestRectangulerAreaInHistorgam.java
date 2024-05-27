import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangulerAreaInHistorgam {


    int largestRecatnuglerAreaInHistorGramOptimal(int[] arr, int n) {


        Stack<Integer> s = new Stack<>();


        int res = 0;

        for (int i = 0; i < n; i++) {

            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                int top = s.pop();

                int curr = arr[top] * (s.isEmpty() ? i : (i - s.peek() - 1));

                res = Math.max(res, curr);
            }
            s.push(i);
        }


        while (!s.isEmpty()) {
            int top = s.pop();
            int curr = arr[top] * (s.isEmpty() ? n : (n - s.peek() - 1));
            res = Math.max(res, curr);
        }


        return res;
    }

    static int largestRecatunglerAreaInHistoGram(int[] arr, int n) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }

            }


            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }


    static ArrayList<Integer> previousSmallerElement(int[] arr, int n) {


        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        stack.push(arr[0]);
        for (int i = 1; i < n; i++) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            int prev = stack.isEmpty() ? -1 : stack.peek();
            ans.add(prev);
            stack.push(arr[i]);
        }
        return ans;
    }

    static ArrayList<Integer> nextSmallerElement(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);
        ArrayList<Integer> al = new ArrayList<>();
        al.add(-1);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            int ans = stack.isEmpty() ? n : stack.peek();
            al.add(ans);
            stack.push(arr[i]);
        }

        Collections.reverse(al);
        return al;
    }


    static int largestRectangulerAreaInHistogramBetterSolution(int[] arr, int n) {
        int res = 0;
        ArrayList<Integer> previousSmaller = previousSmallerElement(arr, n);
        ArrayList<Integer> nextSmaller = nextSmallerElement(arr, n);

        for (int x : previousSmaller) {
            System.out.print(x + " ");
        }
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            curr += (i - previousSmaller.get(i) - 1) * arr[i];
            curr += (nextSmaller.get(i) - i - 1) * arr[i];
            res = Math.max(res, curr);

        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 1, 5, 6};
        int res = largestRectangulerAreaInHistogramBetterSolution(arr, arr.length);
//        System.out.println(res);
    }
}
