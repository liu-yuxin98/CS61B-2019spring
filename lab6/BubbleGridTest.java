import org.junit.Test;

public class BubbleGridTest {
    @Test
    public void TestConstructor(){
        /** test if constructor works fine and store the stucked bubble into
         *   stuckedBubble(whose type is WeightQuickUnion)
         */
        int[][] grid = new int[][]{
                {1,1,0},
                {1,0,0},
                {1,1,0},
                {1,1,1}};
        BubbleGrid bg = new BubbleGrid();
        bg.BullbeGrid(grid);
        WeightQuickUnion wqu = new WeightQuickUnion();
        wqu.UnionFind(12);
        wqu.connect(0,1);
        wqu.connect(0,3);
        wqu.connect(0,6);
        wqu.connect(0,7);
        wqu.connect(0,9);
        wqu.connect(0,10);
        wqu.connect(0,11);
        System.out.println(wqu.equals(bg.stuckedBubble));

    }
}
