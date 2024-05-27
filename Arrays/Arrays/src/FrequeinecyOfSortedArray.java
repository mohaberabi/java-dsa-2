public class FrequeinecyOfSortedArray {



    void printFreqOfSorted ( int [] arr , int n ){
        int freq = 1 ;
        int i =1 ;
        while (i<n ){
            while (i<n && arr[i]==arr[i-1]){
                freq ++;
                 i ++;
            }
            System.out.println(arr[i-1]+" "+freq);
            i++;
            freq++;
        }

        if (n==1 || arr[n-1]!=arr[n-2]){
            System.out.println(arr[n-1 ]+" 1 ");
        }
    }
}
