public  interface  Deque<item> {

    /* Adds an x of type item to the front of the deque.*/
    public void addFirst(item x);

    /* Adds an x of type item to the end of the deque.*/
    public void addLast(item x);

    /* is empty*  在interface中定义了 default method ,那么就不需要在后续的class中添加这个method了*/
    default boolean IsEmpty(){
        if(size() ==0){
            return true;
        }else{
            return false;
        }
    }

    /*Returns the number of items in the deque.*/
    public int size();


    /* Prints the items in the deque from first to last*/
    public void printDeque();

    /*Removes and returns the item at the front of the deque. If no such item exists, returns null*/
    public item removeFirst();

    /* Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public item removeLast();

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null.*/
    public item get(int index);


}

