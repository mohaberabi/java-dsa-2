import java.util.Stack;

public class LargestRectangleWithAllOnes {


    static int largestAreaInHistoGram(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int top = stack.pop();

                int curr = arr[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));

                res = Math.max(curr, res);


            }

            stack.push(i);
        }


        while (!stack.isEmpty()) {
            int top = stack.pop();

            int curr = arr[top] * (stack.isEmpty() ? n : (n - stack.peek() - 1));
            res = Math.max(res, curr);
        }
        return res;

    }


    static int maxRectangleWithAllOnes(int[][] mat, int r, int c) {
        int res = largestAreaInHistoGram(mat[0], c);

        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
            res = Math.max(res, largestAreaInHistoGram(mat[i], c));

        }
        return res;
    }


    public static void main(String[] args) {
        int[][] mat = {{0, 1}, {1, 0}};

        int res = maxRectangleWithAllOnes(mat, 2, 2);
        System.out.println(res);
    }

}
