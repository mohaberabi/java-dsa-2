public class TrailingZeros {


    int trailingZerosNaive ( int x ){
        int fact =1 ;

        for (int i=2 ; i<= x ; i ++){
            fact*= i ;
        }

        int res = 0 ;
        while (fact%10 ==0){
            res ++;
            fact = fact/10 ;
        }
        return res ;
    }

    int trailingZerosOptimal( int x ){
        int res = 0 ;

        for (int i =5 ; i<=x ; i=i*5){
            res  = res + (x/i);
        }
        return  res ;
    }
}
