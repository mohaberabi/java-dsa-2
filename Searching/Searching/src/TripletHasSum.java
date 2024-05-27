public class TripletHasSum {




    boolean tripletHasSum ( int []arr , int n , int sum ){


        for (int i = 0 ; i < n-2  ; i ++){

            if (pairHasSum(arr , n , sum-arr[i],i+1)){
                return true ;
            }
        }

        return  false ;
    }

    boolean pairHasSum ( int []arr , int n  , int sum , int start  ){

        int low = start  ;
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
