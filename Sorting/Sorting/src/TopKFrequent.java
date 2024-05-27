import java.util.*;

public class TopKFrequent {

    static public int[] topK(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int[] res = new int[k];


        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> (b.getValue() - a.getValue()) == 0 ? b.getKey() - a.getKey() : b.getValue() - a.getValue());


        int index = 0;
        for (int i = 0; i < k; i++) {
            res[index] = list.get(i).getKey();
            index++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 3, 4};
        int[] res = topK(nums, 2);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
