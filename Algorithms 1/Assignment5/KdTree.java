import java.util.ArrayList;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
    
    private Node2D root;
    private int size;
    
   // construct an empty set of points
   public         KdTree(){
       root = null;
       size = 0;
   } 
   
   // is the set empty?
   public           boolean isEmpty(){
       return size == 0 ? true : false;
   }

   // number of points in the set
   public               int size(){
       return size;
   }
   
   // add the point to the set (if it is not already in the set)
   public              void insert(Point2D p){
       if (p == null) throw new IllegalArgumentException();
       if (contains(p)) {
           return;
       }
       Node2D newNode = null;
       if (root == null) {           
           newNode = new Node2D(p, null);
           root = newNode;
       }
       else {
           boolean keepSearching = true;
           Node2D currentSearch = root;
           while (keepSearching) {
               // check x-coordinate
               if (currentSearch.getLevel() % 2 != 1) {
                   // curX > pX
                   if(currentSearch.getPoint().x() > p.x()) {
                       if(currentSearch.hasLeft()) {
                           currentSearch = currentSearch.getLeft();
                       }
                       else {
                           newNode = new Node2D(p, currentSearch);
                           currentSearch.setLeft(newNode);
                           keepSearching = false;
                       }
                   }
                   // curX < pX
                   else {
                       // check right side
                       if(currentSearch.hasRight()) {
                           currentSearch = currentSearch.getRight();
                       }
                       else {
                           newNode = new Node2D(p, currentSearch);
                           currentSearch.setRight(newNode);
                           keepSearching = false;
                       }
                   }
               }
               //check y-coordinate
               else {
                   // curY > pY
                   if(currentSearch.getPoint().y() > p.y()) {
                       if(currentSearch.hasLeft()) {
                           currentSearch = currentSearch.getLeft();
                       }
                       else {
                           newNode = new Node2D(p, currentSearch);
                           currentSearch.setLeft(newNode);
                           keepSearching = false;
                       }
                   }
                   // curY < pY
                   else {
                       // check right side
                       if(currentSearch.hasRight()) {
                           currentSearch = currentSearch.getRight();
                       }
                       else {
                           newNode = new Node2D(p, currentSearch);
                           currentSearch.setRight(newNode);
                           keepSearching = false;
                       }
                   }
                   
               }
           }
       }
       size++;
   }
   
   // does the set contain point p?
   public           boolean contains(Point2D p){
       if (p == null) throw new IllegalArgumentException();
       boolean ret = false;
       if(root == null) {
           ret = false;
       }
       else {
           Node2D curNode = root;
//           System.out.println(curNode.getPoint().toString() + " (root) == " + p.toString() + " = " + curNode.getPoint().equals(p));
           boolean keepRunning = true;
           while (keepRunning) {
//               System.out.println(curNode.getPoint().toString() + " == " + p.toString() + " = " + curNode.getPoint().equals(p));
               if(curNode.getPoint().equals(p)) {
                   ret = true;
                   break;
               }
               else if(curNode.hasNext()){
                 //even level: 0,2,4 compare X
                   if(curNode.getLevel() % 2 == 0) {
//                       curX > px -> go left
                       if(curNode.getPoint().x() > p.x()) {
                           if(curNode.hasLeft()) {
                               curNode = curNode.getLeft();
                           }
                           else {
                               ret = false;
                               keepRunning = false;
//                               System.out.println("curX > px");
                           }
                       }
//                       curX < px -> go right
                       else {
                           if (curNode.hasRight()) {
                               curNode = curNode.getRight();
                           }
                           else {
                               ret = false;
                               keepRunning = false;
//                               System.out.println("curX < px");
                           }
                       }
                   }
                   // odd level: 1, 3, 5
                   else {
                       // curY > py -> go left
                       if (curNode.getPoint().y() > p.y()) {
                           if(curNode.hasLeft()) {
                               curNode = curNode.getLeft();
                           }
                           else {
                               ret = false;
                               keepRunning = false;
//                               System.out.println("curY > pY");
                           }
                       }
//                       curX < px -> go right
                       else {
                           if (curNode.hasRight()) {
                               curNode = curNode.getRight();
                           }
                           else {
                               ret = false;
                               keepRunning = false;
//                               System.out.println("curY < pY");
                           }
                       }   

                   }
               }
               else {
                   ret = false;
                   keepRunning = false;
//                   System.out.println("No next");
               }
               
               
           }         
       }
       return ret;
   }
   
   // draw all points to standard draw
   public              void draw(){
       if (!isEmpty()) {
           draw(root);
       }
   }
   
   private void draw (Node2D input) {
       input.draw();
              if(input.hasLeft()) {
                  draw(input.getLeft());
              }
              
              if(input.hasRight()) {
                  draw(input.getRight());
              }
   }
   
   // all points that are inside the rectangle (or on the boundary)
   public Iterable<Point2D> range(RectHV rect){
       if (rect == null) throw new IllegalArgumentException();
       ArrayList<Point2D> ret =  new ArrayList<Point2D>();
       
       if (isEmpty()) {
           ret = null;
       }
       else {
           ret = range(rect, root, ret);
       }
      
       return ret;
}
     
   private ArrayList<Point2D> range (RectHV rect, Node2D node, ArrayList<Point2D> ret){
       Point2D curPoint = node.getPoint();
       
//       if (rect.contains(curPoint) && !ret.contains(curPoint)) {
       if (rect.contains(curPoint) ) {
           ret.add(curPoint);
           
       }
       // I get in here multiple times from the same subtree??!!
       double nodeX = curPoint.x();
       double nodeY = curPoint.y();
       
       if (node.hasLeft()) {
           if (node.getLeft().getRect().intersects(rect)) {
               ret = range(rect, node.getLeft(), ret);
           }
       }
       
       if (node.hasRight()) {
           if (node.getRight().getRect().intersects(rect)) {
               ret = range(rect, node.getRight(), ret);
           }
       }
      
       
              
       return ret;
   }
   
   // a nearest neighbor in the set to point p; null if the set is empty
   public           Point2D nearest(Point2D p){
       if (p == null) throw new IllegalArgumentException();
       Point2D ret = null;
       
       if(!isEmpty()) {
           ret = nearest(root, null, p);
       }
       
       return ret;
   }
   
   private Point2D nearest (Node2D curNode, Point2D closest, Point2D query) {
//       Point2D ret = closest;
       
       if (closest == null) {
           closest = curNode.getPoint();
           if(!curNode.hasNext()) {
               closest = curNode.getPoint();
           }
           else if (curNode.hasLeft() && curNode.hasRight()) {
               if (query.x() < closest.x()) {
                   closest = nearest(curNode.getLeft(), closest, query);
                   closest = nearest(curNode.getRight(), closest, query);
               }
               else {
                   closest = nearest(curNode.getRight(), closest, query);
                   closest = nearest(curNode.getLeft(), closest, query);
               }
           }
           else if (curNode.hasLeft()) {
               curNode = curNode.getLeft();
               closest = nearest(curNode, closest, query);
           }
           else {
               //hasRight()
               curNode = curNode.getRight();
               closest = nearest(curNode, closest, query);
           }
       }
       else {
           if (closest.distanceSquaredTo(query) <= curNode.getRect().distanceSquaredTo(query)) {
               //basically do nothing
           }
           else {
               // curNode.Rect is closer or contains query
               //set closest to curPoint if it is closer than closest
               closest = query.distanceSquaredTo(closest) > query.distanceSquaredTo(curNode.getPoint()) ? curNode.getPoint() : closest;
               
               if (curNode.hasNext()) {
                   if (curNode.level % 2 == 0) {
                       //even level -> compare x                        
                       if (curNode.hasLeft() && curNode.hasRight()) {
                           if (query.x() < curNode.getPoint().x()) {
                               closest = nearest(curNode.getLeft(), closest, query);
                               closest = nearest(curNode.getRight(), closest, query);
                           }
                           else {
                               closest = nearest(curNode.getRight(), closest, query);
                               closest = nearest(curNode.getLeft(), closest, query);
                           }
                       }
                       else if (curNode.hasLeft()) {
                           curNode = curNode.getLeft();
                           closest = nearest(curNode, closest, query);
                       }
                       else {
                           //hasRight()
                           curNode = curNode.getRight();
                           closest = nearest(curNode, closest, query);
                       }
                   }
                   else {
                       //odd level -> compare y
                       if (curNode.hasLeft() && curNode.hasRight()) {
                           if (query.y() < curNode.getPoint().y()) {
                               closest = nearest(curNode.getLeft(), closest, query);
                               closest = nearest(curNode.getRight(), closest, query);
                           }
                           else {
                               closest = nearest(curNode.getRight(), closest, query);
                               closest = nearest(curNode.getLeft(), closest, query);
                           }
                       }
                       else if (curNode.hasLeft()) {
                           curNode = curNode.getLeft();
                           closest = nearest(curNode, closest, query);
                       }
                       else {
                           //hasRight()
                           curNode = curNode.getRight();
                           closest = nearest(curNode, closest, query);
                       }
                       
                   }
               }
//               else {
//                   closest = closest;
//               }

               
           }
       }
       
       
       
       
       return closest;
   }
   
