import java.util.Stack;

public class PrevousGreaterElement {


    void printPreviousGreaterElementNaive(int[] arr, int n) {
        System.out.println(-1);


        for (int i = 1; i < n; i++) {
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    System.out.println(arr[j]);
                    break;
                }
            }

            if (j == -1) {
                System.out.println(-1);
            }
        }
    }

    void printPreviousGreaterElementOptimal(int[] arr, int n) {
        System.out.println(-1);


        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);


        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }


            int ans = stack.isEmpty() ? -1 : stack.peek();
            System.out.println(ans);
            stack.push(arr[i]);
        }

    }
}
