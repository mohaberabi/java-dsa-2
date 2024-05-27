public class SumOfDigits {

    int sumOFDigits ( int n){
        if (n<=9){
            return n;
        }
        else {
            return  sumOFDigits(n/10)+n%10;
        }
    }

  static   int sumOFDigitsIterative ( int n ){
        int res = 0 ;
        while (n>=0){
            res +=n%10;
            n = n/10 ;
        }
        return res ;
    }

    public static  void main (String []args){

    }
}
