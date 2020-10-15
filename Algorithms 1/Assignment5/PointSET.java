import java.util.ArrayList;
import java.util.TreeSet;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class PointSET {
    
    private final TreeSet<Point2D> pointSet;
    
   // construct an empty set of points
   public PointSET()   {
       pointSet = new TreeSet<Point2D>();       
   }

   // is the set empty?
   public boolean isEmpty() {
       return pointSet.isEmpty();
   }

   // number of points in the set
   public int size() {
       return pointSet.size();
   }
   
   // add the point to the set (if it is not already in the set)
   public void insert(Point2D p) {
       if (p == null) throw new IllegalArgumentException();
       pointSet.add(p);
   }
   
   // does the set contain point p?
   public boolean contains(Point2D p) {
       if (p == null) throw new IllegalArgumentException();
       boolean ret = false;
       if (!pointSet.isEmpty()) {
           ret = pointSet.contains(p); // might only return the exact object and not check if coordinates are the same
       }
       return ret;
   }
   
   // draw all points to standard draw
   public void draw() {
       if (!pointSet.isEmpty()) {
           for (Point2D point : pointSet) {
               point.draw();
           }    
       }
   }
   
   // all points that are inside the rectangle (or on the boundary)
   public Iterable<Point2D> range(RectHV rect) {
       if (rect == null) throw new IllegalArgumentException();
       
       ArrayList<Point2D> ret = new ArrayList<Point2D>();
       
       for (Point2D curPoint : pointSet) {
           if (curPoint.x() >= rect.xmin() && curPoint.x() <= rect.xmax()) {
               if (curPoint.y() >= rect.ymin() && curPoint.y() <= rect.ymax()) {
                   ret.add(curPoint);
               }
           }
       }
       
       return ret;
   }
   
   // a nearest neighbor in the set to point p; null if the set is empty
   public Point2D nearest(Point2D p) {
       if (p == null) throw new IllegalArgumentException();
       Point2D nearest = null;
       
       if (!isEmpty()) {
           nearest = pointSet.first();
           double shortestDist = p.distanceSquaredTo(nearest);
           for (Point2D curPoint : pointSet) {
               if (p.distanceSquaredTo(curPoint) < shortestDist) {
                   shortestDist = p.distanceSquaredTo(curPoint);
                   nearest = curPoint;
               }
           }
       }
       
//       System.out.println("Nearest Brute: " + nearest.toString());
       return nearest;
   } 
   
   // unit testing of the methods (optional)
   public static void main(String[] args){//optional
   } 
   
}