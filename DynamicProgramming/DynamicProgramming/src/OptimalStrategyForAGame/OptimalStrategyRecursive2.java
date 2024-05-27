package OptimalStrategyForAGame;

public class OptimalStrategyRecursive2 {


    int strategy(int[] arr, int i, int j) {
        if (i == j + 1) {

            return Math.max(arr[i], arr[j]);
        }


        int heChoice1 = Math.min(strategy(arr, i + 2, j), strategy(arr, i + 1, j - 1));

        int firstMe = arr[i] + heChoice1;

        int heChoice2 = Math.min(strategy(arr, i + 1, j - 1), strategy(arr, i, j - 2));

        int secondMe = arr[j] + heChoice2;

        return Math.max(firstMe, secondMe);

    }
}
