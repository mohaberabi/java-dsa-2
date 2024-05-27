public class JospehusProblem {


    int jos(int n ,int k ){
        if (n==1){
            return 0;
        }

        else {
            return  (jos(n-1,k)+k)%n;
        }
    }


    int josWithStartAt1(int n ,int k ){

        return jos(n,k)+1;
    }
}
