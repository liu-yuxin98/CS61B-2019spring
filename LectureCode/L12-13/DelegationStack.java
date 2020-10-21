import java.util.LinkedList;
/*This approach uses Delegation. It creates a Linked List object and calls its methods to accomplish its goal.*/
public class DelegationStack<Item> {
    private LinkedList<Item> L = new LinkedList<Item>();
    public void push(Item x){
        L.add(x);
    }
}
