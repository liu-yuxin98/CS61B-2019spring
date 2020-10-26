import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleGridTest {

    @Test
    public void testBasic() {

        int[][] grid = {{1, 0, 0, 0},
                        {1, 1, 1, 0}};
        int[][] darts = {{1, 0}};
        int[] expected = {2};

        validate(grid, darts, expected);
    }

    private void validate(int[][] grid, int[][] darts, int[] expected) {
        BubbleGrid sol = new BubbleGrid(grid);
        assertArrayEquals(expected, sol.popBubbles(darts));
    }
    @Test
    public void TestisNearby(){
        int[][] grid = {{1, 0, 0, 0},
                {1, 1, 1, 0}};
        BubbleGrid bg = new BubbleGrid(grid);
        /*5*5 Grid*/
        /* 左上角*/
        assertFalse(bg.isNearby(5,5,0,0,-1,0));
        assertFalse(bg.isNearby(5,5,0,0,0,-1));
        assertTrue(bg.isNearby(5,5,0,0,0,1));
        assertTrue(bg.isNearby(5,5,0,0,1,0));
        /* 右下角*/
        assertFalse(bg.isNearby(5,5,4,4,4,5));
        assertFalse(bg.isNearby(5,5,4,4,5,4));
        assertTrue(bg.isNearby(5,5,4,4,3,4));
        assertTrue(bg.isNearby(5,5,4,4,4,3));
        /* 左边*/
        assertFalse(bg.isNearby(5,5,0,1,0,-1));
        assertFalse(bg.isNearby(5,5,0,2,0,4));
        assertTrue(bg.isNearby(5,5,0,3,0,4));
        assertTrue(bg.isNearby(5,5,0,3,1,3));
        /*下边*/
        assertFalse(bg.isNearby(5,5,4,1,4,3));
        assertFalse(bg.isNearby(5,5,4,2,3,6));
        assertTrue(bg.isNearby(5,5,4,3,4,4));
        assertTrue(bg.isNearby(5,5,4,3,3,3));
        /* 内部*/
        assertFalse(bg.isNearby(5,5,2,2,1,3));
        assertFalse(bg.isNearby(5,5,3,2,3,4));
        assertTrue(bg.isNearby(5,5,2,3,2,4));
        assertTrue(bg.isNearby(5,5,3,3,4,3));
    }


    @Test
    public void TestcreatTempGrid(){
        int[][] grid = {
                {1, 1, 0},
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 1}};
        BubbleGrid BG = new BubbleGrid(grid);
        int[][] darts = {{2, 0},{2,2}};
        int[][] tempGrid = BG.creatTempgrid(darts);

    }

    @Test
    public void TestfindStackedBubble(){
        int[][] grid = {
                {1, 1, 0},
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 1}};
        BubbleGrid BG = new BubbleGrid(grid);
        int[][] darts = {{2, 0},{2,2}};
        UnionFind stucked = BG.findStackedBubble(grid);
    }
    @Test
    public void Testpop(){
        int[][] grid1 = {
                {1, 1, 0,1},
                {1, 0, 0,1},
                {1, 1, 0,0},
                {1, 1, 1,1}};
        BubbleGrid BG1 = new BubbleGrid(grid1);
        int[][] darts1 = {{2, 0},{3,1},{0,3}};
        int[] pop1 = BG1.popBubbles(darts1);
        int[] expected1 = new int[]{5, 0, 1};
        assertArrayEquals(expected1,pop1);
        int[][] grid2 = {
                {1, 1, 0},
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 1}};
        BubbleGrid BG2 = new BubbleGrid(grid2);
        int[][] darts2 = {{2, 2},{2,0}};
        int[] pop2 = BG2.popBubbles(darts2);
        int[] expected2 = new int[]{0,4};
        assertArrayEquals(expected2,pop2);

    }
    @Test
    public void TestgetStatusGrid(){
        int[][] grid = {
                {1, 1, 0},
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 1}};
        BubbleGrid BG = new BubbleGrid(grid);
        UnionFind uf = new UnionFind(13);
        uf.union(0,12);
        uf.union(1,12);
        uf.union(3,12);
        int [][] statusGrid = BG.getStatusgrid(uf);

    }

}
