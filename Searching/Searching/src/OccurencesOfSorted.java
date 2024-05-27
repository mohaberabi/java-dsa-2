public class OccurencesOfSorted {


    int occurencesOfSorted (int []arr , int x){
        int first = IndexOdFirstIterative.indexOfFirstIterative(arr ,arr.length, x );

        if (first==-1){
            return 0 ;
        }

        else {
            int  last = LastOccurenceIterative.indexOfLastIterative(arr , arr.length, x);
            return (last-first)+1;
        }
    }
}
