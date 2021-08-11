/**
 * (Min) priority Queue: Allowing tracking and removal of
 * the smallest item in a priority queue.
 */
public interface MinPQ<Item> {
    /** Adds the item to the priority queue. */
    public void add(Item x);
    /** Returns the smallest item in the priority queue. */
    public Item getSmallest();
    /** Removes the smallest item form the priority queue. */
    public Item removeSmallest();
    /** Returns the size of the priority queue. */
    public int size();
}