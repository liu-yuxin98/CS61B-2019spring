import javax.swing.*;

/** Array based list.
 *  @author Josh Hug
 */
public class AList {

    public int[] item;
    public int size;
    /** Creates an empty list. */
    public AList() {
       item = new int[100];
       size = 0;
    }
    /* constructor*/
    public AList(int x){
        item[0] = x; size+=1;
    }
    public void resize(int capacity){
        int [] a = new int[capacity];
        System.arraycopy(item, 0, a, 0, capacity-1);
        item = a ;
    }
    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(size==item.length){  /* resizeing*/
           resize(size+1);
        }
        else{
            item[size] = x; size+=1;
        }
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
       return item[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
       return item[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int lastitem = this.getLast();
        size -=1;
        return lastitem;
    }
}
