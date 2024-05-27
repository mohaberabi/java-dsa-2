public class SimpleDequeue {




    int []arr ;
     int size ;
     int cap ;

     SimpleDequeue(int n ){
         arr = new int [n];
         cap = n ;
         size = 0 ;
     }



     boolean isEmpty(){return  size == 0 ; }


    boolean isFull (){return  size == cap ; }


    Integer  front (){
         if (isEmpty()){return  null;}

         return  arr[0];
    }


    Integer rear (){
         if (isEmpty()){return  null;}


         return  arr[size-1];
    }



    void addFront ( int x){
         if (isFull()){
             return;
         }


         for (int i  = size -1 ; i>=0;i--){
             arr[i+1] =arr[i];
         }
         arr[0]=x ;
         size ++;
    }


    void deleteFront (){
         if (isEmpty()){return;}
         for (int i =0 ; i < size-1 ; i ++){
             arr[i]=arr[i+1];
         }
         size --;
    }

    void deleteRear(){
         if (isEmpty()){
             return;
         }
         size --;

    }

    void addRear(int x ){
         if (isFull()){
             return;
         }
         arr[size]=x;
         size ++;

    }
}
