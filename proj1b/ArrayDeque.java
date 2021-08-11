import com.sun.org.apache.xpath.internal.objects.XObject;

/* array deque*/ /* extends ArrayDeque<blober> implements Deque<blober>*/
public class ArrayDeque<blober> implements Deque<blober>{
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


    @Override public void addFirst(blober x){
        if (size == item.length){
            resize(size+1);
        }
        System.arraycopy(item,0 ,item,1,size);
        item[0] = x;
        size +=1;
    }
    @Override public void addLast(blober x){
        if (size == item.length){
            resize(size+1);
        }
        item[size] = x; size+=1;
    }

    /* get size*/
    @Override public int size(){
        return size;
    }

    @Override public void printDeque(){
        for(int i =0;i<size;i++){
            System.out.println(item[i]);
        }
    }


    @Override public blober removeFirst(){
        if(size ==0){
            return null;
        }else{
            blober first = item[0];
            System.arraycopy(item,1 ,item,0,size-1);
            size -= 1;
            item[size] = null;
            return first;
        }

    }

    @Override public blober removeLast(){
        if(size==0){
            return null;
        }else{
            blober x = item[size-1];
            item[size-1] = null;
            size -= 1;
            return x;
        }
    }


    @Override public blober get(int index){
        return item[index];
    }


    /* resizing*/
    public void resize(int capacity){
        int refractor = 2;
        blober[] a = (blober[]) new Object[capacity*refractor];
        System.arraycopy(item, 0, a, 0, capacity-1);
        item = a;
    }









}
