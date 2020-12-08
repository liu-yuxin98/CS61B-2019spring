package bearmaps;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class KDTree implements PointSet{
    private static boolean ORIENTATION = true;
    private static boolean HORIZONTAL = false;
    private static boolean TEMP = true;
    private Node root;

    private class Node{
        private Point p;
        private boolean orient; /* horizontal or orientation*/
        private Node left;
        private Node right;

        public Node(Point point, Boolean ori){
            p = point;
            orient = ori;
        }
    }

    /* add a point to the k-d tree*/
    private void add(Point addp){
        root = helpadd(addp,root,false);
    }

    /* helper method for add*/
    private Node helpadd(Point addp,Node pos,boolean ori){
        ori = ! ori;
        if(pos == null){
            return new Node(addp,ori);
        }
        int cmp = compareTwoPoints(addp,pos.p,pos.orient);
        if(cmp>=0){
            pos.right = helpadd(addp,pos.right,ori) ;
        }
        else{
            pos.left = helpadd(addp,pos.left,ori);
        }
        return pos;
    }


    /* compare two points and see where should a point go
    go left return -1;
    go right return 1; addp>rootp
     */
    private int compareTwoPoints(Point addp, Point rootp,Boolean orientation){
            /* 首先判断 rootp 是 orientation or horizontal*/
            /* orientation*/
            double res;
            if(orientation == ORIENTATION){
                res =  addp.getX() - rootp.getX();
            } else{
                res = addp.getY() - rootp.getY();
            }
            if(res >=0){
                return 1;
            } else{
                return -1;
            }
    }

    public KDTree(List<Point> points){
            if(points.size() == 0){
                throw new NoSuchElementException();
            }
            root = new Node(points.get(0),true);
            for(int i=1;i< points.size();i++){
                this.add(points.get(i));
            }
    }

    /*return distance between two points*/
    public double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2));
    }
    /* if direction = 0 -> badside = leftchild
    *  if direction = 1 -> badside = rightchild */
    public boolean IsBadsideStillUseful(Node original,Node badside, Point goal, Node best){
        double bestdistance = distance(goal, best.p);
        double bestPossibleDistance ;
        Point bestPossiblePoint;
        boolean flag = false;

        /* original is orientation*/
        if(original.orient == ORIENTATION){
            bestPossibleDistance = Math.abs(original.p.getX() - goal.getX());
            if(bestPossibleDistance<bestdistance){
                flag = true;
            }

        } else{ /* original is horizontal*/
            bestPossibleDistance = Math.abs(original.p.getY() - goal.getY());
            if(bestPossibleDistance<bestdistance){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public Point nearest(double x,double y){
        Point goal = new Point(x,y);
        Node res = nearest(root,goal,root);
        return res.p;
    }

    private Node nearest(Node n, Point goal, Node best){
        if(n==null){
            return best;
        }
        if(distance(n.p,goal)<distance(best.p, goal)){
            best = n;
        }
        int cmp = compareTwoPoints(goal,n.p,n.orient);
        Node goodside;
        Node badside;

        if(cmp>=0){
            goodside = n.right;
            badside = n.left;
        } else{
            goodside = n.left;
            badside = n.right;
        }
        best = nearest(goodside,goal,best);

        /* if badside could still has something useful
        *        best = nearest3(badside,goal,best);
        * */
        if( IsBadsideStillUseful(n,badside,goal,best) ){
            best = nearest(badside,goal,best);
        }
        return best;
    }



    public Point nearest2(double x, double y){
        Point goal = new Point(x,y);
        Node nearP = nearest2(root,goal,root);
        return nearP.p;

    }
    private Node nearest2(Node n, Point goal, Node best){
        if(n==null){
            return best;
        }
        if(distance(n.p,goal)<distance(best.p, goal)){
            best = n;
        }
        int cmp = compareTwoPoints(goal,n.p,n.orient);
        Node goodside;
        Node badside;
        if(cmp>=0){
            goodside = n.left;
            badside = n.right;
        } else{
            goodside = n.right;
            badside = n.left;
        }
        best = nearest2(goodside,goal,best);
        best = nearest2(badside,goal,best);

        return best;
    }




    public static void main(String[] args){
        Point p1 = new Point(2, 3); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(4, 2);
        Point p3 = new Point(4, 5);
        Point p4 = new Point(3, 3);
        Point p5 = new Point(1, 5);
        Point p6 = new Point(4, 4);
        Point p7 = new Point(0,3);
        Point p8 = new Point(1,7);
        KDTree kd = new KDTree(List.of(p1,p2,p3,p4,p5,p6,p7,p8));

    }
}
