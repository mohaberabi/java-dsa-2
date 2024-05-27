public class BinarySearchIterative {



    int search ( int  []arr , int n , int x ){
        int low = 0 ;
        int high = n-1;
        int mid = (low +high)/2 ;

        while (low<=high){
            if (arr[mid]==x){
                return mid  ;
            }

            else if (arr[mid]>x){
                high = mid -1 ;
            }
            else {
                low = mid +1 ;
            }
        }
        return -1 ;
    }
 static    int search ( int  []arr , int n , int x, int low , int high ){

        int mid = (low +high)/2 ;

        while (low<=high){
            if (arr[mid]==x){
                return mid  ;
            }

            else if (arr[mid]>x){
                high = mid -1 ;
            }
            else {
                low = mid +1 ;
            }
        }
        return -1 ;
    }
}
