import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class IteratorOfIterators implements Iterator<Integer> {
    LinkedList<Integer> l;

    public IteratorOfIterators(ArrayList<Iterator<Integer>> a) {
        l = new LinkedList<>(); int i = 0;
        while (!a.isEmpty()) {
            Iterator<Integer> curr = a.get(i);
            if (!curr.hasNext()) {
                a.remove(curr);
                i -= 1; //or else we'll skip an element
            } else {
                l.add(curr.next());
            }
            if (a.isEmpty()) { //could've removed the last Iterator break;
                break;
            }
            i = (i + 1) % a.size();
        }
    }

    @Override
    public boolean hasNext() {
        return !l.isEmpty();
    }

    @Override
    public Integer next() {
        return l.removeFirst();
    }


    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);A.add(2);A.add(3);
        Iterator<Integer> seerA = A.iterator();

        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(4);B.add(5);B.add(6);
        Iterator<Integer> seerB = B.iterator();

        ArrayList<Integer> C = new ArrayList<Integer>();
        C.add(7);C.add(8);C.add(9);
        Iterator<Integer> seerC = C.iterator();

        ArrayList<Iterator<Integer>> L = new ArrayList<>();
        L.add(seerA); L.add(seerB);L.add(seerC);


        IteratorOfIterators IoI = new IteratorOfIterators(L);



    }
}