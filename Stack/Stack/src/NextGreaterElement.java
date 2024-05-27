import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {


    void printNextGreaterElementNaive(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int j;
            for (j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    System.out.println(arr[j]);
                    break;
                }
            }
            if (j == n) {
                System.out.println(-1);
            }
        }
    }


    void printNextGreaterElementOptimal(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);
        System.out.println(-1);


        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            int ans = stack.isEmpty() ? -1 : stack.peek();
            System.out.println(ans);
            stack.push(arr[i]);
        }
    }

    void printNextGreaterElementOptimalInCorrectOrder(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);


        ArrayList<Integer> al = new ArrayList<>();
        al.add(-1);


        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            int ans = stack.isEmpty() ? -1 : stack.peek();
            al.add(ans);
            stack.push(arr[i]);
        }

        Collections.reverse(al);
        for (int x : al) {
            System.out.print(x + " ");
        }
    }
}
