import org.junit.Test;

public class TestBST {
    @Test
    public void TestInsert(){
        BST<Integer,Integer> bst1 = new BST<>();
        bst1.insert(5,5);
        bst1.insert(3,3);
        bst1.insert(7,7);
        bst1.insert(2,2);
        bst1.insert(4,4);
        bst1.insert(1,1);
        bst1.insert(6,6);
        bst1.delete(5);
        bst1.delete(2);


    }
}
