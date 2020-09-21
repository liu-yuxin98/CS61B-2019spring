public class Lists1Exercises {

    /* test incrList*/
    public static void TestincrList(IntList L, IntList newl,int x){
        boolean finishedForLoop = true;
        for(int i=0;i<L.size();i++){
            System.out.print(newl.get(i)+" ");
            System.out.print(L.get(i));
            System.out.println("\n");
            if(newl.get(i)!=L.get(i)+x){
                System.out.println("failed!");
                finishedForLoop = false;
                break;
            }
        } 
        if(finishedForLoop){
            System.out.println("successful!");
        }
        
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public  static IntList incrList(IntList L, int x) {
        /* Your code here. */
        /* recursion*/
        if(L ==null){
            return L;
        }else{
            IntList newl = new IntList(L.first + x, incrList(L.rest, x));
            return newl;
        }
         
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        if(L.rest ==null){ /* base case*/
            L.first += 3;
            return L;
        }else{
            L.first += 3;/* 改变目前L的first*/
            dincrList(L.rest,x); /* 改变L.rest,函数作用后的L.rest中每一项都加了x*/
            return L;
        }
  
    }

    public static void main(String[] args) {
         IntList L = new IntList(15, null);
         L = new IntList(10, L);
         L = new IntList(5, L);
         L = new IntList(0, L);

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.

        /*test incrList*/
        // IntList newl = incrList(L,3);
        // TestincrList(L,newl,3);

        L = dincrList(L,3);
        for(int i=0;i<L.size();i++){
            System.out.println(L.get(i));
        }
        // System.out.println(dincrList(L, 3));        
    }
}