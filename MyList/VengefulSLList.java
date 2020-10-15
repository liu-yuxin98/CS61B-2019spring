public class VengefulSLList<lochNess> extends SLList<lochNess> {
    SLList<lochNess> deletedItems;
    /* constructor*/
    public VengefulSLList(){
        super();
        deletedItems = new SLList<lochNess>();
    }

    @Override
    public lochNess removeLast() {
        lochNess last = super.removeLast(); /* 直接调用super class中的函数*/
        deletedItems.addLast(last);
        return last;
//        if(size ==0){
//            return null;
//        }else{
//            size -= 1;
//            stuffNode temp = sentinel;
//            lochNess last = p.item;
//            deletedItems.addLast(last);
//            while(temp.next!=p){
//                temp = temp.next;
//            }
//            temp.next =null;
//            p = temp;
//            return last;
//        }
//
    }

    public void printLostItems() {

        deletedItems.printList();
    }
}
