import org.junit.Test;
import static org.junit.Assert.*;

/* test all the method in ArrayDeque and LinkedListDeque works well*/
public class TestDeque {
    @Test  /* test IsEmpty*/
    public void TestIsEmpty(){
        /* ArrayDeque*/
        ArrayDeque<Integer> Ad1 = new ArrayDeque<Integer>();
        boolean actual1 = Ad1.IsEmpty();
        assertEquals(true,actual1);
        /* LinkedListDeque*/
        LinkedListDeque<Integer> Ld1 = new LinkedListDeque<>();
        boolean actual2 = Ld1.IsEmpty();
        assertEquals(true,actual2);
        /* Deque*/


    }
    @Test  /*test addFirst,addLast,get,Size,print for AD and LLD*/
    public void TestaddFirstLastGetSize(){
        /* ArrayDeque*/
        ArrayDeque<Integer> Ad1 = new ArrayDeque<Integer>();
        Ad1.addFirst(2);
        int actual1 =Ad1.get(0);
        int expected1 = 2;
        assertEquals(expected1,actual1);
        Ad1.addLast(3); /* adlast for AD*/
        int actuallast = Ad1.get(1);
        int expectedlast = 3;
        assertEquals(expectedlast,actuallast);
        int actualsize1 = Ad1.size();
        int expectedsize1 = 2;
        assertEquals(expectedsize1,actualsize1);
        Ad1.printDeque();

        /* LinkedListDeque*/
        LinkedListDeque<Integer> Ld1 = new LinkedListDeque<>();
        Ld1.addFirst(1);
        int actual2 = Ld1.get(0);
        int expected2 = 1;
        assertEquals(expected2,actual2);
        Ld1.addLast(5);
        int actual3 = Ld1.get(1);
        int expected3 = 5;
        assertEquals(expected3,actual3);
        int actualsize = Ld1.size();
        int expectedsize = 2;
        assertEquals(expectedsize,actualsize);
        Ld1.printDeque();
    }
    @Test
    public void TestRemove(){
        /* ArrayDeque*/
        ArrayDeque<Integer> Ad1 = new ArrayDeque<Integer>();
        assertNull(Ad1.removeFirst());
        assertNull(Ad1.removeLast());
        Ad1.addFirst(1);
        Ad1.addFirst(0);
        Ad1.addLast(2);
        Ad1.addLast(3);
        int actualfirst1 = Ad1.removeFirst();
        assertEquals(0,actualfirst1);
        int actuallast1 = Ad1.removeLast();
        assertEquals(3,actuallast1);
        /* LinkedListDeque*/
        LinkedListDeque<Integer> Ld1 = new LinkedListDeque<>();
        assertNull(Ld1.removeFirst());
        assertNull(Ld1.removeLast());
        Ld1.addFirst(1);
        Ld1.addFirst(0);
        Ld1.addLast(2);
        Ld1.addLast(3);
        int actualfirst2 = Ld1.removeFirst();
        assertEquals(0,actualfirst2);
        int actuallast2 = Ld1.removeLast();
        assertEquals(3,actuallast2);
    }



}
