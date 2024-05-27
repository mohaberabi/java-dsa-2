public class TowerOfHanoi {




  static   void towerOfHanoi(int n , char a , char b , char c){
        if (n==1){
            System.out.println("move disc 1 from rod "+a+" to "+c);
            return;
        }

        towerOfHanoi(n-1 , a , c ,b );

        System.out.println("Move "+"form "+n+" "+a+" to "+c);
        towerOfHanoi(n-1 , b , a ,c );

    }

    static   void towerOfHanoiIntegers(int n , int  a , int  b , int  c){
        if (n==1){
            System.out.println("move disc 1 from rod "+a+" to rod "+c);
            return;
        }

        towerOfHanoiIntegers(n-1 , a , c ,b );

        System.out.println("move disc "+""+n+" from rod "+a+" to rod "+c);
        towerOfHanoiIntegers(n-1 , b , a ,c );

    }




    public  static  void main(String []args){

        towerOfHanoiIntegers(3 , 1,2,3);
    }
}
