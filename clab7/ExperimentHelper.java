import sun.awt.SunHints;

import java.security.Key;

/**
 * Created by hug.
 */
public class ExperimentHelper {
    private static final double MAX_VALUE = 2147483647;
    /** Returns the internal path length for an optimum binary search tree of
     *  size N. Examples:
     *  N = 1, OIPL: 0
     *  N = 2, OIPL: 1
     *  N = 3, OIPL: 2
     *  N = 4, OIPL: 4
     *  N = 5, OIPL: 6
     *  N = 6, OIPL: 8
     *  N = 7, OIPL: 10
     *  N = 8, OIPL: 13
     */
    public static int optimalIPL(int N)  {
        if(N <= 0){
           return N;
        }
        int deep = (int)(Math.log10(N)/Math.log10(2));
        int calculatedN = 0; /* record how many nodes have already been calculated*/
        int OIPL = 0;
        int nodeInlast =0;/* record the nodes in last layer*/
        for(int i=0;i<deep;i++){
            OIPL += Math.pow(2,i)*i;
            calculatedN += Math.pow(2,i);
        }
        nodeInlast = N-calculatedN;
        OIPL += nodeInlast*deep;
        return OIPL;
    }

    /** Returns the average depth for nodes in an optimal BST of
     *  size N.
     *  Examples:
     *  N = 1, OAD: 0
     *  N = 5, OAD: 1.2
     *  N = 8, OAD: 1.625
     * @return
     */
    public static double optimalAverageDepth(int N) {

        return (double)(1.0*optimalIPL(N)/N);
    }


    /* create BST insert n items randomly*/
    public static BST<Integer> getRandomBST(int n) {
        BST<Integer> b1 = new BST<>();
        for(int i=0;i<n;i++){
            InsertRandomItem(b1);
        }
        return b1;
    }

    /*randomly insert an item to a Integer tree*/
    public static void InsertRandomItem(BST<Integer> b){
        int insertkey = (int)(Math.random()*MAX_VALUE);
        while(b.contains(insertkey)){
            insertkey = (int)(Math.random()*MAX_VALUE);
        }
        b.add(insertkey);
    }

    public static void main(String[] args){
        for(int i=1;i<17;i++){
            System.out.println(optimalIPL(i));
            System.out.println(optimalAverageDepth(i));
        }

    }
}
