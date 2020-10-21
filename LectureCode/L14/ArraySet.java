import java.util.Iterator;
public class ArraySet<T> implements Iterable<T>{
    private T[] items;
    private int size; // the next item to be added will be at position size

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. */
    public void add(T x) {
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }


    /* iterator*/
    public Iterator<T> iterator(){
        return new ArraySetInterator();
    }

    
    private class ArraySetInterator implements Iterator<T>{
        public int wizpos;
        public ArraySetInterator(){
             wizpos =0;
        }

        @Override
        public boolean hasNext(){
           return wizpos<size;
        }

        @Override
        public T next(){
            T returnitem = items[wizpos];
            wizpos += 1;
            return returnitem;
        }
    }


    public static void main(String[] args){
        ArraySet<Integer> asst = new ArraySet<>();
        asst.add(1);
        asst.add(2);
        asst.add(3);

        /* ugly iteration*/
        Iterator<Integer> seer = asst.iterator() ;
        while(seer.hasNext()){
            System.out.println(seer.next());
        }

        for(int n:asst){
            System.out.println(n);
        }
    }
}