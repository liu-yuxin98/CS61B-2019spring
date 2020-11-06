package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    public int[][] grid; /* percolation grid where 0->blocked 1->open*/
    private int n; /* n*n grid*/
    /* record the connnection situation*/
    public WeightedQuickUnionUF fullopensite ;


    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N){
        fullopensite = new WeightedQuickUnionUF(N*N+1);
        if(N<=0){
            throw new IllegalArgumentException();
        }
        n = N;
        grid = new int[n][n];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                grid[i][j] = 0;
            }
        }

    }
    // open the site (row, col) if it is not open already
    public void open(int row, int col){
        if(row>=n || col>=n || row<0 || col<0){
            throw new IllegalArgumentException();
        }
        grid[row][col] = 1;
        /* union opensite*/
        if(row == 0){
            fullopensite.union(col,n*n);
        } else {
            int[] nearbyopens = nearbyOpenSite(row,col);
            for(int i=0;i<nearbyopens.length;i++){
                if(nearbyopens[i]>=0){
                    fullopensite.union(row*n+col,nearbyopens[i]);
                }
            }
        }

    }

    // is the site (row, col) open?  open and not isfull
    public boolean isOpen(int row, int col){
        if(row>=n || col>=n || row<0 || col<0){
            throw new IllegalArgumentException();
        }
        if(row == 0){
            return false;
        } else {
            return (grid[row][col] == 1 && !isFull(row,col));
        }
    }



    /* A full site is an open site that can be connected to an open site in the top row
    via a chain of neighboring (left, right, up, down) open sites.
     * */
    // is the site (row, col) full?
    public boolean isFull(int row, int col)  {
       return fullopensite.connected(row*n+col,n*n);
    }

    /* find(row,col) opensite,return id*/
    public int[] nearbyOpenSite(int row,int col){
        int[] nearbyopens = new int[4]; /*if not open return -1*/
        /* up*/
        if(row-1<0){ /* upper bound*/
            nearbyopens[0] = -1;
        } else {
            if(grid[row-1][col] ==1){ /* open site or fullsite*/
                nearbyopens[0] = n*(row-1)+col;
            } else{ /* block site*/
                nearbyopens[0] = -1;
            }
        }
        /* down*/
        if(row>=n-1){ /* lower bound*/
            nearbyopens[1] = -1;
        } else {
            if(grid[row+1][col]==1){ /* open site*/
                nearbyopens[1] = n*(row+1)+col;
            } else{ /* block site*/
                nearbyopens[1] = -1;
            }
        }
        /*left*/
        if(col<=0){ /* left bound*/
            nearbyopens[2] = -1;
        } else {
            if(grid[row][col-1]==1){ /* open site*/
                nearbyopens[2] = n*row+col-1;
            } else{ /* block site*/
                nearbyopens[2] = -1;
            }
        }
        /*right*/
        if(col>=n-1){ /* right bound*/
            nearbyopens[3] = -1;
        } else {
            if(grid[row][col+1]==1){ /* open site*/
                nearbyopens[3] = n*row+col+1;
            } else{ /* block site*/
                nearbyopens[3] = -1;
            }
        }
        return nearbyopens;
    }


    // number of open sites
    public int numberOfOpenSites()  {
        int opennumber=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    opennumber+=1;
                }
            }
        }
        return opennumber;
    }
    // does the system percolate
    public boolean percolates(){

        for(int col=0;col<n;col++){
            if(isFull(n-1,col) ){
                return true;
            }
        }

        return  false;
    }
    public static void main(String[] args){
        double p;
        p = (double)8/9;
      System.out.println(p);
    }

}
