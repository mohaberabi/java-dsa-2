public class IndexOfFirstOccuerence {



    int indexOfFirst(int []arr , int low , int high , int x){
        if (low > high){
            return -1 ;
        }
        int mid = (low +high)/2 ;

       if (arr[mid]>x){
           return  indexOfFirst(arr , low , mid -1 , x);
       }
       else if (arr[mid]<x){
           return indexOfFirst(arr , mid +1 , high , x);
       }
       else {
           if (mid ==0 || arr[mid-1]!=arr[mid]){
               return mid;
           }
           else {
               return indexOfFirst(arr , low , mid -1 , x);
           }
       }
    }
}
