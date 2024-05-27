import java.util.HashMap;
import java.util.Map;

public class FibonaciMemoziation {

static  final Map<Integer,Integer> memo = new HashMap<>();

 static    int fib ( int n ){
        if (!memo.containsKey(n)){
            int res ;
            if (n==0||n==1){
                res = n ;
            }
            else {
                res = fib(n-1)+fib(n-2);
            }
            memo.put(n,res);
        }
        return  memo.get(n);
    }

    public static void main(String []args){
     int n = 10;

     int f = fib(n);

        System.out.println(f);
    }
}
