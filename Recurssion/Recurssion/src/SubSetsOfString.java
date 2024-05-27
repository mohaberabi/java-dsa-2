import java.util.ArrayList;

public class SubSetsOfString {


    void subSets ( char []s ,String curr , int i  ){


        if (i==s.length){
            System.out.println(curr);
            return;
        }
        subSets(s , curr,i+1);

        subSets(s , curr+s[i],i+1);
    }



    static    ArrayList<String> powerSet(String s)
    {

        ArrayList<String>ans = new ArrayList();

subSetsTwo(s.toCharArray(),"",0,ans);
return  ans ;
    }

  static   void   subSetsTwo( char []s ,String curr , int i, ArrayList<String>ans   ){


        if (i==s.length){
           ans.add(curr);
            return;
        }
        subSetsTwo(s , curr,i+1,ans );

        subSetsTwo(s , curr+s[i],i+1,ans );
    }

    public  static  void main (String []args){

        ArrayList<String >pow =powerSet("abc");
        for (String s : pow ){
            System.out.println(s);
        }
    }
}
