public class MoveZerosToEnd {


    void moveZerosToEndNaive ( int [] arr , int n ){
        for (int i = 0 ; i < n ; i ++){
            if (arr[i]==0){
                for (int j = i +1; j< n ; j ++){
                    if (arr[j]!=0){
                        Helpers.swapArr(arr , i , j);
                    }
                }
            }
        }
    }



    void moveZerosToEndOptimal ( int  []arr , int n ){
        int count = 0 ;
        for ( int i = 0 ; i < n ; i ++){
            if (arr[i]!=0){
                Helpers.swapArr(arr , i , count );
                count ++;
            }
        }
    }
}
