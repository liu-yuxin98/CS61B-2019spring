import java.util.ArrayList;
import java.util.List;

public class BubbleGrid {
    /**
     * Bubbles are stored in a 2-D array of 1’s and 0’s.
     * A 1 indicates there is a bubble at that position in the grid,and a 0 indicates there is a space.
     * A bubble will fall if is not “stuck.”*/



    public int[][] Grid;
    public int rows;
    public int columns;
    /* use WeightQuickUnion to store the stuck bubble*/
    public WeightQuickUnion stuckedBubble;
    public WeightQuickUnion UnstackedBubble;

    public void BullbeGrid(int[][] Bgrid){
        Grid = Bgrid;
        rows = Bgrid.length;
        columns = Bgrid[0].length;
        stuckedBubble = new WeightQuickUnion();
        stuckedBubble.UnionFind(rows*columns);
        List<Integer> sbubble = new ArrayList<Integer>();
        List<Integer> unsbubble = new ArrayList<Integer>();
        /* find a stuck bubble*/
        /** IF the stuck bubble is in position (i,j) then store ID=i*columns+j into AList sbubble
         *  If the (
         * */
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(Grid[i][j] ==1){
                    sbubble.add(i*columns+j); /* store (i,j) in AList sbubble*/
                } else{
                    unsbubble.add(i*columns+j);/* store (i,j) in AList unsbubble*/
                }
            }
        }
        /* store the ID of stuckedbubble into the stuckedBubble*/
        for(int i=0;i<sbubble.size();i++){
            stuckedBubble.connect(sbubble.get(0),sbubble.get(i));
        }

    }

    /** decide whether a bubble is stuck or not
     *A bubble is stuck if:
     * It is in the topmost row of the grid, or
     * It is orthogonally adjacent to a bubble that is stuck.
     * the position of bublle is (i,j)
     */
    public boolean isStuck(int i, int j){
       int positionid = i*rows+j;
        /* topmost*/
        if(i == rows-1){
            return true;
        } else {
            /*orthogonally to a stuck bubble*/
            /* the position id of the bubble is i*rows+j*/



        }

        return true;
    }
    /* decide whether two position is in the orthogonally position*/
    public boolean isOrthogonally(int i1,int j1,int i2,int j2){

    }


    /* returns the number of bubbles pop due to darts*/
    int[] popBubbles(int[][] darts){

        return null;
    }
}


