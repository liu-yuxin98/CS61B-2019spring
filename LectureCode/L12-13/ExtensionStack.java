import java.util.LinkedList;
/* borrow method from LinkedList*/
public class  ExtensionStack<Item> extends LinkedList<Item> {
    @Override
    public void push(Item x){
        add(x);
    }
}
