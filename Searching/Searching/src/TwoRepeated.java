public class TwoRepeated {
    public static int[] findRepeatedElements(int[] arr) {
        int[] ans = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]);
            if (arr[index] < 0) {
                ans[idx] = index;
                idx++;
            } else {
                arr[index] = -arr[index];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }

        return ans;
    }
}
