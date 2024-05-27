public class LeadersOfArray {


    void leadersOfArrayOptimal(int[] arr, int n) {
        int currentLeader = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > currentLeader) {
                currentLeader = arr[i];
                System.out.println(currentLeader);
            }
        }
    }

    void leadersOfArrayOptimalSameOrderOfAppearence(int[] arr, int n) {
        int currentLeader = arr[n - 1];


        int[] leaders = new int[n];
        int k = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > currentLeader) {
                currentLeader = arr[i];
                leaders[k] = currentLeader;
                k++;
            }
        }

        for (int leader : leaders) {
            System.out.println(leader);
        }
    }

    void leadersOFArrayNaive(int[] arr, int n) {


        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] <= arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(arr[i]);
            }
        }
    }
}
