package hw2;

import edu.princeton.cs.algs4.QuickFindUF;
import org.junit.rules.Stopwatch;

public class PercolationStats {
    double[] fractionResults ;/* record the results in fractionResults*/
    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
       fractionResults = new double[T];
        /* repeate T times*/
        for(int i=0;i<T;i++){
            /* Initialize all sites to be blocked*/
            Percolation mypf = pf.make(N);
            int openedsite = 0;
            double fraction;
            /*Repeat the following until the system percolates*/
            while(true){
                /* choose a random site among blocked*/
                int row = (int)(Math.random()*N);
                int col = (int)(Math.random()*N);
                while( mypf.grid[row][col] ==1 ){
                    row = (int)(Math.random()*N);
                    col = (int)(Math.random()*N);
                }
                /* open the site*/
                mypf.open(row,col);
                openedsite += 1;
                /*The fraction of sites that are opened when
                the system percolates provides an estimate of the percolation threshold.
                 */
                if(mypf.percolates()){
                    fraction =(double) openedsite /(N*N);
                    break;
                }
            }
            /* append results into the fractionResults*/
            fractionResults[i] = fraction;
        }
    }
    // sample mean of percolation threshold
    public double mean(){
       double sum=0;
       double u=0;
        for(int i=0;i<fractionResults.length;i++){
            sum += fractionResults[i];
        }
        u = sum/fractionResults.length;
        return u;
    }

    // sample standard deviation of percolation threshold
    public double stddev()  {
        double item =0;
        double sum =0;
        for(int i=0;i<fractionResults.length;i++){
            sum += Math.pow(fractionResults[i]-mean(),2);
        }
        return sum/(fractionResults.length-1);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow()  {
        double u = mean();
        double sigma = Math.sqrt(stddev());
        double sqrtT = Math.sqrt(fractionResults.length);
        return u-1.96*sigma/sqrtT;
    }
    // high endpoint of 95% confidence interval
    public double confidenceHigh()     {
        double u = mean();
        double sigma = Math.sqrt(stddev());
        double sqrtT = Math.sqrt(fractionResults.length);
        return u+1.96*sigma/sqrtT;

    }

    public static void main(String[] args){

        /* incresase the N and T to see how the run time of PercolationStats will change*/
        /* store N and T in array*/
        int[] Ns = new int[]{128,256,512,1024};
        int[] Ts = new int[]{2,4,6,8};

        /* store results*/
        long[][] speedTestresults = new long[Ts.length][Ns.length];
        double[][] fractionResults = new double[Ts.length][Ns.length];

        /* run the test with different N and T*/
        for(int i=0;i<Ts.length;i++){
            for(int j=0;j<Ns.length;j++){
                /*  give value*/
                int T = Ts[i];
                int N = Ns[j];
                PercolationFactory pf = new PercolationFactory();
                /* calculate run time*/
                long now = System.currentTimeMillis();
                PercolationStats ps = new PercolationStats(N,T,pf);
                long runtime= System.currentTimeMillis() -now;
                /* print the results*/
                System.out.println("A "+N+"*"+N+" grid perform "+T+" times:");
                System.out.println("total run time of PercolationStats is "+runtime);
                System.out.println();
                /* store value*/
                speedTestresults[i][j] = runtime;
                fractionResults[i][j] = ps.mean();
            }
        }

        /* print the whole results fot the experiment*/
        /* print speedTestresults*/
        System.out.println("___________speedTestresults___________");
        for(int i=0;i< speedTestresults.length;i++){
            for(int j=0;j < speedTestresults[0].length;j++){
                System.out.print(speedTestresults[i][j]+" ");
            }
            System.out.println();
        }
        /* print fractionResults*/
        System.out.println("_______________fractionResults_______________");
        for(int i=0;i< fractionResults.length;i++){
            for(int j=0;j < fractionResults[0].length;j++){
                System.out.print(fractionResults[i][j]+" ");
            }
            System.out.println();
        }
    }

}
