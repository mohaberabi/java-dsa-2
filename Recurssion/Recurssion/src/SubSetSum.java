public class SubSetSum {


    int countSubSetsSum( int []arr , int n , int sum ){

        if (n==0){
            return  (sum==0)?1:0;
        }

        else {
            return countSubSetsSum(arr , n-1 , sum)+
                    countSubSetsSum(arr , n-1 , sum-arr[n-1]);
        }
    }
}
