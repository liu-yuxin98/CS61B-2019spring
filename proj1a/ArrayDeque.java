import com.sun.org.apache.xpath.internal.objects.XObject;

/* array deque*/
public class ArrayDeque<blober> {
    /* constructor*/
    private blober[] item;
    private int size;

    public ArrayDeque(){
        item = (blober[]) new Object[100];
        size = 0;
    }
    public ArrayDeque(ArrayDeque other){
        item = (blober[]) new Object[other.size()];
        size = other.size();
        System.arraycopy(other.item, 0, item, 0, size);
    }

    /* is empty*/
    public boolean IsEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    /* add first*/
    public void addfirst(blober x){
        if (size == item.length){
            resize(size+1);
        }
        System.arraycopy(item,0 ,item,1,size);
        item[0] = x;
        size +=1;
    }


    /* resizing*/
    public void resize(int capacity){
        int refractor = 2;
        blober[] a = (blober[]) new Object[capacity*refractor];
        System.arraycopy(item, 0, a, 0, capacity-1);
        item = a;
    }
    /* add last*/
    public void addlast(blober x){
        if (size == item.length){
            resize(size+1);
        }
        item[size] = x; size+=1;
    }

    /*get last*/
    public blober getlast(){
        return item[size-1];
    }
    /* get ith item*/
    public blober get(int i){
        return item[i];
    }

    /* get size*/
    public int size(){
        return size;
    }
    /* remove last and return the value of it*/
    public blober removelast(){
        blober x = item[size-1];
        item[size-1] = null;
        size -= 1;
        return x;
    }
}
