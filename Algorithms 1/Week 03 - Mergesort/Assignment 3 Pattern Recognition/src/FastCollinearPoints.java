import java.util.Arrays;
import java.util.Comparator;

public class FastCollinearPoints {
	private int numberOfSegments = 0;
	private LineSegment[] segments = null;
		// finds all line segments containing 4 or more points
		public FastCollinearPoints(Point[] points) {
		
			//check for correct input
			if (points == null) throw new IllegalArgumentException();
			   if (points[0] == null) throw new IllegalArgumentException();
			   for (int i = 0; i < points.length; i++) {
//				   System.out.println(points[i]);
				   
				   for(int j = i + 1; j < points.length; j++) {
					   if (points[j] == null) throw new IllegalArgumentException();
					   if (points[i].compareTo(points[j]) == 0) {
						   throw new IllegalArgumentException();
					   }
				   }
					   
			   }
			   findSegments(points);
	   }
		
		private void findSegments(Point[] points) {
			LineSegment[] helper = new LineSegment [points.length];
			numberOfSegments = 0;
			   
			for (int i = 0; i < points.length; i++) {
				System.out.println("Taking point: " + points[i]);
				for (int x = i; x < points.length; x++)
					System.out.println(points[x]);
				System.out.println("++++++");
				
				Comparator <Point> compi = points[i].slopeOrder();
//				Arrays.sort(points,i , points.length , compi);
				Arrays.sort(points, compi);
				
				
				//create array with all slopes that are already sorted
				   int run = i + 1;
				   double [] slopes = new double[points.length];
				   for(int j = i +1 ; j < points.length; j++) {
					   
					   slopes[run] = points[i].slopeTo(points[j]); 
					   System.out.println("slopes[" + run + "]: "+ slopes[run]);
					   run++;
				   }
				   for (int x = i; x < points.length; x++)
						System.out.println(points[x] +", "+  slopes[x]);
				   
				   
				   //find same slopes in sorted array
				 for (int pointIndex = i+1; pointIndex < points.length-1; ) {//pointIndex++
					 int hits = 1;
					 for(int otherIndex = pointIndex + 1; otherIndex < points.length; otherIndex++) {
						 
						 if (slopes[pointIndex] == slopes[otherIndex]){ //&& slopes[pointIndex] == slopes[pointIndex+3]
							 hits++;
							 System.out.println("PointIndex: " + pointIndex + ", OtherIndex: " + otherIndex);
						 }
					 } 
					 
					 //check if we have a hit
					 if(hits >= 3) {
						 System.out.println("More than 3 hits: " + hits);
						 Point[] linePoints = new Point[hits +1];
						 linePoints[0] = points[i];
						 for(int hitIndex = 0; hitIndex < hits; hitIndex++) {
							 linePoints[hitIndex + 1] = points[pointIndex + hitIndex];
						 }
						 
						 Comparator <Point> compa = new Point(32768, 32768).slopeOrder();
				   		 Arrays.sort(linePoints,compa);
				   		 if(linePoints[0].slopeTo(points[i]) == (Double.NEGATIVE_INFINITY)) {
				   			 System.out.println("linePoints[0]: " + linePoints[0] + ", points[" + i + "]:" + points[i]);
				   			helper[numberOfSegments] = new LineSegment(linePoints[0], linePoints[hits]);
				   		 	numberOfSegments++;
				   		 }
				   			 
					 }
					pointIndex += hits; 
				 }
			}
			 segments = new LineSegment[numberOfSegments];
			   for(int i = 0; i < numberOfSegments; i++) {
				   segments[i] = helper[i];
			   }
//			   System.out.println("Ende");
		}
		
	   
	   // the number of line segments
	   public int numberOfSegments() {
		   return numberOfSegments;
	   }
	   
	      // the line segments
	   public LineSegment[] segments() {
		return segments;
	   }
}
