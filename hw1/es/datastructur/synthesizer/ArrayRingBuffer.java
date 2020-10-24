package es.datastructur.synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T>  implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb =(T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    /**
    * return size of the buffer
    */
    @Override
    public int capacity(){
        return rb.length;
    }

    /**
     * return number of items currently in the buffer
     */
    @Override
    public int fillCount(){
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        /* full*/
        if(fillCount >= capacity()){
            throw new RuntimeException("Ring Buffer overflow");
        } else{
            /* empty*/
            if(fillCount == 0){
                rb[0] = x;
                fillCount += 1;
                first =0 ;
                last = 0;
            }
            else {
                fillCount += 1;
                /* enqueue to the first*/
                if(last == capacity()-1){
                    last = 0;
                } else{
                    last += 1;
                }
                rb[last] = x ;
            }

        }

    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        if(fillCount == 0){
            throw new RuntimeException("RingBufferunderflow");
        } else{
            fillCount -= 1;
            T returnitem = rb[first];
            rb[first] = null;
            /* to the end*/
            if(first==capacity()-1){
                first = 0;
            } else{
                first += 1;
            }
            return returnitem;
        }

    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        if(fillCount ==0){
            throw new RuntimeException("Empty Ring");
        }
        return rb[first];
    }

    @Override
    public Iterator<T> iterator(){
        return new ARBIterator<T>();
    }

    /* iterator*/
    private class ARBIterator<T> implements Iterator<T>{
        int wizpos = first;
        int cnt = 0;
        @Override
        public boolean hasNext(){
            if(cnt<fillCount){
                cnt += 1;
                return true;
            }
            else{
                return false;
            }
        }
        @Override
        public T next(){
            /* first在last的右边，过边界*/
            if(first>last){
                /* to the boundary*/
                if(wizpos== rb.length-1){
                    T returnitem = (T)rb[wizpos];
                    wizpos = 0;
                    return returnitem;
                } else {
                    T returnitem = (T)rb[wizpos];
                    wizpos += 1;
                    return returnitem;
                }

            } else{
                T returnitem = (T)rb[wizpos];
                wizpos += 1;
                return returnitem;
            }

        }
    }

    /**
     * to compare two ArrayRingBUffer, return true if they are equal, return false if not
     * */
    @Override
    public boolean equals(Object o){

        ArrayRingBuffer<T> other = (ArrayRingBuffer<T>)o;

        /* diferent size*/
        if(fillCount!=other.fillCount()){
            return false;
        } else {
            /* create two tempo array*/
            ArrayRingBuffer<T> tempcur = new ArrayRingBuffer(capacity());
            ArrayRingBuffer<T> tempother = new ArrayRingBuffer(other.capacity());
            int currfirst = first;
            int currOtherfirst = other.first;
            for(int i=0;i<fillCount;i++){
                tempcur.enqueue(this.peek());
                tempother.enqueue(other.peek());
                if(first == rb.length-1){
                   first = 0;
                } else {
                    first += 1;
                }

                if(other.first == other.rb.length-1){
                    other.first =0;
                } else {
                    other.first += 1;
                }

            }
            /* set this.first and other.first to its origin*/
            first = currfirst;
            other.first = currOtherfirst;

            int cnt =0;
            while(cnt<fillCount){
                cnt += 1;
                if(tempcur.dequeue()!=tempother.dequeue()){
                    return false;
                }
            }
            return true;
        }

    }

}

