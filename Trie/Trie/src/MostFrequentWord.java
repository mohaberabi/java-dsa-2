import java.util.Arrays;

public class MostFrequentWord {


    static class FreqNode {
        int count;
        int firstIndex;
        FreqNode[] children;

        FreqNode() {
            count = 0;
            firstIndex = 0;
            children = new FreqNode[26];
            Arrays.fill(children, null);
        }
    }

    static String mostFrequent(String[] arr, int n) {
        String res = "";


        int maxCount = 0;
        int resFirstAppear = 0;

        FreqNode node = new FreqNode();


        for (int i = 0; i < n; i++) {
            FreqNode curr = node;
            for (int j = 0; j < arr[i].length(); j++) {
                int index = arr[i].charAt(j) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new FreqNode();
                }
                curr = curr.children[index];
            }
            curr.count++;
            if (curr.count == 1) {
                curr.firstIndex = i;
            }

            if (curr.count > maxCount || (curr.count == maxCount && curr.firstIndex > resFirstAppear)) {

                res = arr[i];
                maxCount = curr.count;
                resFirstAppear = curr.firstIndex;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"geeks", "for", "geeks"};

        String res = mostFrequent(arr, arr.length);
        System.out.println(res);
    }

}
