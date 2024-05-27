public class IndexOfSecondLargestElement {


    int indexOfSecondLargestElement ( int []arr  , int n){
        int res = -1 ;
        int largest = 0 ;

        for (int i =1 ; i < n ; i ++){
            if(arr[i]>arr[largest]){
                res = largest ;
                largest = i ;
            }

            else if (arr[i]!=arr[largest]){

                if (res ==-1 || arr[i]>arr[res]){
                    res = i ;
                }
            }
        }
        return res;
    }
}
