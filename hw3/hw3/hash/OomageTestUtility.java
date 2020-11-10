package hw3.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */

        /* store the hascode of each oomage into a map
        * so that we can count the numbers of oomage in each bucket*/
        int N = oomages.size();
        Map<Integer,Integer> bucketNums = new HashMap<Integer,Integer>();
        for (Oomage oomage : oomages) {
            int bucketNum = (oomage.hashCode() & 0x7FFFFFFF) % M;
            if (bucketNums.containsKey(bucketNum)) {
                int times = bucketNums.get(bucketNum) + 1;
                bucketNums.put(bucketNum, times);
            } else {
                bucketNums.put(bucketNum, 1);
            }
        }

        for(int i=0;i<bucketNums.size();i++){
            if(bucketNums.get(i)<N/50 || bucketNums.get(i)>N/2.5){
                return false;
            }
        }
        return true;
    }
}
