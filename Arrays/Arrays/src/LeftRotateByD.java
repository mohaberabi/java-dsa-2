import java.time.chrono.HijrahEra;

public class LeftRotateByD {


    void leftRotateByOne (int [] arr , int n ){
        int temp = arr[0];
        for (int i = 1 ; i < n ; i ++){
            arr[i-1]= arr[i];
        }

        arr[n-1]= temp;
    }

    void leftRoateByDMethod1 ( int []arr , int d , int n){
        for (int i =0 ; i < d ; i ++){
            leftRotateByOne(arr , n);
        }
    }

    void leftRotateByDMethod2 ( int [] arr , int  d , int n){
        int [] temp = new int [d];
        for (int i =0 ; i < d ; i ++){
            temp[i]= arr[i];
        }
        for (int i= d ; i < n ; i ++){
            arr[i-d]= arr[i];
        }
        for (int i =0 ; i < n ; i ++){
            arr[n-i-d]= temp[i];
        }
    }

    void leftRotateArrayByDMethod3( int [] arr , int n , int d ){
        Helpers.reverseArray(arr , 0, d- 1);
        Helpers.reverseArray(arr , d , n-1 );
        Helpers.reverseArray(arr , 0 , n-1 );
    }
}
