public class Factorial {


    int factorial ( int x){

        int fact =1 ;

        for (int i =2 ;i <=  x ;i++ ){
            fact = fact  *i;
        }
        return fact ;

    }

    int factorialRec( int x){
        if (x==0){
            return 1;
        }

        return x * factorialRec(x-1);
    }

}
