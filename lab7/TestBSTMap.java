import static org.junit.Assert.*;
import org.junit.Test;

/** Tests by Brendan Hu, Spring 2015, revised for 2016 by Josh Hug */
public class TestBSTMap {

	@Test
    public void sanityGenericsTest() {
    	try {
    		BSTMap<String, String> a = new BSTMap<String, String>();
	    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
	    	BSTMap<Integer, String> c = new BSTMap<Integer, String>();
	    	BSTMap<Boolean, Integer> e = new BSTMap<Boolean, Integer>();
	    } catch (Exception e) {
	    	fail();
	    }
    }

    //assumes put/size/containsKey/get work
	@Test
    public void sanityClearTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1+i);
            //make sure put is working via containsKey and get
            assertTrue( null != b.get("hi" + i) && (b.get("hi"+i).equals(1+i))
                        && b.containsKey("hi" + i));
        }
        assertEquals(455, b.size());
        b.clear();
        assertEquals(0, b.size());
        for (int i = 0; i < 455; i++) {
            assertTrue(null == b.get("hi" + i) && !b.containsKey("hi" + i));
        }
    }

    // assumes put works
    @Test
    public void sanityContainsKeyTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        assertTrue(b.containsKey("waterYouDoingHere"));
    }

    // assumes put works
    @Test
    public void sanityGetTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertEquals(null,b.get("starChild"));
        assertEquals(0, b.size());
        b.put("starChild", 5);
        assertTrue(((Integer) b.get("starChild")).equals(5));
        b.put("KISS", 5);
        assertTrue(((Integer) b.get("KISS")).equals(5));
        assertNotEquals(null,b.get("starChild"));
        assertEquals(2, b.size());
    }

    // assumes put works
    @Test
    public void sanitySizeTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertEquals(0, b.size());
        b.put("hi", 1);
        assertEquals(1, b.size());
        for (int i = 0; i < 455; i++)
            b.put("hi" + i, 1);
        assertEquals(456, b.size());
    }

    //assumes get/containskey work
    @Test
    public void sanityPutTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("hi", 1);
        assertTrue(b.containsKey("hi") && b.get("hi") != null);
    }
    @Test
    public void Testprint(){
        BSTMap<Integer, String> b = new BSTMap<Integer, String>();
        b.put(1,"a");
        b.put(5,"b");
        b.put(2,"c");
        b.put(9,"ab");
        b.printInOrder();
    }

    @Test
    public void TestRemove_Min(){
        BSTMap<Integer, String> b = new BSTMap<Integer, String>();
        b.put(1,"a");
        b.put(5,"b");
        b.put(2,"c");
        b.put(9,"ab");
        System.out.println(b.getMin());
        b.remove(1);
        System.out.println(b.getMin());
        b.remove(2);
        System.out.println(b.getMin());
        b.remove(9);
        System.out.println(b.getMin());
        b.remove(5);
        System.out.println(b.getMin());
        b.put(5,"e");
        b.put(2,"b");
        b.put(1,"a");
        b.put(9,"i");
        b.remove(5);
    }




    @Test
    public void TestRemove(){
        BSTMap<Integer, String> b = new BSTMap<Integer, String>();
        b.put(3,"3");
        b.put(2,"2");
        b.put(1,"1");
        b.put(4,"4");
        b.remove(3);

        BSTMap<Integer, Integer> b2 = new BSTMap<Integer, Integer>();
        b2.put(3,3);
        b2.put(1,1);
        b2.put(2,2);
        b2.put(0,0);
        b2.put(4,4);
        b2.remove(3);

        BSTMap<Integer, Integer> b3 = new BSTMap<Integer, Integer>();
        b3.put(8,8);
        b3.put(5,5);
        b3.put(7,7);
        b3.put(6,6);
        b3.put(4,4);
        b3.put(1,1);
        b3.put(9,9);
        b3.remove(8);

        BSTMap<Integer, Integer> b4 = new BSTMap<Integer, Integer>();
        b4.put(12,12);
        b4.put(16,16);
        b4.put(8,8);
        b4.put(5,5);
        b4.put(7,7);
        b4.put(6,6);
        b4.put(4,4);
        b4.put(1,1);
        b4.put(9,9);
        b4.remove(8);
        int x = Integer.MIN_VALUE;
        System.out.println(x);
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestBSTMap.class);
    }
}