//   public void printTree() {
//       printTree(root);
//   }
//   
//   private void printTree(Node2D node) {
//       System.out.println(node.getPoint().toString() + " Level= " + node.getLevel());
//       
//       if (node.hasLeft()) {
//           printTree(node.left);
//       }
//       
//       if (node.hasRight()) {
//           printTree(node.right);
//       }
//   }
   
   // unit testing of the methods (optional)
   public static void main(String[] args){//optional
       
       KdTree kd = new KdTree();
       kd.insert(new Point2D(0.7, 0.2));
       kd.insert(new Point2D(0.5, 0.4));
       kd.insert(new Point2D(0.2, 0.3));
       kd.insert(new Point2D(0.4, 0.7));
       kd.insert(new Point2D(0.9, 0.6));
       
       ArrayList<Point2D> list = (ArrayList<Point2D>) kd.range(new RectHV(0.0, 0.0, 0.5, 0.5));
       
       for(Point2D point : list) {
           System.out.println(point.toString());
       }
       
//       kd.printTree();
   }
   
   
   
   private class Node2D {
       private Point2D point; 
       private int level;
       private Node2D prev;
       private Node2D right;
       private Node2D left;
       private RectHV rect;
       
       public Node2D(Point2D point, Node2D prev) {
           this.point = point;
           this.prev = prev;
           if (prev == null) {
               level = 0;
           }
           else {
               level = prev.getLevel() + 1;    
           }
           rect = calcRect();
//           System.out.println(rect.toString());
       }
       
       private RectHV calcRect() {
           RectHV prevRect = null;
           if(prev != null) {
               prevRect = prev.getRect(); 
           }
               
           if(level == 0) {
               return new RectHV(0.0, 0.0, 1.0, 1.0);
           }
           else if(level % 2 == 1){
               if(point.x() < prev.getPoint().x()) {
                   
                   return new RectHV(prevRect.xmin(), prevRect.ymin(), prev.getPoint().x() ,prevRect.ymax());
               }
               else {
                   return new RectHV(prev.getPoint().x(), prevRect.ymin(), prevRect.xmax(), prevRect.ymax());
               }
           }
           else {
               if(point.y() < prev.getPoint().y()) {
                   return new RectHV(prevRect.xmin(), prevRect.ymin(), prevRect.xmax(), prev.getPoint().y());
               }
               else {
                   return new RectHV(prevRect.xmin(), prev.getPoint().y(), prevRect.xmax(), prevRect.ymax());
               }
           }
           
           
       }
       
       public void draw() {
           StdDraw.setPenColor();
           StdDraw.setPenRadius(0.01);
           point.draw();
           StdDraw.setPenRadius();
           
           double minLineEnd = 0.0;
           double maxLineEnd = 1.0;
           
           if(prev == null) {
               StdDraw.setPenColor(StdDraw.RED);
               point.drawTo(new Point2D(point.x(), 0.0));
               point.drawTo(new Point2D(point.x(), 1.0));
           }
           else if (level % 2 != 0) {
               StdDraw.setPenColor(StdDraw.BLUE);
               if(point.x() < prev.getPoint().x()) {
                   maxLineEnd = prev.getPoint().x();
//                   if(prev.hasRight()) {
//                       minLineEnd = prev.getRight().getPoint().x();
//                   }
//                   else {
                       minLineEnd = 0.0;
//                   }
               }
               else {
                   minLineEnd =  prev.getPoint().x();
//                   if(prev.hasLeft()) {
//                       maxLineEnd = prev.getLeft().getPoint().x();
//                   }
//                   else {
                       maxLineEnd = 1.0;
//                   }
               }
//               minLineEnd = point.x() < prev.getPoint().x() ? 0.0 : prev.getPoint().x();
//               maxLineEnd = point.x() > prev.getPoint().x() ? 1.0 : prev.getPoint().x();
               
               point.drawTo(new Point2D(minLineEnd, point.y()));
               point.drawTo(new Point2D(maxLineEnd, point.y()));
           }
           else {
               StdDraw.setPenColor(StdDraw.RED);
               
               if(point.y() < prev.getPoint().y()) {
                   maxLineEnd = prev.getPoint().y();
//                   if(prev.hasRight()) {
//                       minLineEnd = prev.getRight().getPoint().y();
//                   }
//                   else {
                       minLineEnd = 0.0;
//                   }
               }
               else {
                   minLineEnd =  prev.getPoint().y();
//                   if(prev.hasLeft()) {
//                       maxLineEnd = prev.getLeft().getPoint().y();
//                   }
//                   else {
                       maxLineEnd = 1.0;
//                   }
               }
               
//               minLineEnd = point.y() < prev.getPoint().y() ? 0.0 : prev.getPoint().y();
//               maxLineEnd = point.y() > prev.getPoint().y() ? 1.0 : prev.getPoint().y();
               
               point.drawTo(new Point2D(point.x(), minLineEnd));
               point.drawTo(new Point2D(point.x(), maxLineEnd));
           }
//           System.out.println("minLineEnd: " + minLineEnd + "\nmaxLineEnd: " + maxLineEnd);
           StdDraw.setPenColor();
       }
       
       public void setLeft(Node2D left) {
           this.left = left;
       }
       
       public void setRight(Node2D right) {
           this.right = right;
       }
       
       public Node2D getLeft() {
           return left;
       }
       
       public Node2D getRight() {
           return right;
       }
       
       public Node2D getPrev() {
           return prev;
       }
       
       public Point2D getPoint() {
           return point;
       }
       
       public int getLevel() {
           return level;
       }
       
       public boolean hasRight() {
           return (right != null);
       }
       
       public boolean hasLeft() {
           return (left != null);
       }
       
       public boolean hasNext() {
           return (hasLeft() || hasRight());
       }
   
       public boolean hasPrev() {
           return prev != null;
       }
       
       public RectHV getRect() {
           return rect;
       }  
       
   }
}