import java.util.Arrays;
import java.util.Comparator;

public class BruteCollinearPoints {
		private int numberOfSegments = 0;
		private LineSegment[] segments = null;
//		private final Comparator<Point> slopi = new Point.slopeOrder();
	
	   // finds all line segments containing 4 points
	   public BruteCollinearPoints(Point[] points)   {
		   // check input
		   if (points == null) throw new IllegalArgumentException();
		   if (points[0] == null) throw new IllegalArgumentException();
		   for (int i = 0; i < points.length; i++) {
//			   System.out.println(points[i]);
			   
			   for(int j = i + 1; j < points.length; j++) {
				   if (points[j] == null) throw new IllegalArgumentException();
				   if (points[i].compareTo(points[j]) == 0) {
					   throw new IllegalArgumentException();
				   }
			   }
				   
		   }
		   segments = new LineSegment[points.length];
		findSegments(points);
		   
	   }
	   
	   private void findSegments(Point[] points) {
		   
		   LineSegment[] helper = new LineSegment [points.length];
		   numberOfSegments = 0;
		   
		   for (int i = 0; i < points.length; i++) {
//			   System.out.println("i: " + i);
			   int run = i+1;
			   double [] slopes = new double[points.length]; // memory error?
			   for(int j = i + 1; j < points.length; j++) {
				   
				   slopes[run] = points[i].slopeTo(points[j]); 
//				   System.out.println("slopes[" + run + "]: "+ slopes[run]);
				   run++;
			   }
			   
			   
			   for (int k = i+1; k <= run-3; k++) {
				   for (int l = k + 1; l <= run-2; l++) {
//					   System.out.println("Slopes: k,l " + slopes [k] +  ", " +slopes[l]);
					   if (slopes[l] == slopes [k]) {
//						   System.out.println("slopes match!");
						   for (int m = l + 1; m <= run-1; m++) {
//							   System.out.println("Slopes: k,m " + slopes [k] +  ", " +slopes[m]);
							   if (slopes[m] == slopes [k]) {
//								   System.out.println("slopes match!");
//								   for (int n = m + 1; n <= run; n++) {
//									   System.out.println("Slopes: k,n " + slopes [k] +  ", " +slopes[n]);
//									   if (slopes[n] == slopes [k]) {
										   
//										   System.out.println("slopes match!");
//										   System.out.println("k: " + k + " ,n: " + n);
//										   System.out.println("numberOfSegments: " + numberOfSegments);
//								   			System.out.println("points[" + i+ "]: "+ points[i] + "points[" + (i+k+1)+ "]: "+ points[i+k+1] + "points[" + (i+k+l) + "]: "+ points[i+k+l] + "points[" + (i+k+l+m) + "]: "+ points[i+k+m]);
											   //Find the maximum and minimumpoint and connect them
								   			Point[] linePoints = new Point[4];
								   			linePoints[0] = points[i];
								   			linePoints[1] = points[k];
								   			linePoints[2] = points[l];
								   			linePoints[3] = points[m];
//								   			System.out.println(linePoints[0]+"," +linePoints[1]+","+ linePoints[2]+","+ linePoints[3]);
								   			Comparator <Point> compi = new Point(32768, 32768).slopeOrder();
								   			Arrays.sort(linePoints,compi);
//								   			System.out.println(linePoints[0]+"," +linePoints[1]+","+ linePoints[2]+","+ linePoints[3]);
								   			helper[numberOfSegments] = new LineSegment(linePoints[0], linePoints[3]);
//								   			helper[numberOfSegments] = new LineSegment(points[i], points[i+k+l+m]);

//										   System.out.println("segments[" + numberOfSegments+ "]: " + helper[numberOfSegments].toString());
									       numberOfSegments++;
//									   }
//								   }
							   }
						   }
					   }
				   }
			   }
				   
		   }
//		   System.out.println("numberOfSegments: " + numberOfSegments);
		   segments = new LineSegment[numberOfSegments];
		   for(int i = 0; i < numberOfSegments; i++) {
			   segments[i] = helper[i];
		   }
		   
	   }
	   
	   // the number of line segments
	   public int numberOfSegments()    {
		  return numberOfSegments;
	   }
	   
	   // the line segments
	   public LineSegment[] segments()     {
		   return segments;
	   }
}
