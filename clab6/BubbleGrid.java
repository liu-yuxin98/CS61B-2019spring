import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.List;

public class BubbleGrid {
    /* 最好使用并查集来做，目前只用 union比较难*/
    private int[][] grid;
    private int rows; /* grid 一共有多少行*/
    private int columns;/* grid 一共有多少列*/
    private UnionFind StackedB;
    private UnionFind UnStackedB;
    private List<Integer> StakcedBubble = new ArrayList<>();


    /* Create new BubbleGrid with bubble/space locations specified by grid.
     * Grid is composed of only 1's and 0's, where 1's denote a bubble, and
     * 0's denote a space. */
    public BubbleGrid(int[][] grid) {
        this.grid = grid;
        rows = grid.length;;
        columns = grid[0].length;
    }

    /* Returns an array whose i-th element is the number of bubbles that
     * fall after the i-th dart is thrown. Assume all elements of darts
     * are unique, valid locations in the grid. Must be non-destructive
     * and have no side-effects to grid. */
    public int[] popBubbles(int[][] darts) {
        int dlength = darts.length; /* dart 的长度*/
        /* 所有 dart 作用后的 grid*/
        int[][] finalgrid = creatTempgrid(darts);
        /* 记录此时固定的bubble*/
        UnionFind sb = findStackedBubble(finalgrid);
        /* 反着添加 dart*/
        int [] fallingbubble = new int[darts.length];
        for(int i=0;i<darts.length;i++){
            int[] addbubble = darts[dlength - 1 - i];
            int ai = addbubble[0];
            int aj = addbubble[1];
            if(grid[ai][aj] == 1){ /* 如果 darts[i] 确实敲掉了一个bubble*/
               finalgrid[ai][aj] = 1;
               /* 记录此状态下，固定的bubble*/
               UnionFind cursb = findStackedBubble(finalgrid);
               int fallbubble = cursb.sizeOf(rows*columns)- sb.sizeOf(rows*columns);
               sb = cursb;
               if(fallbubble == 0){
                   fallingbubble[i] = 0;
               } else{
                   fallingbubble[i] = fallbubble-1;
               }
            } else{ /* darts[i] 没有敲掉bubble*/
                /*finalgrid无变化*/
                /*fallingbubble[i]=0*/
                fallingbubble[i] = 0;
            }
        }
        int [] Fallingbubble = new int[fallingbubble.length];
        for(int i=0;i<fallingbubble.length;i++){
            Fallingbubble[i] = fallingbubble[fallingbubble.length-1-i];
        }
        return Fallingbubble;

    }

    /* 判断在 row=N,column=M的grid中  (p,q) 是否在(i，j) 四周（上，下，左，右）*/
    public boolean isNearby(int N, int M,int i, int j, int p, int q){
        int rowdiffer = Math.abs(i-p);
        int columnsdiffer = Math.abs(j-q);
        if(rowdiffer+columnsdiffer != 1){
            return false;
        } else{
            if(p<0 || p>=N || q<0 || q>=M){
                return false;
            } else{
                return true;
            }
        }
    }

    /* create a tempGrid*/
    /* 创建一个 temp grid 来记录被dart刺破的bublle，单纯把原来有Bubble的地方变为0,并不改变falling bubble*/
    public int[][] creatTempgrid(int[][] ADDdarts){
        int[][] tempGrid = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                tempGrid[i][j] = grid[i][j];
            }
        }

        for(int i=0;i< ADDdarts.length;i++){
            int rindex = ADDdarts[i][0];
            int cindex = ADDdarts[i][1];
            tempGrid[rindex][cindex] =0;
        }
        return tempGrid;
    }

    /* 记录一个grid中stack的元素*/
    public UnionFind findStackedBubble(int[][] tempgrid){
        int N = tempgrid.length;
        int M = tempgrid[0].length;
        /* create StackedB, 最后一个 id=rows*columns 默认是stacked*/
        StackedB = new UnionFind(N*M+1);
        int virtualid = N*M;
        /* 对于 （i，j)的id 是 1*columns+j*/
        for(int i=0;i< N;i++){
            for(int j=0;j< M;j++){
                /* top most && has bubble*/
                if(i==0 && tempgrid[i][j] ==1){
                    StackedB.union(j,virtualid);
                }
                /* adjacent to a stacked bubble*/
                else{
                    /* 首先判断 (i,j0 位置是否是一个bubble*/
                    if(tempgrid[i][j] == 1){
                        /* up 上方*/
                        if(isNearby(N,M,i,j,i-1,j)){
                            if(tempgrid[i-1][j]==1){
                                StackedB.union(i*M+j,(i-1)*M+j);
                            }
                        }
                        /* left 左*/
                        if(isNearby(N,M,i,j,i,j-1)  ){
                            if(tempgrid[i][j-1]==1){
                                StackedB.union(i*M+j,i*M+j-1);
                            }
                        }
                        /*right 右*/
                        if(isNearby(N,M,i,j,i,j+1)){
                            if(tempgrid[i][j+1]==1){
                                StackedB.union(i*M+j,i*M+j+1);
                            }
                        }
                        /* down 下方*/
                        if(isNearby(N,M,i,j,i+1,j) ){
                            if(tempgrid[i+1][j]==1){
                                StackedB.union(i*M+j,(i+1)*M+j);
                            }

                        }

                    }
                }
            }
        }
        return StackedB;
    }

    /*根据 stacked bubble 对应的 UnionFind 来给出一个状态 grid*/
    public int[][] getStatusgrid(UnionFind currentuf){
        int lastid = rows*columns;
        int [] connectinfo = currentuf.parents;
        int [][] statusgrid = new int[rows][columns];
        int positionid;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                positionid = i*columns+j;
                /* connectinfo[positionid] == lastid -> stucked then statusgrid[i,j]=1*/
                if(connectinfo[positionid] == lastid){
                    statusgrid[i][j] = 1;
                } else{
                    statusgrid[i][j] = 0;
                }
            }
        }
        return statusgrid;
    }


}
