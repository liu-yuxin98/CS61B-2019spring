/* genetic*/

public class SLList<lochNess> {
    private class stuffNode {
        public lochNess item;
        public stuffNode next;
        public stuffNode(lochNess i, stuffNode n){
            item = i;
            next = n;
        }
    }

    private stuffNode sentinel;
    private stuffNode p; /* point last*/
    /* constructor */
    public SLList(lochNess x){
        sentinel = new stuffNode(x,null);
        sentinel.next = new stuffNode(x,null);
        p = sentinel.next;
    }



    /* add first*/
    public void addfirst(lochNess x){
        sentinel.next = new stuffNode(x,sentinel.next);
    }
    /* add last*/
    public void addlast(lochNess x){
        p.next = new stuffNode(x,null);
        p = p.next;
    }

    public static void main(String[] args) {
        SLList<Integer> L = new SLList<Integer>(2);
        L.addfirst(3);
        L.addfirst(4);

    }

}
