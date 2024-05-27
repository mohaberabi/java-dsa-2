public class LastOccuerenceRecurisve {

    int lastAppearenceRecusrive ( int []arr , int low , int high, int x ){


        if (low >high){
            return -1;
        }

        int mid= (low+high)/2 ;


        if(arr[mid]>x){
            return lastAppearenceRecusrive(arr , low , mid -1 , x);
        }

        else if (arr[mid]<x){
            return lastAppearenceRecusrive(arr , mid +1 , high , x );
        }

        else {
            if (mid ==arr.length-1 ||arr[mid]!=arr[mid+1]){
               return mid ;
            }
            else {
                return lastAppearenceRecusrive(arr , mid +1 , high , x );

            }
        }
    }
}
