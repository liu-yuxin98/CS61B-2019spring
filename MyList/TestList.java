import org.junit.Test;
import static org.junit.Assert.*;
public class TestList {
    @Test /* test addFirst && addLast*/
    public void TestAdd(){
        /* SLList*/
        List61B<Integer> SL1 = new SLList<Integer>();
        SL1.addFirst(1); /* EMPTY List addFirst*/
        int actualS1 = SL1.get(0);
        assertEquals(1,actualS1);

        List61B<Integer> SL2 = new SLList<Integer>();
        SL2.addLast(1); /* EMPTY List addLast*/
        int actualS2 = SL2.get(0);
        assertEquals(1,actualS2);

        SL2.addFirst(0); /* general addFirst*/
        int actualS3 = SL2.get(0);
        assertEquals(0,actualS3);
        SL2.addLast(2);/* general addLast*/
        int actualS4 = SL2.get(2);
        assertEquals(2,actualS4);
        SL2.printList();
        System.out.println("--------------------");

        /* AList*/
        List61B<Integer> AL1 = new AList<Integer>();
        AL1.addFirst(1); /* EMPTY List addFirst*/
        int actualA1 = SL1.get(0);
        assertEquals(1,actualA1);

        List61B<Integer> AL2 = new SLList<Integer>();
        AL2.addLast(1); /* EMPTY List addLast*/
        int actualA2 = AL2.get(0);
        assertEquals(1,actualA2);

        AL2.addFirst(0); /* general addFirst*/
        int actualA3 = AL2.get(0);
        assertEquals(0,actualA3);
        AL2.addLast(2); /* general addLast*/
        int actualA4 = AL2.get(2);
        assertEquals(2,actualA4);
        AL2.printList();
        System.out.println("--------------------");
    }
    @Test /* test Get*/
    public void TestGet(){
        /*SLList*/
        List61B<String > SL1 = new SLList<String>("good");
        SL1.addLast("morning");
        SL1.addLast("james");
        String actualS1 = SL1.get(2);
        assertEquals("james",actualS1);
        /*AList*/
        List61B<String > AL1 = new AList<String>();
        AL1.addFirst("morning");
        AL1.addFirst("james");
        String actualA1 = AL1.get(0);
        assertEquals("james",actualA1);


    }

    @Test /* test Insert*/
    public void TestInsert(){
        /*SLList*/
        List61B<Integer> SL = new SLList<>();
        SL.insert(5,0); /* EMPTY LIST insert*/
        int actualS1 = SL.get(0);
        assertEquals(5,actualS1);
        SL.addLast(1);
        SL.addLast(2);
        SL.insert(3,2);/* middle insert*/
        int actualS2 = SL.get(2);
        assertEquals(3,actualS2);
        SL.insert(16,4);
        int actualS3 = SL.get(4);
        assertEquals(16,actualS3); /* end insert*/
        SL.printList();
        System.out.println("--------------------");

        /*AList*/
        List61B<Integer> AL = new AList<>();
        AL.insert(5,0); /* EMPTY LIST insert*/
        int actualA1 = AL.get(0);
        assertEquals(5,actualA1);
        AL.addLast(1);
        AL.addLast(2);
        AL.insert(3,2);/* middle insert*/
        int actualA2 = AL.get(2);
        assertEquals(3,actualA2);
        AL.insert(16,4);
        int actualA3 = AL.get(4);
        assertEquals(16,actualA3); /* end insert*/
        AL.printList();
        System.out.println("--------------------");

    }

    @Test /* test removeLast*/
    public void TestRemove(){
        /*SLList*/
        List61B<Integer> SL = new SLList<>();
        assertNull(SL.removeLast() );   /* EMPTY LIST remove*/
        SL.addLast(1);
        SL.addLast(2);
        SL.addLast(3);
        int actualS1 = SL.removeLast();  /* general remove*/
        assertEquals(3,actualS1);
        SL.printList();
        System.out.println("--------------------");

        /*AList*/
        List61B<Integer> AL = new AList<>();
        assertNull(AL.removeLast() );   /* EMPTY LIST remove*/
        AL.addLast(1);
        AL.addLast(2);
        AL.addLast(3);
        int actualA1 = AL.removeLast();  /* general remove*/
        assertEquals(3,actualA1);
        AL.printList();
        System.out.println("--------------------");

    }

    @Test /* test size and IsEmpty*/
    public void TestSize(){
        /*SLList*/
        List61B<Integer> SL = new SLList<>();
        assertEquals(0,SL.size());/* EMPTY LIST*/
        SL.addLast(1);
        SL.addLast(2);
        assertEquals(2,SL.size());
        SL.printList();
        System.out.println("--------------------");
        SL.removeLast();
        SL.removeLast();
        assertEquals(0,SL.size());/* EMPTY LIST*/
        assertEquals(true, SL.IsEmpty());

        /*AList*/
        List61B<Integer> AL = new AList<>();
        assertEquals(0,AL.size());/* EMPTY LIST*/
        AL.addLast(1);
        AL.addLast(2);
        assertEquals(2,AL.size());
        AL.printList();
        System.out.println("--------------------");
        AL.removeLast();
        AL.removeLast();
        assertEquals(0,AL.size());/* EMPTY LIST*/
        assertEquals(true, AL.IsEmpty());
    }
    @Test /* test rotate*/
    public void TestRotate(){
        RotatingSLList<Integer> RL = new RotatingSLList<>();
        RL.addLast(1);
        RL.addLast(2);
        RL.addLast(3);
        RL.addLast(4);
        RL.addLast(5);
        RL.printList();
        RL.rotateRight();
        RL.printList();

    }
    @Test /* test rotate*/
    public void TestVengeful(){
        VengefulSLList<Integer> VL = new VengefulSLList<>();
        VL.addLast(1);
        VL.addLast(2);
        VL.addLast(3);
        VL.addLast(4);
        VL.addLast(5);
        VL.removeLast();
        VL.removeLast();
        VL.printList();
        VL.printLostItems();
        System.out.println(VL.getClass());
        System.out.println(VL.hashCode());
        System.out.println(VL.toString());

    }


}
