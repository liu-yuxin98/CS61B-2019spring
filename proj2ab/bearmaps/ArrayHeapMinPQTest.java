package bearmaps;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayHeapMinPQTest {

    @Test
    /* test size assume add remove works*/
    public void TestSize(){
        ArrayHeapMinPQ<Integer> minPQ1 = new ArrayHeapMinPQ<>();
        assertEquals(0,minPQ1.size());
        minPQ1.add(4,4.0);
        minPQ1.add(3,3.0);
        minPQ1.add(2,2.0);
        minPQ1.add(1,1.0);
        minPQ1.add(10,10.0);
        minPQ1.add(8,8.0);
        minPQ1.add(6,6.0);
        minPQ1.add(5,5.0);
        minPQ1.add(7,7.0);
        minPQ1.add(9,9.0);
        assertEquals(10,minPQ1.size());
    }
    @Test
    /* test size assume add remove works*/
    public void TestContains(){
        ArrayHeapMinPQ<Integer> minPQ1 = new ArrayHeapMinPQ<>();
        assertEquals(false,minPQ1.contains(1));
        minPQ1.add(4,4.0);
        minPQ1.add(3,3.0);
        minPQ1.add(2,2.0);
        minPQ1.add(1,1.0);
        assertEquals(true,minPQ1.contains(2));
        minPQ1.add(10,10.0);
        minPQ1.add(8,8.0);
        minPQ1.add(6,6.0);
        minPQ1.add(5,5.0);
        minPQ1.add(7,7.0);
        minPQ1.add(9,9.0);
        assertEquals(true,minPQ1.contains(9));
        assertEquals(false,minPQ1.contains(89));
    }

    @Test
    /* test speed*/
    public void TestSpeed(){
        ArrayHeapMinPQ<Integer> minPQ1 = new ArrayHeapMinPQ<>();
        int n = 1000000;
        int m = (int)(Math.random()*n);
        double p = Math.random()*m;

        /* ArrayHeapMinPQ*/
        long start = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            minPQ1.add(i,i*1.0);
        }
        long end = System.currentTimeMillis();
        System.out.println("MinPQ add "+n+" times : "+ (end - start)/1000.0 +  " seconds.");
        /* changePriority*/
        start = System.currentTimeMillis();
        minPQ1.changePriority(m,p);
        end = System.currentTimeMillis();
        System.out.println("MinPQ changePriority takes : "+ (end - start)/1000.0 +  " seconds.");
        /* contains*/
        start = System.currentTimeMillis();
        minPQ1.contains(m);
        end = System.currentTimeMillis();
        System.out.println("MinPQ contains takes : "+ (end - start)/1000.0 +  " seconds.");


        /* NaiveMinPQ*/
        NaiveMinPQ<Integer> nPQ1 = new NaiveMinPQ<>();
        start = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            nPQ1.add(i,i*1.0);
        }
        end = System.currentTimeMillis();
        System.out.println("NaivePQ add "+n+" times : "+ (end - start)/1000.0 +  " seconds.");
        /* changePriority*/
        start = System.currentTimeMillis();
        nPQ1.changePriority(m,p);
        end = System.currentTimeMillis();
        System.out.println("NaivePQ changePriority takes : "+ (end - start)/1000.0 +  " seconds.");
        /* contains*/
        start = System.currentTimeMillis();
        nPQ1.contains(m);
        end = System.currentTimeMillis();
        System.out.println("NaivePQ changePriority takes : "+ (end - start)/1000.0 +  " seconds.");
    }


}
