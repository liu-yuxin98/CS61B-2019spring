/* genetic*/

public class SLList<lochNess> implements List61B<lochNess> {
    public class stuffNode {
        public lochNess item;
        public stuffNode next;
        public stuffNode(lochNess i, stuffNode n){
            item = i;
            next = n;
        }
        public stuffNode(){
            item = null;
            next = null;
        }
    }

    private int size;
    private stuffNode sentinel;
    public stuffNode p; /* point last*/
    /* constructor */
    public SLList(lochNess x){
        super();/* object*/
        size = 1;
        sentinel = new stuffNode(null,null);
        sentinel.next = new stuffNode(x,null);
        p = sentinel.next;
    }
    /* empty constructor*/
    public SLList(){
        size = 0;
        sentinel = new stuffNode();
        p = sentinel;
    }

    /* add first*/
    @Override
    public void addFirst(lochNess x){
        sentinel.next = new stuffNode(x,sentinel.next);
        size += 1;
        if(size==1){
            p = p.next;
        }
    }

    /* add last*/
    @Override
    public void addLast(lochNess x){
        p.next = new stuffNode(x,null);
        p = p.next;
        size += 1;
    }

    /* return first item*/
    @Override
    public lochNess getFirst(){
        return sentinel.next.item;
    }

    /* return last item in the list*/
    @Override
    public lochNess getLast(){
        return p.item;
    }

    /* remove last and return it*/
    @Override
    public lochNess removeLast(){
        if(size ==0){
            return null;
        }else{
            size -= 1;
            stuffNode temp = sentinel;
            lochNess last = p.item;
            while(temp.next!=p){
                temp = temp.next;
            }
            temp.next =null;
            p = temp;
            return last;
        }

    }

    /* get index-th item*/
    @Override
    public lochNess get(int index){
        stuffNode newp = sentinel;
        if(index>size()-1){
            return null;
        }
        else{
            for(int i =0;i<=index;i++){
                newp = newp.next;
            }
            return newp.item;
        }
    }
    /* insert x to the position*/
//    @Override
//    public void insert(lochNess x, int position){
//        /* insert into an empty list*/
//        if(size ==0){
//            if(position>=1){
//                System.out.println("out of index");
//            }else{
//                sentinel.next = new stuffNode(x,null);
//                size += 1;
//                p = p.next;
//            }
//        }else{
//            /* position = 0*/
//            if(position==0){
//                size += 1;
//                stuffNode temp = sentinel.next;
//                sentinel.next = new stuffNode(x,temp);
//                temp = null;
//            }
//            /* insert into middle*/
//            if(0<position && position<size){
//                size += 1;
//                stuffNode temp = sentinel.next;
//                for(int i=0;i<position-1;i++){
//                    temp = temp.next;
//                }
//                stuffNode tempp = temp;
//                temp.next = new stuffNode(x,tempp.next);
//                tempp = null;
//                temp = null;
//            }
//            /* insert into end*/
//            if(position==size){
//                size +=1;
//                p.next = new stuffNode(x,null);
//                p = p.next;
//            }
//            if(position>size){
//                System.out.println("out of index");
//            }
//        }
//    }
//
    @Override
    public void insert(lochNess x, int pos){
        if(sentinel.next == null){
           addFirst(x);
           return;
        }
        stuffNode currentNode = sentinel.next;
        while(pos>1 && currentNode.next!=null){
            pos --;
            currentNode = currentNode.next;
        }
        stuffNode newNode = new stuffNode(x,currentNode.next);
        currentNode.next = newNode;
        size += 1;
    }

    /* return size*/
    @Override
    public int size(){
        return size;
    }

    /* is empty*/
    @Override
    public boolean IsEmpty(){
        if(size()==0){
            return true;
        }else{
            return false;
        }
    }
    /* more effficient print for SLList*/
    @Override
    public void printList(){
        for(stuffNode p =sentinel.next;p!=null;p=p.next){
            System.out.print(p.item+" ");
        }
        System.out.println(" ");
    }

    /* remove first*/
    public lochNess removeFirst(){
        if(size==0){
            System.out.println("wrong! empty list can't deletefirst");
            return null;
        }
        else{
            size -= 1;
            stuffNode pfirst = sentinel.next;
            lochNess firstitem = pfirst.item;
            sentinel.next = sentinel.next.next;
            pfirst.next =null;
            return  firstitem;
        }
    }
    /* reverse*/
    /* can not use new*/
    public void reverse(){
       if(size<=1){
           return;
       }
       stuffNode ptr = sentinel.next;
       sentinel.next = null;
       while(ptr!=null){
           stuffNode temp = ptr.next;
           ptr.next = sentinel;
           sentinel = ptr;
           ptr = temp;
       }
    }

}
