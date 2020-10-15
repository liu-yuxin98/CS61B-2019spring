import com.sun.org.apache.xpath.internal.objects.XObject;

/* array deque*/
public class AList<blober> implements List61B<blober>{
    /* constructor*/
    private blober[] item;
    private int size;

    public AList(){
        item = (blober[]) new Object[100];
        size = 0;
    }
    public AList(AList other){
        item = (blober[]) new Object[other.size()];
        size = other.size();
        System.arraycopy(other.item, 0, item, 0, size);
    }

    /* add first*/
    @Override
    public void addFirst(blober x){
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
    @Override
    public void addLast(blober x){
        if (size == item.length){
            resize(size+1);
        }
        item[size] = x; size+=1;
    }

    /*get first*/
    @Override
    public blober getFirst(){
        return item[0];
    }

    /*get last*/
    @Override
    public blober getLast(){
        return item[size-1];
    }

    /* remove last and return the value of it*/
    @Override
    public blober removeLast(){
        if(size ==0){
            return null;
        }else{
            blober x = item[size-1];
            item[size-1] = null;
            size -= 1;
            return x;

        }
    }

    /* get ith item*/
    @Override
    public blober get(int i){
        return item[i];
    }
    /* inser x to position*/
    @Override
    public void insert(blober x, int position){
        System.arraycopy(item,position,item,position+1,size()-position);
        item[position] = x;
        size += 1;
    }

    /* get size*/
    @Override
    public int size(){
        return size;
    }

    /* is empty*/
    @Override
    public boolean IsEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }


}
