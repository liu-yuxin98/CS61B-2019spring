public class TreeC<Key extends Comparable> implements MinPQ<Key> {

    Key[] keys = (Key[]) new Object[100];
    int size = 0;


    /** Adds the item to the priority queue. */
    public void add(Key x){
        if(size ==0){
            size += 1;
            keys[1] = x;
        }
        size+=1;
        /* insert x into end of the keys*/
        keys[size] = x;
        /* swim up to right position*/
        swim(size);
    }
    /** Returns the smallest item in the priority queue. */
    public Key getSmallest(){
        if(size==0){
            return null;
        }
        return keys[1];
    }

    /** Removes the smallest item form the priority queue. */
    public Key removeSmallest(){
        if(size ==0){
            return  null;
        }

       /* replace root with last*/
        keys[1] = keys[size];
        /* sink it down to right place*/
        sink(1);
        size -= 1;
        return keys[1];
    }

    /** Returns the size of the priority queue. */
    public int size(){
        return size;
    }

    /* return the index of k's parents*/
    public int parent(int k) {
        return k / 2;
    }
    /* return the index of k's left child*/
    public int leftChild(int k) {
        return 2 * k;
    }
    /* return the index of k's right child*/
    public int rightChild(int k) {
        return 2 * k + 1;
    }

    /* swim keys[k] to its right position*/
    public void swim(int k) {
        if (parent(k) == k) {
            return;
        }
        int cmp = keys[parent(k)].compareTo(keys[k]);
        if (cmp>0) {
            swap(k, parent(k));
            swim(parent(k));
        }
    }

    /* swap keys[x] with keys[y]*/
    public void swap(int x,int y){
        Key temp = keys[x];
        keys[x] = keys[y];
        keys[y] = temp;
    }

    /* sink keys[0] to its right place*/
    public void sink(int k){
        int cmpl = keys[leftChild(k)].compareTo(keys[k]);
        int cmpr = keys[rightChild(k)].compareTo(keys[k]);
        if(cmpl<0){
            swap(k,leftChild(k));
            sink(leftChild(k));
        } else if(cmpr<0){
            swap(k,rightChild(k));
            sink(rightChild(k));
        } else{
            return;
        }
    }


    public static void main(String[] args){
        TreeC<Integer> T= new TreeC<Integer>();
        T.add(4);
        T.add(3);
        T.add(2);
        T.add(1);
    }
}
