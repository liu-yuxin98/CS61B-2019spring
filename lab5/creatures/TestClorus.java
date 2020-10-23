package creatures;

import huglife.*;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestClorus {

    @Test
    public void testBasics() {
        Clorus c = new Clorus(2) {
        };
        assertEquals(2, c.energy(), 0.01);
        assertEquals(new Color(34, 0, 231),c.color());
        c.move();
        assertEquals(1.97, c.energy(), 0.01);
        c.move();
        assertEquals(1.94, c.energy(), 0.01);
        c.stay();
        assertEquals(1.93, c.energy(), 0.01);
        c.stay();
        assertEquals(1.92, c.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        // TODO
        Clorus c = new Clorus(2);
        c.color();
        Clorus rc = c.replicate();
        assertEquals(c.energy(),rc.energy(),0.01);
        assertEquals(c.color(),rc.color());

    }
    @Test
    public void testChoose() {

        // No empty adjacent spaces; stay.
        Clorus c = new Clorus(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        // plips are seen attack
        Clorus c2 = new Clorus(0.5);
        HashMap<Direction, Occupant> pliparound = new HashMap<Direction, Occupant>();
        pliparound.put(Direction.TOP, new Plip(0.3));
        pliparound.put(Direction.BOTTOM, new Empty());
        pliparound.put(Direction.LEFT, new Plip(0.6));
        pliparound.put(Direction.RIGHT, new Plip(0.9));
        Action expected1  = new Action(Action.ActionType.ATTACK,Direction.TOP);
        Action expected2  = new Action(Action.ActionType.ATTACK,Direction.LEFT);
        Action expected3  = new Action(Action.ActionType.ATTACK,Direction.RIGHT);

        int top = 0;
        int left = 0;
        int right =0;
        int ntimes = 10000;
        for(int i=0;i<ntimes;i++){
            actual = c2.chooseAction(pliparound);
            if(actual.equals(expected1)){
                top += 1;
            }
            if(actual.equals(expected2)){
                left +=1;
            }
            if(actual.equals(expected3)){
                right +=1;
            }
        }
        System.out.println(top);
        System.out.println(left);
        System.out.println(right);
        assertEquals(ntimes/3,top,ntimes*0.05);
        assertEquals(ntimes/3,left,ntimes*0.05);
        assertEquals(ntimes/3,right,ntimes*0.05);


        // energy>=1 replicate random to empty space
        Clorus c3 = new Clorus(1.5);
        HashMap<Direction, Occupant> replicatearound = new HashMap<Direction, Occupant>();
        replicatearound.put(Direction.TOP, new Empty());
        replicatearound.put(Direction.BOTTOM, new Impassible() );
        replicatearound.put(Direction.LEFT, new Empty());
        replicatearound.put(Direction.RIGHT, new Empty());

        expected1  = new Action(Action.ActionType.REPLICATE,Direction.TOP);
        expected2  = new Action(Action.ActionType.REPLICATE,Direction.LEFT);
        expected3  = new Action(Action.ActionType.REPLICATE,Direction.RIGHT);

        top = 0;
        left = 0;
        right =0;
        ntimes = 10000;
        for(int i=0;i<ntimes;i++){
            actual = c3.chooseAction(replicatearound);
            if(actual.equals(expected1)){
                top += 1;
            }
            if(actual.equals(expected2)){
                left +=1;
            }
            if(actual.equals(expected3)){
                right +=1;
            }
        }
        System.out.println(top);
        System.out.println(left);
        System.out.println(right);
        assertEquals(ntimes/3,top,ntimes*0.05);
        assertEquals(ntimes/3,left,ntimes*0.05);
        assertEquals(ntimes/3,right,ntimes*0.05);


        // energy<1 move random to empty space
        Clorus c4 = new Clorus(0.5);
        HashMap<Direction, Occupant> movearound = new HashMap<Direction, Occupant>();
        movearound.put(Direction.TOP, new Empty());
        movearound.put(Direction.BOTTOM, new Impassible() );
        movearound.put(Direction.LEFT, new Empty());
        movearound.put(Direction.RIGHT, new Empty());

        expected1  = new Action(Action.ActionType.MOVE,Direction.TOP);
        expected2  = new Action(Action.ActionType.MOVE,Direction.LEFT);
        expected3  = new Action(Action.ActionType.MOVE,Direction.RIGHT);

        top = 0;
        left = 0;
        right =0;
        ntimes = 10000;
        for(int i=0;i<ntimes;i++){
            actual = c4.chooseAction(movearound);
            if(actual.equals(expected1)){
                top += 1;
            }
            if(actual.equals(expected2)){
                left +=1;
            }
            if(actual.equals(expected3)){
                right +=1;
            }
        }
        System.out.println(top);
        System.out.println(left);
        System.out.println(right);
        assertEquals(ntimes/3,top,ntimes*0.05);
        assertEquals(ntimes/3,left,ntimes*0.05);
        assertEquals(ntimes/3,right,ntimes*0.05);

    }
}
