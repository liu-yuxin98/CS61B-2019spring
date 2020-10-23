package creatures;

import huglife.Creature;

import edu.princeton.cs.algs4.StdRandom;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;


import java.awt.Color;
import java.util.*;

public class Clorus extends Creature {

    /**
     * Creates a creature with the name N. The intention is that this
     * name should be shared between all creatures of the same type.
     *
     * @param n
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * creates plip with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }
    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return color(r, g, b);
    }

    public void attack(Creature c) {
        energy+=c.energy();
    }
    /**
     * Clorus should lose 0.03 units of energy when moving.
     */
    public void move() {
        energy -= 0.03;

    }


    /**
     * Clorus lose 0.01 energy when staying .
     */
    public void stay() {
        energy -= 0.01;
    }
    /**
     * Clorus and their offspring each get 50% of the energy, with none
     * lost to the process. Now that's efficiency! Returns a baby
     * Plip.
     */
    public Clorus replicate() {
        energy /= 2;
        Clorus rc = new Clorus(energy);
        rc.b = b;
        rc.g = g;
        rc.r = r;
        return rc;
    }
    /**
     *  1) If there are no empty squares, the Clorus will STAY (even if there are Plips nearby
     *  they could attack since plip squares do not count as empty squares).
     *  2) Otherwise, if any Plips are seen, the Clorus will ATTACK one of them randomly.
     *  3) Otherwise, if the Clorus has energy greater than or equal to one, it will REPLICATE
     *  to a random empty square.
     *  4) Otherwise, the Clorus will MOVE to a random empty square.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors){
           List<String> emptyNeighbors = new ArrayList<String>();
           List<String> plipNeighbors = new ArrayList<String>();
            boolean Noempty = true;
            boolean anyplip = false;
            for(Direction key:neighbors.keySet()){
                if(neighbors.get(key).name().equals("empty")){
                    emptyNeighbors.add(key.name());
                    Noempty = false;
                }
                if(neighbors.get(key).name().equals("plip")){
                    plipNeighbors.add(key.name());
                    anyplip = true;
                }
            }
            /* rule1 no empty squars c will stay*/
            if(Noempty){
                return new Action(Action.ActionType.STAY);
            } else{
                /* rule2 attack random plip*/
                if(anyplip){
                    int index = (int)(Math.random()*plipNeighbors.size());
                    String attackdirection = plipNeighbors.get(index);
                    return new Action(Action.ActionType.ATTACK, Direction.valueOf(attackdirection));
                } else{
                    /* rule3  energy>1 replicate to random empty space*/
                    if(energy>=1){
                        int index = (int)(Math.random()*emptyNeighbors.size());
                        String replicatedirection = emptyNeighbors.get(index);
                        return new Action(Action.ActionType.REPLICATE, Direction.valueOf(replicatedirection));
                    } else { /*rule4  energy<1 move to random empty space*/
                        int index = (int)(Math.random()*emptyNeighbors.size());
                        String replicatedirection = emptyNeighbors.get(index);
                        return new Action(Action.ActionType.MOVE, Direction.valueOf(replicatedirection));
                    }


                }

            }

    }

}
