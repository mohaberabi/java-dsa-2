public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[]arr = {0,1,2,3,4,5};
        int n = arr.length;

        for (int i =3 ; i< n-1 ; i ++){
            arr[i]=arr[i+1];
        }

        for (int x : arr){
            System.out.print(x+" ");
        }
    }
}