
public class DList<louchness> {
    public  class typeNode{
        public louchness item;
        public typeNode pre;
        public typeNode next;
        public typeNode(louchness x,typeNode p,typeNode n){
            item = x;
            pre = p;
            next = n;
        }
        public typeNode(){
            item = null;
            pre = this;
            next = this;
        }
    }
    public typeNode sentinel;
    public int size;
    /* constructor non empty DList*/
    public DList(louchness x){
        size = 1;
        sentinel = new typeNode();
        sentinel.next = new typeNode(x,sentinel,sentinel);
        sentinel.pre = sentinel.next;
    }
    /* constructor empty DList*/
    public DList(){
        size = 0;
        sentinel = new typeNode();
    }
    /* add first*/
    public void addFirst(louchness x){
        typeNode newfnode = new typeNode(x,sentinel,sentinel.next);
        typeNode oldfnode = sentinel.next;
        oldfnode.pre = newfnode;
        sentinel.next = newfnode;
    }
    /* add last*/
    public void addLast(louchness x){
        typeNode newlnode = new typeNode(x,sentinel.pre,sentinel);
        typeNode oldlnode = sentinel.pre;
        sentinel.pre = newlnode;
        oldlnode.next = newlnode;
    }
    /* get size*/
    public int size(){
        return size;
    }


}
