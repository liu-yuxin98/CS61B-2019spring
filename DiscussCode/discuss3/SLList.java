public class SLList{
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }
    private int size;
    private IntNode first;
    private IntNode p;
    public SLList(int x){
        first = new IntNode(x,null);
        size = 1;
        p = first;
    }
    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
        if(p.next ==null){
            p = first;
        }else{
            p = p.next;
        }
    }

    public void addLast(int x){
        p.next = new IntNode(x,null);
        p = p.next;
        size += 1;
    }
    public void Insert(int x, int pos){
        /* insert into an empty list*/
        if(size ==0){
            if(pos>=1){
                System.out.println("out of index");
            }else{
                first = new IntNode(x,null);
                size = 1;
                p = first;
            }
        }else{
            /* pos = 0*/
            if(pos==0){
                size += 1;
                IntNode temp = first;
                first = new IntNode(x,temp);
                temp = null;
            }
            /* insert into middle*/
            if(0<pos && pos<size){
                size += 1;
                IntNode temp = first;
                for(int i=0;i<pos-1;i++){
                    temp = temp.next;
                }
                IntNode tempp = temp;
                temp.next = new IntNode(x,tempp.next);
                tempp = null;
                temp = null;
            }
            /* insert into end*/
            if(pos==size){
                size +=1;
                p.next = new IntNode(x,null);
                p = p.next;
            }
            if(pos>size){
                System.out.println("out of index");
            }
        }

    }
    public void printlist(){
        IntNode temp = first;
        while(temp!=null){
            System.out.println(temp.item);
            temp = temp.next;
        }
    }
    public void reverse(){

    }
    public static void main(String[] args){
        SLList sl = new SLList(1);
        sl.addFirst(0);
        sl.addFirst(2);
        sl.Insert(1,1);
        sl.printlist();
    }
}