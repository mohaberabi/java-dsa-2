public class PalindromeNumber {

    boolean numberPlaindrome ( int x ){
        int rev = 0 ;
        int temp = x ;
        while (temp!=0){

            int last = temp%10 ;
            rev = rev*10+last ;
            temp = temp/10;
        }
        return  rev == x ;
    }
}
