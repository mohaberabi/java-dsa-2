package OptimalStrategyForAGame;

public class OptimalStartegyRecursive1 {


    int subSolution(int[] arr, int i, int j, int sum) {
        if (j == i + 1) {
            return Math.max(arr[i], arr[j]);
        }

        int me = subSolution(arr, i + 1, j, sum - arr[i]);
        int he = subSolution(arr, i, j - 1, sum - arr[j]);
        return Math.max(sum - me, sum - he);
    }

    int strategy(int[] arr) {

        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return subSolution(arr, 0, arr.length - 1, sum);
    }
}
