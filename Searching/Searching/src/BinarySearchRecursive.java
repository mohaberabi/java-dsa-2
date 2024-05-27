public class BinarySearchRecursive {

 static    int search ( int  []arr , int low, int high , int x){
        if (low>high){
            return -1 ;
        }

        int mid = (low + high)/ 2 ;

        if (arr[mid]==x){
            return mid ;
        }

        else if (arr[mid]>x){
            return search(arr , low , mid -1 , x );
        }
        else {
            return search(arr , mid +1 , high , x );
        }
    }
}
