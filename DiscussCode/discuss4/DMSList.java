/* exam pre04*/
public class DMSList {
    private IntNode sentinel;
    public DMSList() {
        sentinel = new IntNode(-1000, new lastNode());
    }
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode h) {
                item = i;
                next = h;
        }
        public int max() {
                return Math.max(item, next.max());
        }
    }
    public class lastNode extends IntNode {
            public lastNode(){
                super(0,null);
            }
            @Override
            public int max(){
                return 0;
            }
    }
         /* Returns 0 if list is empty. Otherwise, returns the max element. */
        public int max() {
            return sentinel.next.max();
        }

}
