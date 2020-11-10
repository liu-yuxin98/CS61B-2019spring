import org.omg.CORBA.ObjectHelper;

public class Solution {
    public static void testHash()
    {
        System.out.println("A:" + ((int)'A'));
        System.out.println("B:" + ((int)'B'));
        System.out.println("a:" + ((int)'a'));

        System.out.println("A".hashCode());
        System.out.println("a".hashCode());
        System.out.println("B".hashCode());
        System.out.println("b".hashCode());



        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());


        System.out.println("AaAa".hashCode());
        System.out.println("BBBB".hashCode());
        System.out.println("AaBB".hashCode());
        System.out.println("BBAa".hashCode());

    }


    public static String[] getStringsInSameHashCode(int number){
        String[] result = new String[number];
        //return an array in length "number"
        //Every element of the array share the same hashcode.
        //The element should be different from each other
        String s1 = "Aa";
        String s2 = "BB";
        for(int i=0;i<number;i++){

           boolean flag = false;
           while(flag){
               String s = generate(s1,s2,number);
               /* if results contains same s*/
               for(int j=0;j<i;j++){
                   if(result[j] == s){
                        flag = true; /* contains the same s*/
                        break;
                   }
               }
           }

           result[i] =generate(s1,s2,number);

        }

        return result;
    }



    /* 使用 x个s1,y个s2产生一个string,x+y=n*/
    public static String generate(String s1, String s2,int n){
        String res = "";
        for(int i=0;i<n;i++){
            double chance = Math.random();
            if(chance>0.5){
                res += s1;
            } else{
                res += s2;
            }
        }
        return res;
    }


    public static void main(String[] args){

        String[] res = getStringsInSameHashCode(3);
        for(int i=0;i< res.length;i++){
            System.out.println(res[i]);
        }

    }
}
