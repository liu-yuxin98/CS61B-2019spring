import java.util.Iterator;
import java.util.NoSuchElementException;

public class TYIterator extends OHIterator {

    public TYIterator(OHRequest queue) {
        super(queue); /* 使用 OHIterator的 constructor*/
        }

    @Override /* next method 需要重新修改*/
    public OHRequest next(){

        OHRequest returnitem = super.next();

        if(curr!=null && curr.description.contains("thank u")){
            curr = curr.next;
        }

        return returnitem;

    }

}

