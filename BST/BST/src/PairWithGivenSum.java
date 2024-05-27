import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PairWithGivenSum {


    boolean pairWithGivenSum(Node root, int sum) {

        if (root == null) {
            return false;
        }

        ArrayList<Integer> al = new ArrayList<>();
        inOrder(root, al);
        int i = 0;
        int j = al.size() - 1;


        while (i < j) {
            int curr = al.get(i) + al.get(j);
            if (curr == sum) {
                return true;
            } else if (curr > sum) {
                j--;
            } else {
                i++;
            }
        }

        return false;

    }


    boolean isSumExist2(Node root, int sum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (isSumExist2(root.left, sum, set)) {
            return true;
        }

        if (set.contains(sum - root.data)) {
            return true;
        } else {
            set.add(root.data);
        }
        return isSumExist2(root.right, sum, set);
    }

    void inOrder(Node root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        inOrder(root.left, al);
        al.add(root.data);
        inOrder(root.right, al);
    }
}