public class RopeCuttingProblem {
    
    
    
    
    
    
    
    
    
    
    
    int maxCuts ( int n , int a , int b, int c ){
        if (n==0){
            return 0;
        }
        if (n<0){
            return -1 ; 
        }
        
        
        int res = Math.max(maxCuts(n-a , a , b ,c ),
                Math.max(maxCuts(n-b , a , b ,c ),
                        maxCuts(n-c, a , b ,c )));

        return  res +1 ;
    }
}
