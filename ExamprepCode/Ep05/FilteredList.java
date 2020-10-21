import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FilteredList<T> implements Iterable<T> {
    public List<T> list;
    public Predicate<T> pred;

    /* constructor*/
    public FilteredList (List<T> L, Predicate<T> filter) {
            this.list = L;
            this.pred = filter;
    }


    public class FListiterator implements Iterator<T>{

        /* constructor*/
        int wizpos;
        public FListiterator(){
            wizpos = 0;
        }

        @Override
        public boolean hasNext(){
            while (wizpos<list.size() &&!pred.test(list.get(wizpos)) ){
                wizpos += 1;
            }
            return wizpos<list.size();
        }

        @Override
        public T next(){
          if (!hasNext()) {
              throw new NoSuchElementException(); }
          T returnitem = list.get(wizpos);
          wizpos+=1;
          return returnitem;
        }
    }

    @Override
    public Iterator<T> iterator () {
        return new FListiterator();
    }
}
