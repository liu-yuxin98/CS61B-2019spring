package bearmaps;

import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KDTreeTest {

    public KDTree buildKdTree(){
        Point p1 = new Point(2, 3); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(4, 2);
        Point p3 = new Point(4, 5);
        Point p4 = new Point(3, 3);
        Point p5 = new Point(1, 5);
        Point p6 = new Point(4, 4);
        KDTree kd = new KDTree(List.of(p1,p2,p3,p4,p5,p6));
        return kd;
    }

    /* get N random points*/
    public List<Point> getRadomPoints(int N){
        List<Point> pointList = new ArrayList<>();
        for(int i=0;i<N;i++){
            double x = Math.random();
            double y = Math.random();
            Point pi = new Point(x,y);
            pointList.add(pi);
        }
        return pointList;
    }


    private void RandomTest(int N, int Q){
        /* random test*/
        List<Point> pointList = getRadomPoints(N);
        NaivePointSet nn = new NaivePointSet(pointList);
        KDTree kdt = new KDTree(pointList);
        List<Point> querypoints = getRadomPoints(Q);
        for(Point p:querypoints){
            Point expected = nn.nearest(p.getX(),p.getY());
            Point actual1 = kdt.nearest(p.getX(),p.getY());
            assertEquals(expected,actual1);
        }
    }

    /* random test for KDTree N points  Q goal*/
    private void RandomTestforKDTree(int N, int Q){
        List<Point> pointList = getRadomPoints(N);
        KDTree kdt = new KDTree(pointList);
        List<Point> querypoints = getRadomPoints(Q);
        for(Point p:querypoints){
            Point nearestPoint = kdt.nearest(p.getX(),p.getY());
        }
    }

    /* random test for KDTree2 N points  Q goal*/
    private void RandomTestforKDTree2(int N, int Q){
        List<Point> pointList = getRadomPoints(N);
        KDTree kdt = new KDTree(pointList);
        List<Point> querypoints = getRadomPoints(Q);
        for(Point p:querypoints){
            Point nearestPoint = kdt.nearest2(p.getX(),p.getY());
        }
    }



    /* random test for NaivePointSet N points  Q goal*/
    private void RandomTestforNaivePointSet(int N, int Q){
        List<Point> pointList = getRadomPoints(N);
        NaivePointSet nn = new NaivePointSet(pointList);
        List<Point> querypoints = getRadomPoints(Q);
        for(Point p:querypoints){
            Point nearestPoint = nn.nearest(p.getX(),p.getY());
        }
    }


    @Test
    /* test nearest*/
    public void TestNearest(){
        KDTree kd = buildKdTree();
        Point actual = kd.nearest(0,7);
        Point expected = new Point(1,5);
        assertEquals(expected,actual);
        RandomTest(1000,200);

    }

    @Test
    public void TestSpeed(){
        int N = 100000;
        int M = 10000;
        long start = System.currentTimeMillis();
        RandomTestforNaivePointSet(N,M);
        long end = System.currentTimeMillis();
        System.out.println("NaivePointSet with "+N+" points"+M+"goals: " + (end - start)/1000.0 +   " seconds.");

        start = System.currentTimeMillis();
        RandomTestforKDTree(N,M);
        end = System.currentTimeMillis();
        System.out.println("KDTree with "+N+" points"+M+"goals: " + (end - start)/1000.0 +   " seconds.");

    }


}
