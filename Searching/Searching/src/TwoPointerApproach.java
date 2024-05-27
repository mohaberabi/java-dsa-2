public class TwoPointerApproach {





    boolean pairHasSum ( int []arr , int n  , int sum ){


        int low = 0 ;
        int high = n-1 ;
        while (low < high){

            if(arr[low ]+arr[high]==sum){
                return true ;
            }
         else    if (arr[low]+arr[high]>sum ){
                high -- ;
            }
            else{
                low ++;
            }
        }
return  false ;
    }
}
