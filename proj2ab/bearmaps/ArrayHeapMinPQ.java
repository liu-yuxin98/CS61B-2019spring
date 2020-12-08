package bearmaps;
/* my own minheap
* getSmallest, contains, size and changePriority methods run in O(log(n)) time.
* add and removeSmallest run in O(log(n)) average time, except for the rare resize operation.
* */
import java.util.*;




public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T>  {
    public int totallength;
    public PriorityNode[] heap ;
    private int size = 0;
    private double loadfactor;
    public HashSet<T> items; /* store items*/
    public ArrayList<T> position = new ArrayList<>(); /* store items's index in heap*/

    public ArrayHeapMinPQ(){
        /* create array of length 10*/
        size = 0;
        totallength = 5;
        loadfactor = 0.75;
        heap = new ArrayHeapMinPQ.PriorityNode[totallength];
        /* leave the first place of the array as null*/
        heap[0] = new PriorityNode(null,0);
        position.add(null);
        items = new HashSet<>();
    }

    /* resizing heap*/
    public void resize(){
        totallength *= 2;
        PriorityNode[] newheap = new ArrayHeapMinPQ.PriorityNode[totallength];
        for(int i=0;i<=size;i++){
            newheap[i] = heap[i];
        }
        heap = newheap;
    }

    public class PriorityNode  {
        private T item;
        private double priority;

        PriorityNode(T e, double p) {
            this.item = e;
            this.priority = p;
        }
    }

    /* Adds an item with the given priority value. Throws an
     * IllegalArgumentExceptionb if item is already present.
     * You may assume that item is never null. */
    @Override
    public void add(T item, double priority){
            if(items.contains(item)){
                throw new IllegalArgumentException();
            }
            /* need resize?*/
            if((1.0*size/totallength) >= loadfactor){
                resize();
            }

            /* store item into items*/
            items.add(item);
            PriorityNode addNode = new PriorityNode(item,priority);

            size += 1;
            heap[size] = addNode;
            position.add(item);

            swim(size);

    }

    /* return the index of k's parent in the heap*/
    public int parent(int k){
        return k/2;
    }
    /* return the index of k's leftchild in the heap*/
    public int leftchild(int k){
        return 2*k;
    }
    /* return the index of k's rightchild in the heap*/
    public int rightchild(int k){
        return 2*k+1;
    }

    /* swap x,y*/
    public void swap(int x, int y){
        /* change the position*/
        Collections.swap(position, x, y);
        /* change x,y in heap*/
        PriorityNode temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    /* when we add an item we add it to the end first and then swim up*/
    public void swim(int k){
        /* decide if  heap[k].priority < heap[parent(k)].priority  swap*/
        if(heap[k].priority<heap[parent(k)].priority){
            swap(k,parent(k));
            swim(parent(parent(k)));
        }
    }


    /* when we remove an item we put the end to the first and then sink down*/
    public void sink(int k){
        /* four situation
         *1) k doesn't have child -> end
         *2) k has one left child
                bigger or smaller than k
         3) k has one right child
               bigger or smaller than k
         4) k has two children
                4.1) both children are smaller than k
                4.2,4.3) left or right is smaller than k
                4.4) both children are bigger than k
        * */
        if(heap[k] == null){
            return;
        }
        int leftchildindex = leftchild(k);
        int rightchildindex = rightchild(k);
        if(leftchildindex >size && rightchildindex>size){
            return;
        } else if(leftchildindex<=size && rightchildindex>size){
            /* k > leftchild sink left*/
            if(heap[k].priority > heap[leftchild(k)].priority){
                swap(k,leftchild(k));
                sink(leftchild(k));
            } else{
                return;
            }

        } else if(leftchildindex>size && rightchildindex<=size){
            /* k > rightchild sink right*/
            if(heap[k].priority > heap[rightchild(k)].priority){
                swap(k,rightchild(k));
                sink(rightchild(k));
            } else{
                return;
            }
        } else{
            boolean biggerThanleftChild = heap[k].priority > heap[leftchild(k)].priority;
            boolean biggerThanrightChild = heap[k].priority > heap[rightchild(k)].priority;

            if((!biggerThanleftChild) &&(!biggerThanrightChild)){
                return;
            }
            /* > left and <= right*/
            if(biggerThanleftChild && !biggerThanrightChild){
                swap(k,leftchild(k));
                sink(leftchild(k));
            }
            /* >right and <=left*/
            if(biggerThanrightChild && !biggerThanleftChild){
                swap(k,rightchild(k));
                sink(rightchild(k));
            }
            if(biggerThanleftChild && biggerThanrightChild){
                /* 对比 leftchid 和 rightchild ,那个小，就和k 交换*/
                /* left = right*/
                if(heap[leftchild(k)].priority == heap[rightchild(k)].priority){
                    double chance = Math.random();
                    if(chance>0.5){
                        swap(k,leftchild(k));
                        sink(leftchild(k));
                    } else{
                        swap(k,rightchild(k));
                        sink(rightchild(k));
                    }
                }
                /* left bigger than right*/
                else if(heap[leftchild(k)].priority > heap[rightchild(k)].priority){
                    swap(k,rightchild(k));
                    sink(rightchild(k));
                } else {/* left smaller than right*/
                    swap(k,leftchild(k));
                    sink(leftchild(k));
                }
            }
        }

    }


    /* Returns true if the PQ contains the given item. */
    @Override
    public boolean contains(T item){
        if(item == null){
            return false;
        }
        return items.contains(item);
    }



    /* Returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    @Override
    public T getSmallest(){
        if(size == 0){
            throw  new NoSuchElementException();
        }
       return heap[1].item;
    }
    /* Removes and returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    @Override
    public T removeSmallest(){

       T smallest = heap[1].item;
       items.remove(heap[1].item);

       size -= 1;
       swap(1,size+1);
       position.remove(size+1);
       heap[size+1] = null;
       sink(1);

       return smallest;
    }

    /* Returns the number of items in the PQ. */
    @Override
    public int size(){
        return size;
    }


    /* Changes the priority of the given item. Throws NoSuchElementException if the item
     * doesn't exist. */

    @Override
    public void changePriority(T item, double priority){
        if(!items.contains(item)){
            throw  new NoSuchElementException();
        }
        int index = position.indexOf(item);
        double oldpriority = heap[index].priority;
        heap[index].priority = priority;
        if(oldpriority>=priority){
            swim(index);
        } else{
            sink(index);
        }
    }

    public void printitems(){

    }

    public void printheap(){

    }

    public static void main(String[] args){
        ArrayHeapMinPQ<Integer> ap1 = new ArrayHeapMinPQ<>();
        ap1.add(1,1.0);
        ap1.add(5,5.0);
        ap1.add(9,9.0);
        ap1.add(2,2.0);
        ap1.add(3,3.0);
        ap1.add(4,4.0);
        ap1.add(8,8.0);
        ap1.add(6,6.0);
        System.out.println(ap1.position);
        ap1.removeSmallest();
        System.out.println(ap1.position);
        ap1.removeSmallest();
        System.out.println(ap1.position);
        ap1.removeSmallest();
        System.out.println(ap1.position);
        ap1.changePriority(9,2.0);
    }


}
