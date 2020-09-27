/* create T deque  linkedlistdeque*/
public class LinkedListDeque<T> {
    private class stuffNode{
        public T stuff;
        public stuffNode prev;
        public stuffNode next;
        /* constructor*/
        public stuffNode(T x,stuffNode p,stuffNode n){
            stuff = x;
            prev = p;
            next = n;
        }
        /* empty constructor*/
        public stuffNode(){
            stuff = null;
            prev = this;
            next = this;
        }
    }

    private stuffNode sentinel;
    public int size;

    /* constructor*/
    public LinkedListDeque(T x){
        size += 1;
        sentinel = new stuffNode();
        sentinel.next = new stuffNode(x,sentinel,sentinel);
        sentinel.prev = sentinel.next;
    }
    /* constructor emoty list*/
    public LinkedListDeque(){
        size = 0;
        sentinel = new stuffNode();
    }
    /* Creates a deep copy of other*/
    public LinkedListDeque(LinkedListDeque other){
        /* create a temp pointer to iterate other*/
        stuffNode temp =  other.sentinel.next;
        sentinel = new stuffNode();
        sentinel.next = new stuffNode(temp.stuff,sentinel,sentinel);
        sentinel.prev = sentinel.next;
        size += 1;
        /*create a thistemp pointer to iterate this*/
        stuffNode thistemp = this.sentinel.next;
        for(int i=0;i<other.size()-1;i++){
            temp = temp.next;
            thistemp.next = new stuffNode(temp.stuff,thistemp,sentinel);
            sentinel.prev = thistemp.next;
            thistemp = thistemp.next;
            size += 1;
        }
    }

    /* add item in the first place*/
    public void addFirst(T item){
        size += 1;
        /* add an addnode addnode's prev->sentinel addnode's next->sentinel.next*/
        stuffNode addnode = new stuffNode(item,this.sentinel,this.sentinel.next);
        /* sentinel's next-> addnode*/
        sentinel.next = addnode;
        /* first node's prev->addnode*/
        addnode.next.prev = addnode ;
    }

    /* add item the last place  */
    public void addLast(T item){
        size += 1;
        /* add an addnoe addnode's next ->sentinel addnode.prev->sentinel.prev*/
        stuffNode addnode = new stuffNode(item,this.sentinel.prev,this.sentinel);
        /* lastnode's next points to addnode*/
        addnode.prev.next = addnode;
        /* sentinel's prev points to addnode*/
        sentinel.prev = addnode;
    }

    /* is empty*/
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else {
            return false;
        }
    }

    /* return the size of the deque*/
    public int size(){
        return size;
    }

    /*Prints the items in the deque from first to last     */
    public void printDeque(){
        stuffNode p = sentinel;
        p = p.next;
        for(int i =0; i<this.size(); i++){
            System.out.println(p.stuff);
            p = p.next;
        }
    }

    /* Removes and returns the item at the front of the deque */
    public T removeFirst(){
        size -= 1;
        /* p->firstnode*/
        stuffNode p = sentinel.next;
        /* secondnode's prev->sentinel*/
        p.next.prev = sentinel;
        /* sentinel's next->sentinel's next.next*/
        sentinel.next = p.next;
        p.prev = null;
        p.next = null;
        return p.stuff;
    }

    /* Removes and returns the item at the back of the deque*.     */
    public T removeLast(){
        size -= 1;
        /* p->lastnode*/
        stuffNode p =sentinel.prev;
        /* second to lastnode.next->sentinel*/
        p.prev.next = sentinel;
        /* sentinel/prev = second to last*/
        sentinel.prev = p.prev;
        p.prev = null;
        p.next = null;
        return p.stuff;
    }

    /*  Gets the item at the given index */
    public T get(int index){
        /* out of border*/
        if(index>this.size()-1){
            return null;
        }
        stuffNode p = sentinel.next;
        for(int i =0;i<index;i++){
            p = p.next;
        }
        return p.stuff;
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> L = new LinkedListDeque<Integer>(2);
        L.addFirst(1);
        L.addLast(3);
        L.printDeque();
    }
}
