
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BruteTests {
	@Test
	void createWithEmptyArray(){
		assertThrows(IllegalArgumentException.class, () -> { BruteCollinearPoints bcp = new BruteCollinearPoints(null);});
	}
	
	@Test
	void createWithEmptyPoint(){
		assertThrows(IllegalArgumentException.class, () -> {
			Point[] points = new Point[3];
			points[0] = new Point(1, 1);
			points[1] = new Point(1, 2);		
			points[2] = null;
			
			BruteCollinearPoints bcp = new BruteCollinearPoints(points);
			});
	}
	
	@Test
	void createWithDoublePoint(){
		assertThrows(IllegalArgumentException.class, () -> {
			Point[] points = new Point[3];
			points[0] = new Point(1, 1);
			points[1] = new Point(1, 2);		
			points[2] = new Point(1, 2);
			
			BruteCollinearPoints bcp = new BruteCollinearPoints(points);
			});
	}
	
	@Test
	void testTheSlope(){
			Point[] points = new Point[4];
			points[0] = new Point(0, 4);
			points[3] = new Point(1, 3);		
			points[2] = new Point(3, 1);
			points[1] = new Point(4, 0);
			
			BruteCollinearPoints bcp = new BruteCollinearPoints(points);
			
			
	}

}
