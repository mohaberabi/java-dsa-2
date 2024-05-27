public class GCD {


    int gcdNaive ( int a , int b ){
        int res= Math.min(a , b);
        while (res > 0){
            if (a%res ==0 && b% res ==0){
                break;
            }
            res--;
        }

        return  res ;
    }


    int euclideanAlgorithm1GCD (  int a , int b){
        while (a!=b){
            if (a>b){
                a= a-b ;
            }
            else {
                b = b-a ;
            }
        }
        return  a ;
        //aso return b  is valid ;
    }
    int euclideanAlgorithm2OptimizedGCD (  int a , int b){

        if (a==0){
            return  a;
        }
        else {
            return  gcdNaive(b , a%b);
        }
    }
}
