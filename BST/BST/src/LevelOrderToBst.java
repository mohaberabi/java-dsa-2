public class LevelOrderToBst {
    public Node constructBST(int[] arr)
    {
        if (arr.length==0){
            return null;
        }

        Node root = new Node(arr[0]);

        for ( int i = 1 ; i< arr.length;i++){
            insert(root,arr[i]);
        }
        return root ;
        //Write your code here
    }



    public   Node insert(Node root , int x){

        Node add = new Node (x);
        Node parent = null;
        Node curr =root ;
        while (curr!=null){
            parent = curr ;
            if(curr.data>x){
                curr=curr.left ;
            }
            else if (curr.data<x){
                curr = curr.right ;
            }
            else {
                return root ;
            }
        }


        if (parent ==null){
            return add;
        }
        if(x>parent.data){
            parent.right = add ;
        }else {
            parent.left = add;
        }
        return root ;
    }

}
