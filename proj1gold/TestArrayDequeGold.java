import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {

    /* test if StudentArrayDeque has bug*/
    /* record every methods until to bug*/
    @Test
    public void TestRandomCall(){

        while(true){
            /* create two array*/
            Integer times = 0;
            StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
            ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
            Integer N=10;/* numbers in the array*/
            StringBuilder errormessage = new StringBuilder();
            for (int i = 0; i < N; i += 1) {
                double numberBetweenZeroAndOne = StdRandom.uniform();
                if (numberBetweenZeroAndOne < 0.5) {
                    sad1.addLast(i);
                    errormessage.append("addLast("+i+")\n");
                    ads1.addLast(i);
                } else {
                    sad1.addFirst(i);
                    errormessage.append("addFirst("+i+")\n");
                    ads1.addFirst(i);
                }
            }
            /* check if they are equal*/
            Boolean differ = false;

            Integer pos = 0;
            while(true){
                /* out of index compare all the item in the two queue*/
                if(pos>=N){
                    break;
                }
                /* remove last or first and compare*/
                double randomnumber = StdRandom.uniform();
                if(randomnumber<0.5){
                    Integer sadfirst = sad1.removeFirst();
                    errormessage.append("removeFirst( )\n");
                    Integer adsfirst = ads1.removeFirst();
                    /* find different*/
                    if(sadfirst != adsfirst){
                        differ = true;
                        assertEquals("Oh noooo!\nThis is bad:\n   get wrong at "
                                + " addfirst " ,adsfirst,sadfirst);
                        break;
                    }
                } else{
                    Integer sadlast = sad1.removeLast();
                    errormessage.append("removeLast( )\n");
                    Integer adslast = ads1.removeLast();
                    /* find different*/
                    if(sadlast != adslast){
                        differ = true;
                        assertEquals("\n"+errormessage ,adslast,sadlast);
                        break;
                    }
                }
                pos += 1;
            }
            times += 1;
            /* different output break*/
            if (times ==2){
                System.out.println("all the same to run "+times+" times");
                break;
            }
            if(differ){
                System.out.println("differ in position: "+pos);
                break;
            }
        }
    }
}

