import java.util.TreeMap;
import java.util.TreeSet;

public class SmallerOnRight {

    static class AugTree {

        AugTree left;
        AugTree right;
        int lh;
        int data;

        AugTree(int d) {
            lh = 0;
            data = d;
        }
    }

    static void findSmallerOnRight(int[] arr, int n) {

        TreeSet<Integer> set = new TreeSet<>();

        AugTree root = null;

        for (int x : arr) {
            root = insert(x, root);
        }


        inOrder(root, set);

        for (int x : set) {
            System.out.print(x + " ");
        }

    }

    static AugTree insert(int x, AugTree root) {

        if (root == null) {
            return new AugTree(x);
        }

        if (x > root.data) {
            root.right = insert(x, root.right);
        } else if (x < root.data) {
            root.lh++;
            root.left = insert(x, root.left);
        }
        return root;
    }

    static void inOrder(AugTree root, TreeSet<Integer> set) {
        if (root == null) {
            return;
        }

        inOrder(root.left, set);
        set.add(root.lh);
        inOrder(root.right, set);
    }

//    static void inOrder(AugTree root) {
//        if (root == null) {
//            return;
//        }
//
//        inOrder(root.left);
//        System.out.print(root.data + " and length of smaller " + root.lh);
//        System.out.println();
//        inOrder(root.right);
//    }

    public static void main(String[] args) {
        int[] arr = {10, 6, 9, 7, 20, 19, 21, 18, 17, 16};
        findSmallerOnRight(arr, arr.length);
    }

    void fromTestCase (){
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine().trim());
//
//        while(t-->0)
//        {
//            //taking inputs from user.
//            String inputLine[] = br.readLine().trim().split(" ");
//            int n = Integer.parseInt(inputLine[0]);
//            inputLine = br.readLine().trim().split(" ");
//            int[] arr = new int[n];
//            for(int i=0; i<n; i++){
//                arr[i]=Integer.parseInt(inputLine[i]);
//            }
//
//            //printing the result.
//            System.out.println(getMaxSmallerOnRight(arr, n));
//        }
    }
    }
}
