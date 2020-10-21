import java.util.*;

public class ArraySet<T> implements Iterable<T>{
    private int size;
    private T[] items;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }
    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for(int i =0;i<size;i++){
            if(x.equals(items[i])){
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {

        if (contains(x) || x == null) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }


    @Override
    public String toString(){
        List<String> listofitems = new ArrayList<>();
        for(T item:this){
            listofitems.add(item.toString());
        }
        return String.join(",",listofitems);
    }

    /* write equals*/
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        /* cast object type to ArraySet<T> type*/
        ArraySet<T> other = (ArraySet<T>)o;
        if(this.size() != other.size()){
            return false;
        } else {
            for(T item:other){
                if(!this.contains(item)){
                    return false;
                }
            }
            return true;
        }
    }

    public static <glorp> ArraySet<glorp> of(glorp...stuff){
        ArraySet<glorp> returnset = new ArraySet<glorp>();
        for(glorp item:stuff){
            returnset.add(item);
        }
        return returnset;
    }

    @Override
    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    public class ArraySetIterator implements Iterator<T>{
        private int wizpos;
        public ArraySetIterator(){
            wizpos = 0 ;
        }
        @Override
        public boolean hasNext(){
            return wizpos < size;
        }
        @Override
        public T next(){
            T returnitem = items[wizpos];
            wizpos += 1;
            return returnitem;
        }
    }

    public static void main(String[] args) {
        ArraySet<String> arrs = new ArraySet<>();
        arrs.add(null);
        arrs.add("horse");
        arrs.add("fish");
        arrs.add("house");
        arrs.add("fish");
        System.out.println(arrs.contains("horse"));
        System.out.println(arrs);
        System.out.println(arrs.equals(arrs));
        ArraySet<Integer> as1 = ArraySet.of(1,2,3,4,5);
        System.out.println(as1);

    }


    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
