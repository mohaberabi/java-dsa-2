public class CelibrityProblem {


    static int celibrityProblem(int[][] mat) {


        for (int i = 0; i < mat.length; i++) {

            if (!hasOnes(mat[i])) {
                return i;
            }
        }
        return -1;


    }


    static boolean hasOnes(int[] arr) {


        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                return true;
            }

        }

        return false;

    }


    public static void main(String[] args) {

        int[][] mat = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        int ans = celibrityProblem(mat);
        System.out.println(ans);
    }
}
