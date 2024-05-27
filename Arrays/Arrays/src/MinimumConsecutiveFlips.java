public class MinimumConsecutiveFlips {


    void printMinimumFlips(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] != arr[0]) {
                    System.out.print("from " + i + "to ");
                } else {
                    System.out.print(i - 1);
                }
            }
        }
        if (arr[n - 1] != arr[0]) {
            System.out.println(n - 1);
        }
    }
}
