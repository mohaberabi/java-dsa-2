//public class PreOrderToPostOrder {
//    public static Node post_order(int pre[], int size)
//    {
//
//
//
//
//        if (size ==0){
//            return null;
//        }
//
//        Node root = new Node (pre[0]);
//
//        for ( int i =1 ; i <size ; i++){
//            insert(root,pre[i]);
//        }
//
//
//        return root ;
//        //Your code here
//    }
//
//
//
//
//    public static Node insert(Node root , int x){
//
//        Node add = new Node (x);
//        Node parent = null;
//        Node curr =root ;
//        while (curr!=null){
//            parent = curr ;
//            if(curr.data>x){
//                curr=curr.left ;
//            }
//            else if (curr.data<x){
//                curr = curr.right ;
//            }
//            else {
//                return root ;
//            }
//        }
//
//
//        if (parent ==null){
//            return add;
//        }
//        if(x>parent.data){
//            parent.right = add ;
//        }else {
//            parent.left = add;
//        }
//        r
//}
