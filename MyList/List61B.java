public interface List61B<Item> {
    /* add x to the front*/
    public void addFirst(Item x);
    /* add x to the end*/
    public void addLast(Item y);
    /* return first item in the list*/
    public Item getFirst();
    /* return last item in the list*/
    public Item getLast();
    /* remove last and return it*/
    public Item removeLast();
    /* get ith item*/
    public Item get(int i);
    /* insert x to the position*/
    public void insert(Item x, int position);
    /* return size*/
    public int size();
    /* is empty*/
    public boolean IsEmpty();
    /* print*/
    default void printList(){
        for(int i=0;i<size();i++){
            System.out.print(get(i)+" ");
        }
        System.out.println(" ");
    }
}
