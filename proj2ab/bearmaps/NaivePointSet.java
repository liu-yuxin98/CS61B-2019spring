package bearmaps;


import java.util.ArrayList;
import java.util.List;

public class NaivePointSet implements PointSet{
    private List<Point> Allpoints;
    public NaivePointSet(List<Point> points){
        Allpoints = points;
    }
    /* find the nearest point to position(x,y) in the pointset*/
    public Point nearest(double x, double y){
        Point gp = new Point(x,y);
        double nearest = Point.distance(x,Allpoints.get(0).getX(),y,Allpoints.get(0).getY());
        int index = 0;
        for(int i=0;i<Allpoints.size();i++){
            double distancei = Point.distance(x,Allpoints.get(i).getX(),y,Allpoints.get(i).getY());
            if(distancei<=nearest){
                nearest = distancei;
                index = i;
            }
        }
        return Allpoints.get(index);
    }

    public static void main(String[] args){
        Point p1 = new Point(1.1, 2.2); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(3.3, 4.4);
        Point p3 = new Point(-2.9, 4.2);
        NaivePointSet nn = new NaivePointSet(List.of(p1,p2,p3));
        Point ret = nn.nearest(3.0, 4.0); // returns p2
        ret.getX(); // evaluates to 3.3
        ret.getY(); // evaluates to 4.4
    }
}
