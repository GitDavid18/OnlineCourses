import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DequeTest {    
    Deque<Integer> testDeque = new Deque<Integer>();    
    
    
    @Test
    public void testEmptyDeque() {
        assertTrue( testDeque.isEmpty());
    }
    
    
//    testDeque.addFirst(5);
    
    @Test
    public void addFirst() {
        testDeque.addFirst(5);
        assertTrue(!testDeque.isEmpty());
    }
    
    @Test
    public void addLast() {
        testDeque.addLast(5);
        assertTrue(!testDeque.isEmpty());
    }
    
    @Test
    public void lengthTest() {
        testDeque.addFirst(5);
        assertEquals(1, testDeque.size());
    }
    
    @Test
    public void lengthShouldBeNull() {
        assertEquals(0, testDeque.size());
    }
    
    @Test
    public void checkLast() {
        testDeque.addFirst(5);
        assertEquals(new Integer(5), testDeque.removeLast());
    }
    
    @Test
    public void test3GetLast() {
        testDeque.addFirst(5);
        testDeque.addFirst(4);
        testDeque.addLast(8);
        assertEquals(new Integer(8), testDeque.removeLast());        
    }
    
    @Test
    public void test3GetFirst() {
        testDeque.addFirst(5);
        testDeque.addFirst(4);
        testDeque.addLast(8);
        assertEquals(new Integer(4), testDeque.removeFirst());        
    }
    @Test
    public void test3GetLength() {
        testDeque.addFirst(5);
        testDeque.addFirst(4);
        testDeque.addLast(8);
        assertEquals(3, testDeque.size());        
    }
    @Test
    public void add3remove2getFirst() {
        testDeque.addFirst(5);
        testDeque.addFirst(4);
        testDeque.addLast(8);
        testDeque.removeFirst();
        testDeque.removeFirst();
        assertEquals(new Integer(8), testDeque.removeLast());        
    }
    
    @Test
    public void printWholeTable() {
        testDeque.addFirst(5);
        testDeque.addFirst(4);
        testDeque.addLast(8);
    }
    
    
    @Test
    public void add3remove3getLength() {
//        System.out.println("Last test");
        testDeque.addFirst(5);
        testDeque.addFirst(4);
        testDeque.addLast(8);
        testDeque.removeFirst();
        testDeque.removeFirst();
        testDeque.removeFirst();
        assertEquals(0, testDeque.size());        
    }
    
    @Test
    public void add3remove3LastgetLength() {
//      System.out.println("Last test");
      testDeque.addFirst(5);
      testDeque.addFirst(4);
      testDeque.addLast(8);
      testDeque.removeLast();
      testDeque.removeLast();
//      testDeque.removeLast();
      assertEquals(new Integer(4), testDeque.removeLast());        
  }


}


