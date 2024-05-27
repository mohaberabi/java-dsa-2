package LCS;

public class LCSRecursive {



  static   int lcs (String a , String b , int n , int m ){
        if (n==0||m==0){
            return 0;
        }

        if (a.charAt(n-1)==b.charAt(m-1)){
            return  1+lcs(a , b , n-1 , m-1 );
        }
        else {
            int  first = lcs(a , b , n-1 , m );
            int second = lcs(a , b , n , m-1);
            return Math.max(first , second);
        }
    }


    public static void main(String [] args){
      int l = lcs("AXYZ","BAZ",4 ,3 );
        System.out.println(l);
    }
}
