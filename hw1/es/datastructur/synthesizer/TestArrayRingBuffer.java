package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void TestEmptyFullEnqueueDequePeek() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(4);
        assertTrue(arb.isEmpty());
        arb.enqueue(2);
        assertEquals(0,arb.peek()-2);
        arb.dequeue();
        assertTrue(arb.isEmpty());
        arb.enqueue(2);
        arb.enqueue(3);
        assertFalse(arb.isFull());
        arb.enqueue(4);
        assertEquals(0,arb.peek()-2);
        arb.enqueue(5);
        assertTrue(arb.isFull());
        arb.dequeue();
        assertEquals(0,arb.peek()-3);
        arb.dequeue();
        arb.dequeue();
        assertFalse(arb.isEmpty());
        assertEquals(0,arb.peek()-5);
        arb.dequeue();
        assertTrue(arb.isEmpty());

        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(5);
        arb.enqueue(6);
        for(int n:arb){
            System.out.println(n);
        }
    }
    @Test
    public void TestEquals(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(4);
        ArrayRingBuffer<Integer> arb2 = new ArrayRingBuffer(4);
        /* empty*/
        Boolean actual = arb.equals(arb);
        assertTrue(actual);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb2.enqueue(5);
        arb2.enqueue(1);
        arb2.enqueue(2);
        arb2.enqueue(3);
        arb2.dequeue();
        actual = arb.equals(arb2);
        assertTrue(actual);
        arb2.enqueue(4);
        actual = arb.equals(arb2);
        assertFalse(actual);
    }

}
