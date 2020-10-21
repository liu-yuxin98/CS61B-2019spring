import java.util.Iterator;
import java.util.NoSuchElementException;
public class OHIterator implements Iterator<OHRequest> {
    OHRequest curr;
    public OHIterator(OHRequest queue) {
            curr = queue;
    }

    public boolean isGood(String description) {
        return description != null && description.length() > 5;
    }

    @Override
    public boolean hasNext(){
        while (curr != null && !isGood(curr.description)) {
            curr = curr.next;
        }
        return curr != null;
    }

    /* only returns requests with good descriptions*/
    @Override
    public OHRequest next(){
        /* 感觉可以不用这一个判断*/
        if (!hasNext()) {
            throw new NoSuchElementException(); }
        OHRequest returnitem = curr;
        curr = curr.next;
        return returnitem;
    }
}